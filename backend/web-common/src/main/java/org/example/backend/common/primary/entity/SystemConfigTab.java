package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 配置分类表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemConfigTab implements Serializable {
    /**
     * 配置分类id
     */
    private Integer id;

    /**
     * 上级分类id
     */
    private Integer pid;

    /**
     * 配置分类名称
     */
    private String title;

    /**
     * 配置分类英文名称
     */
    private String engTitle;

    /**
     * 配置分类状态
     */
    private Integer status;

    /**
     * 配置分类是否显示
     */
    private Integer info;

    /**
     * 图标
     */
    private String icon;

    /**
     * 配置类型
     */
    private Integer type;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 菜单ID
     */
    private Integer menusId;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEngTitle() {
        return engTitle;
    }

    public void setEngTitle(String engTitle) {
        this.engTitle = engTitle;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getInfo() {
        return info;
    }

    public void setInfo(Integer info) {
        this.info = info;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getMenusId() {
        return menusId;
    }

    public void setMenusId(Integer menusId) {
        this.menusId = menusId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", title=").append(title);
        sb.append(", engTitle=").append(engTitle);
        sb.append(", status=").append(status);
        sb.append(", info=").append(info);
        sb.append(", icon=").append(icon);
        sb.append(", type=").append(type);
        sb.append(", sort=").append(sort);
        sb.append(", menusId=").append(menusId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}