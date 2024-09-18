package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 云储存
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemStorage implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * access_key
     */
    private String accessKey;

    /**
     * 1=本地存储,2=七牛,3=oss,4=cos
     */
    private Integer type;

    /**
     * 空间名
     */
    private String name;

    /**
     * 地域
     */
    private String region;

    /**
     * 权限
     */
    private String acl;

    /**
     * 空间域名
     */
    private String domain;

    /**
     * CDN加速域名
     */
    private String cdn;

    /**
     * CNAME值
     */
    private String cname;

    /**
     * 0=http,1=https
     */
    private Integer isSsl;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 是否删除
     */
    private Integer isDelete;

    /**
     * 添加事件
     */
    private Integer addTime;

    /**
     * 更新事件
     */
    private Integer updateTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getAcl() {
        return acl;
    }

    public void setAcl(String acl) {
        this.acl = acl;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getCdn() {
        return cdn;
    }

    public void setCdn(String cdn) {
        this.cdn = cdn;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Integer getIsSsl() {
        return isSsl;
    }

    public void setIsSsl(Integer isSsl) {
        this.isSsl = isSsl;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Integer updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", accessKey=").append(accessKey);
        sb.append(", type=").append(type);
        sb.append(", name=").append(name);
        sb.append(", region=").append(region);
        sb.append(", acl=").append(acl);
        sb.append(", domain=").append(domain);
        sb.append(", cdn=").append(cdn);
        sb.append(", cname=").append(cname);
        sb.append(", isSsl=").append(isSsl);
        sb.append(", status=").append(status);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", addTime=").append(addTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}