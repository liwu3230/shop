package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 门店自提
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemStore implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 门店名称
     */
    private String name;

    /**
     * 简介
     */
    private String introduction;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 省市区
     */
    private String address;

    /**
     * 详细地址
     */
    private String detailedAddress;

    /**
     * 门店logo
     */
    private String image;

    /**
     * 门店推荐图
     */
    private String oblongImage;

    /**
     * 纬度
     */
    private String latitude;

    /**
     * 经度
     */
    private String longitude;

    /**
     * 核销有效日期
     */
    private String validTime;

    /**
     * 每日营业开关时间
     */
    private String dayTime;

    /**
     * 添加时间
     */
    private Integer addTime;

    /**
     * 是否显示
     */
    private Integer isShow;

    /**
     * 是否删除
     */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetailedAddress() {
        return detailedAddress;
    }

    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getOblongImage() {
        return oblongImage;
    }

    public void setOblongImage(String oblongImage) {
        this.oblongImage = oblongImage;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getValidTime() {
        return validTime;
    }

    public void setValidTime(String validTime) {
        this.validTime = validTime;
    }

    public String getDayTime() {
        return dayTime;
    }

    public void setDayTime(String dayTime) {
        this.dayTime = dayTime;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getIsShow() {
        return isShow;
    }

    public void setIsShow(Integer isShow) {
        this.isShow = isShow;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", introduction=").append(introduction);
        sb.append(", phone=").append(phone);
        sb.append(", address=").append(address);
        sb.append(", detailedAddress=").append(detailedAddress);
        sb.append(", image=").append(image);
        sb.append(", oblongImage=").append(oblongImage);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", validTime=").append(validTime);
        sb.append(", dayTime=").append(dayTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", isShow=").append(isShow);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}