package org.example.backend.common.model.dto;

import lombok.Data;
import org.example.backend.common.model.BaseTreeNode;
import org.example.backend.common.primary.entity.SysDept;
import org.example.backend.common.util.T;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/2 12:35
 */
@Data
public class SysDeptDto extends SysDept implements BaseTreeNode<Integer>, Serializable {

    private String fullName;

    private List<SysDeptDto> children = new ArrayList<>();

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

    public void setFullName(Map<Integer, SysDeptDto> allMap, String name,
                            Integer parentId) {
        StringBuilder fullName = new StringBuilder(name);
        if (T.noEQ(parentId, 0)) {
            SysDeptDto deptDto = allMap.get(parentId);
            while (deptDto != null && T.noEQ(deptDto.getParentId(), 0)) {
                fullName.insert(0, deptDto.getName() + "-");
                deptDto = allMap.get(deptDto.getParentId());
            }
            String pname = deptDto == null ? "" : deptDto.getName();
            fullName.insert(0, pname + "-");
        }
        this.fullName = fullName.toString();
    }
}
