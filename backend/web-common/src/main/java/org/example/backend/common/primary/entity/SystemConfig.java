package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 配置表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemConfig implements Serializable {
    /**
     * 配置id
     */
    private Integer id;

    /**
     * 字段名称
     */
    private String menuName;

    /**
     * 类型(文本框,单选按钮...)
     */
    private String type;

    /**
     * 表单类型
     */
    private String inputType;

    /**
     * 配置分类id
     */
    private Integer configTabId;

    /**
     * 规则 单选框和多选框
     */
    private String parameter;

    /**
     * 上传文件格式1单图2多图3文件
     */
    private Integer uploadType;

    /**
     * 规则
     */
    private String required;

    /**
     * 多行文本框的宽度
     */
    private Integer width;

    /**
     * 多行文框的高度
     */
    private Integer high;

    /**
     * 默认值
     */
    private String value;

    /**
     * 配置名称
     */
    private String info;

    /**
     * 配置简介
     */
    private String desc;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * 是否隐藏
     */
    private Integer status;

    /**
     * 配置层级0顶级1次级
     */
    private Integer level;

    /**
     * 关联上级配置id
     */
    private Integer linkId;

    /**
     * 关联上级配置的值
     */
    private Integer linkValue;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public Integer getConfigTabId() {
        return configTabId;
    }

    public void setConfigTabId(Integer configTabId) {
        this.configTabId = configTabId;
    }

    public String getParameter() {
        return parameter;
    }

    public void setParameter(String parameter) {
        this.parameter = parameter;
    }

    public Integer getUploadType() {
        return uploadType;
    }

    public void setUploadType(Integer uploadType) {
        this.uploadType = uploadType;
    }

    public String getRequired() {
        return required;
    }

    public void setRequired(String required) {
        this.required = required;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getHigh() {
        return high;
    }

    public void setHigh(Integer high) {
        this.high = high;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public Integer getLinkValue() {
        return linkValue;
    }

    public void setLinkValue(Integer linkValue) {
        this.linkValue = linkValue;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", menuName=").append(menuName);
        sb.append(", type=").append(type);
        sb.append(", inputType=").append(inputType);
        sb.append(", configTabId=").append(configTabId);
        sb.append(", parameter=").append(parameter);
        sb.append(", uploadType=").append(uploadType);
        sb.append(", required=").append(required);
        sb.append(", width=").append(width);
        sb.append(", high=").append(high);
        sb.append(", value=").append(value);
        sb.append(", info=").append(info);
        sb.append(", desc=").append(desc);
        sb.append(", sort=").append(sort);
        sb.append(", status=").append(status);
        sb.append(", level=").append(level);
        sb.append(", linkId=").append(linkId);
        sb.append(", linkValue=").append(linkValue);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}