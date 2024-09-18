package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 门店店员表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemStoreStaff implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 微信用户id
     */
    private Integer uid;

    /**
     * 店员头像
     */
    private String avatar;

    /**
     * 门店id
     */
    private Integer storeId;

    /**
     * 店员名称
     */
    private String staffName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 核销开关
     */
    private Integer verifyStatus;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 添加时间
     */
    private Integer addTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getVerifyStatus() {
        return verifyStatus;
    }

    public void setVerifyStatus(Integer verifyStatus) {
        this.verifyStatus = verifyStatus;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", uid=").append(uid);
        sb.append(", avatar=").append(avatar);
        sb.append(", storeId=").append(storeId);
        sb.append(", staffName=").append(staffName);
        sb.append(", phone=").append(phone);
        sb.append(", verifyStatus=").append(verifyStatus);
        sb.append(", status=").append(status);
        sb.append(", addTime=").append(addTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}