package org.example.backend.common.model;

import java.util.List;

/**
 * @Description: 树节点接口
 * @Author: liwu3
 * @Date: 2021/7/15 16:05
 */
public interface BaseTreeNode<ID> {

    /**
     * 获取节点id
     */
    ID getNodeId();

    /**
     * 获取节点父id
     */
    ID getNodeParentId();

    /**
     * 设置children
     */
    void setChildren(List children);

}
