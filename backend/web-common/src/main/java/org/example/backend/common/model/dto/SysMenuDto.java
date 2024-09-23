package org.example.backend.common.model.dto;

import lombok.Data;
import org.example.backend.common.model.BaseTreeNode;
import org.example.backend.common.primary.entity.SysMenu;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:14
 */
@Data
public class SysMenuDto extends SysMenu implements BaseTreeNode<Integer>, Serializable {

    private List<SysMenuDto> children = new ArrayList<>();

    @Override
    public Integer getNodeId() {
        return this.getId();
    }

    @Override
    public Integer getNodeParentId() {
        return this.getParentId();
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    /**
     * 返回此节点和递归搜索其所有子节点
     *
     * @return
     */
    public Stream<SysMenuDto> descendants() {
        return Stream.concat(
                Stream.of(this),
                children.stream().flatMap(SysMenuDto::descendants));
    }

}
