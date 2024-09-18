package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 管理员操作记录表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemLog implements Serializable {
    /**
     * 管理员操作记录ID
     */
    private Long id;

    /**
     * 管理员id
     */
    private Integer adminId;

    /**
     * 管理员姓名
     */
    private String adminName;

    /**
     * 链接
     */
    private String path;

    /**
     * 行为
     */
    private String page;

    /**
     * 访问类型
     */
    private String method;

    /**
     * 登录IP
     */
    private String ip;

    /**
     * 类型
     */
    private String type;

    /**
     * 操作时间
     */
    private Integer addTime;

    /**
     * 商户id
     */
    private Integer merchantId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", adminId=").append(adminId);
        sb.append(", adminName=").append(adminName);
        sb.append(", path=").append(path);
        sb.append(", page=").append(page);
        sb.append(", method=").append(method);
        sb.append(", ip=").append(ip);
        sb.append(", type=").append(type);
        sb.append(", addTime=").append(addTime);
        sb.append(", merchantId=").append(merchantId);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}