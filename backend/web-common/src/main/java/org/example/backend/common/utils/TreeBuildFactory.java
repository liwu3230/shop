package org.example.backend.common.utils;

import org.example.backend.common.model.BaseTreeNode;
import org.springframework.util.CollectionUtils;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/15 15:58
 */
public class TreeBuildFactory {

    public static <T extends BaseTreeNode> List<T> transToTree(List<T> nodes) {
        return transToTree(nodes, null);
    }

    public static <T extends BaseTreeNode> List<T> transToTree(List<T> nodes, Comparator<T> comparator) {
        if (CollectionUtils.isEmpty(nodes)) {
            return Collections.emptyList();
        }
        Map<Object, T> sourceMap = nodes.stream().collect(Collectors.toMap(BaseTreeNode::getNodeId, e -> e));
        Map<Object, List<T>> pIdToChildrenListMap = nodes.stream().filter(Objects::nonNull).filter((e) -> Objects.nonNull(e.getNodeParentId())).collect(Collectors.groupingBy(BaseTreeNode::getNodeParentId));
        List<Object> willBeRemovedIdList = new LinkedList<>();
        for (Map.Entry<Object, List<T>> entry : pIdToChildrenListMap.entrySet()) {
            T node = sourceMap.get(entry.getKey());
            if (node == null) {
                continue;
            }
            //是否排序
            if (comparator == null) {
                node.setChildren(entry.getValue());
            } else {
                node.setChildren(entry.getValue().stream().sorted(comparator).collect(Collectors.toList()));
            }
            willBeRemovedIdList.add(entry.getKey());
        }
        willBeRemovedIdList.forEach(pIdToChildrenListMap::remove);
        //是否排序
        if (comparator == null) {
            return pIdToChildrenListMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
        } else {
            return pIdToChildrenListMap.values().stream().flatMap(Collection::stream).sorted(comparator).collect(Collectors.toList());
        }
    }

    public static List<Map<String, Object>> transToTree(List<Map<String, Object>> nodes, String idKey, String pidKey) {
        if (CollectionUtils.isEmpty(nodes)) {
            return Collections.emptyList();
        }
        Map<Object, Map<String, Object>> sourceMap = nodes.stream().collect(Collectors.toMap(e -> e.get(idKey), e -> e));
        Map<Object, List<Map<String, Object>>> pIdToChildrenListMap = nodes.stream().filter(Objects::nonNull).filter((e) -> Objects.nonNull(e.get(pidKey))).collect(Collectors.groupingBy(e -> e.get(pidKey)));
        List<Object> willBeRemovedIdList = new LinkedList<>();
        for (Map.Entry<Object, List<Map<String, Object>>> entry : pIdToChildrenListMap.entrySet()) {
            Map<String, Object> node = sourceMap.get(entry.getKey());
            if (node == null) {
                continue;
            }
            node.put("children", entry.getValue());
            willBeRemovedIdList.add(entry.getKey());
        }
        willBeRemovedIdList.forEach(pIdToChildrenListMap::remove);
        return pIdToChildrenListMap.values().stream().flatMap(Collection::stream).collect(Collectors.toList());
    }


}
