package org.example.backend.common.model.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.example.backend.common.model.BaseTreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/9 23:15
 */
@Data
@EqualsAndHashCode
@ToString
public class SysCityTreeDto implements BaseTreeNode<Integer>, Serializable {

    private Integer id;
    private Integer parentId;
    private Integer cityId;
    private String name;
    private String mergerName;

    private List<SysCityTreeDto> children = new ArrayList<>();

    @Override
    public Integer getNodeId() {
        return this.getCityId();
    }

    @Override
    public Integer getNodeParentId() {
        return this.getParentId();
    }

    @Override
    public void setChildren(List children) {
        this.children = children;
    }

}
