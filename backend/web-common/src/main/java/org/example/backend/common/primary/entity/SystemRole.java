package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 身份管理表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemRole implements Serializable {
    /**
     * 身份管理id
     */
    private Integer id;

    /**
     * 身份管理名称
     */
    private String roleName;

    /**
     * 身份管理权限(menus_id)
     */
    private String rules;

    /**
     * 管理员等级
     */
    private Integer level;

    /**
     * 状态
     */
    private Integer status;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRules() {
        return rules;
    }

    public void setRules(String rules) {
        this.rules = rules;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", roleName=").append(roleName);
        sb.append(", rules=").append(rules);
        sb.append(", level=").append(level);
        sb.append(", status=").append(status);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}