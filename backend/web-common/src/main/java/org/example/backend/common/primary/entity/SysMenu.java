package org.example.backend.common.primary.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 菜单
 * @Author: liwu3
 * @Date: 2022/09/30 23:53
 */
public class SysMenu implements Serializable {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 父id
     */
    private Integer parentId;

    /**
     * 层级路径
     */
    private String path;

    /**
     * 名称
     */
    private String name;

    /**
     * 菜单类型（0目录 1菜单 2按钮）
     */
    private Integer type;

    /**
     * 图标
     */
    private String icon;

    /**
     * 路由地址
     */
    private String router;

    /**
     * 是否显示面包屑（1-是，0-否）
     */
    private Integer isBreadCrumb;

    /**
     * 后端访问路径
     */
    private String permissionPath;

    /**
     * 授权(多个用逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 打开方式（1默认 2当前页链接 3新窗口链接）
     */
    private Integer openType;

    /**
     * 链接地址
     */
    private String link;

    /**
     * 重定向地址
     */
    private String redirect;

    /**
     * 是否可见（1-是，0-否）
     */
    private Integer visible;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 备注
     */
    private String remark;

    /**
     * 是否初始化菜单 0:否 1:是
     */
    private Integer isInit;

    /**
     * 新增用户
     */
    private String creator;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改用户
     */
    private String updater;

    /**
     * 更新时间
     */
    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getRouter() {
        return router;
    }

    public void setRouter(String router) {
        this.router = router;
    }

    public Integer getIsBreadCrumb() {
        return isBreadCrumb;
    }

    public void setIsBreadCrumb(Integer isBreadCrumb) {
        this.isBreadCrumb = isBreadCrumb;
    }

    public String getPermissionPath() {
        return permissionPath;
    }

    public void setPermissionPath(String permissionPath) {
        this.permissionPath = permissionPath;
    }

    public String getPerms() {
        return perms;
    }

    public void setPerms(String perms) {
        this.perms = perms;
    }

    public Integer getOpenType() {
        return openType;
    }

    public void setOpenType(Integer openType) {
        this.openType = openType;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getRedirect() {
        return redirect;
    }

    public void setRedirect(String redirect) {
        this.redirect = redirect;
    }

    public Integer getVisible() {
        return visible;
    }

    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getIsInit() {
        return isInit;
    }

    public void setIsInit(Integer isInit) {
        this.isInit = isInit;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdater() {
        return updater;
    }

    public void setUpdater(String updater) {
        this.updater = updater;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", parentId=").append(parentId);
        sb.append(", path=").append(path);
        sb.append(", name=").append(name);
        sb.append(", type=").append(type);
        sb.append(", icon=").append(icon);
        sb.append(", router=").append(router);
        sb.append(", isBreadCrumb=").append(isBreadCrumb);
        sb.append(", permissionPath=").append(permissionPath);
        sb.append(", perms=").append(perms);
        sb.append(", openType=").append(openType);
        sb.append(", link=").append(link);
        sb.append(", redirect=").append(redirect);
        sb.append(", visible=").append(visible);
        sb.append(", sort=").append(sort);
        sb.append(", remark=").append(remark);
        sb.append(", isInit=").append(isInit);
        sb.append(", creator=").append(creator);
        sb.append(", createTime=").append(createTime);
        sb.append(", updater=").append(updater);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}