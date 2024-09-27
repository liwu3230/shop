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

    private String icon = "folder";
    private Boolean creatable = true;
    private Boolean editable = true;
    private Boolean removable = true;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getCreatable() {
        return creatable;
    }

    public void setCreatable(Boolean creatable) {
        this.creatable = creatable;
    }

    public Boolean getEditable() {
        return editable;
    }

    public void setEditable(Boolean editable) {
        this.editable = editable;
    }

    public Boolean getRemovable() {
        return removable;
    }

    public void setRemovable(Boolean removable) {
        this.removable = removable;
    }
}
