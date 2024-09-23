package org.example.backend.common.model.dto;

import org.example.backend.common.model.BaseTreeNode;
import org.example.backend.common.primary.entity.SysAttachmentCategory;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 15:36
 */
public class SysAttCategoryTreeDto extends SysAttachmentCategory implements BaseTreeNode {

    private List children;

    @Override
    public Integer getNodeId() {
        return this.getId();
    }

    @Override
    public Integer getNodeParentId() {
        return this.getPid();
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

    public List getChildren() {
        return children;
    }

}
