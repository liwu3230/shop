package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 用户角色关联表
 * @Author: liwu3
 * @Date: 2022/09/30 23:53
 */
public class SysUserRoleKey implements Serializable {
    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 角色表id
     */
    private Integer roleId;

    private static final long serialVersionUID = 1L;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", userId=").append(userId);
        sb.append(", roleId=").append(roleId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}