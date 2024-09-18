package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 城市表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemCity implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 城市id
     */
    private Integer cityId;

    /**
     * 省市级别
     */
    private Integer level;

    /**
     * 父级id
     */
    private Integer parentId;

    /**
     * 区号
     */
    private String areaCode;

    /**
     * 名称
     */
    private String name;

    /**
     * 合并名称
     */
    private String mergerName;

    /**
     * 经度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 是否展示
     */
    private Integer isShow;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMergerName() {
        return mergerName;
    }

    public void setMergerName(String mergerName) {
        this.mergerName = mergerName;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", cityId=").append(cityId);
        sb.append(", level=").append(level);
        sb.append(", parentId=").append(parentId);
        sb.append(", areaCode=").append(areaCode);
        sb.append(", name=").append(name);
        sb.append(", mergerName=").append(mergerName);
        sb.append(", lng=").append(lng);
        sb.append(", lat=").append(lat);
        sb.append(", isShow=").append(isShow);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}