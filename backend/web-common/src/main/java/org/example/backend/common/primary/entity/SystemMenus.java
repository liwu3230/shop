package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 菜单表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemMenus implements Serializable {
    /**
     * 菜单ID
     */
    private Integer id;

    /**
     * 父级id
     */
    private Integer pid;

    /**
     * 图标
     */
    private String icon;

    /**
     * 按钮名
     */
    private String menuName;

    /**
     * 模块名
     */
    private String module;

    /**
     * 控制器
     */
    private String controller;

    /**
     * 方法名
     */
    private String action;

    /**
     * api接口地址
     */
    private String apiUrl;

    /**
     * 提交方式POST GET PUT DELETE
     */
    private String methods;

    /**
     * 参数
     */
    private String params;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否为隐藏菜单0=隐藏菜单,1=显示菜单
     */
    private Integer isShow;

    /**
     * 是否为隐藏菜单供前台使用
     */
    private Integer isShowPath;

    /**
     * 子管理员是否可用
     */
    private Integer access;

    /**
     * 路由名称 前端使用
     */
    private String menuPath;

    /**
     * 路径
     */
    private String path;

    /**
     * 是否为菜单 1菜单 2功能
     */
    private Integer authType;

    /**
     * 顶部菜单标示
     */
    private String header;

    /**
     * 是否顶部菜单1是0否
     */
    private Integer isHeader;

    /**
     * 前台唯一标识
     */
    private String uniqueAuth;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 备注
     */
    private String mark;

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

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public String getController() {
        return controller;
    }

    public void setController(String controller) {
        this.controller = controller;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public void setApiUrl(String apiUrl) {
        this.apiUrl = apiUrl;
    }

    public String getMethods() {
        return methods;
    }

    public void setMethods(String methods) {
        this.methods = methods;
    }

    public String getParams() {
        return params;
    }

    public void setParams(String params) {
        this.params = params;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsShowPath() {
        return isShowPath;
    }

    public void setIsShowPath(Integer isShowPath) {
        this.isShowPath = isShowPath;
    }

    public Integer getAccess() {
        return access;
    }

    public void setAccess(Integer access) {
        this.access = access;
    }

    public String getMenuPath() {
        return menuPath;
    }

    public void setMenuPath(String menuPath) {
        this.menuPath = menuPath;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Integer getAuthType() {
        return authType;
    }

    public void setAuthType(Integer authType) {
        this.authType = authType;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public Integer getIsHeader() {
        return isHeader;
    }

    public void setIsHeader(Integer isHeader) {
        this.isHeader = isHeader;
    }

    public String getUniqueAuth() {
        return uniqueAuth;
    }

    public void setUniqueAuth(String uniqueAuth) {
        this.uniqueAuth = uniqueAuth;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", pid=").append(pid);
        sb.append(", icon=").append(icon);
        sb.append(", menuName=").append(menuName);
        sb.append(", module=").append(module);
        sb.append(", controller=").append(controller);
        sb.append(", action=").append(action);
        sb.append(", apiUrl=").append(apiUrl);
        sb.append(", methods=").append(methods);
        sb.append(", params=").append(params);
        sb.append(", sort=").append(sort);
        sb.append(", isShow=").append(isShow);
        sb.append(", isShowPath=").append(isShowPath);
        sb.append(", access=").append(access);
        sb.append(", menuPath=").append(menuPath);
        sb.append(", path=").append(path);
        sb.append(", authType=").append(authType);
        sb.append(", header=").append(header);
        sb.append(", isHeader=").append(isHeader);
        sb.append(", uniqueAuth=").append(uniqueAuth);
        sb.append(", isDel=").append(isDel);
        sb.append(", mark=").append(mark);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}