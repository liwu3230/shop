package org.example.backend.common.primary.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 附件表
 * @Author: liwu3
 * @Date: 2024/09/24 16:26
 */
public class SysAttachment implements Serializable {
    /**
     * 自增ID
     */
    private Long attId;

    /**
     * 附件名称
     */
    private String name;

    /**
     * 原始文件名
     */
    private String realName;

    /**
     * 附件路径
     */
    private String attDir;

    /**
     * 压缩图片路径
     */
    private String sattDir;

    /**
     * 附件大小
     */
    private Long attSize;

    /**
     * 附件类型
     */
    private String attType;

    /**
     * 分类ID
     */
    private Integer pid;

    /**
     * 图片上传类型 1本地 2OSS 
     */
    private Integer imageType;

    /**
     * 图片上传模块类型 1 后台上传 2 用户上传
     */
    private Integer moduleType;

    /**
     * 上传时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 扫码上传的token
     */
    private String scanToken;

    /**
     * 上传用户
     */
    private String userName;

    /**
     * 下载地址
     */
    private String downloadUrl;

    private static final long serialVersionUID = 1L;

    public Long getAttId() {
        return attId;
    }

    public void setAttId(Long attId) {
        this.attId = attId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getAttDir() {
        return attDir;
    }

    public void setAttDir(String attDir) {
        this.attDir = attDir;
    }

    public String getSattDir() {
        return sattDir;
    }

    public void setSattDir(String sattDir) {
        this.sattDir = sattDir;
    }

    public Long getAttSize() {
        return attSize;
    }

    public void setAttSize(Long attSize) {
        this.attSize = attSize;
    }

    public String getAttType() {
        return attType;
    }

    public void setAttType(String attType) {
        this.attType = attType;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Integer getImageType() {
        return imageType;
    }

    public void setImageType(Integer imageType) {
        this.imageType = imageType;
    }

    public Integer getModuleType() {
        return moduleType;
    }

    public void setModuleType(Integer moduleType) {
        this.moduleType = moduleType;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getScanToken() {
        return scanToken;
    }

    public void setScanToken(String scanToken) {
        this.scanToken = scanToken;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attId=").append(attId);
        sb.append(", name=").append(name);
        sb.append(", realName=").append(realName);
        sb.append(", attDir=").append(attDir);
        sb.append(", sattDir=").append(sattDir);
        sb.append(", attSize=").append(attSize);
        sb.append(", attType=").append(attType);
        sb.append(", pid=").append(pid);
        sb.append(", imageType=").append(imageType);
        sb.append(", moduleType=").append(moduleType);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remark=").append(remark);
        sb.append(", scanToken=").append(scanToken);
        sb.append(", userName=").append(userName);
        sb.append(", downloadUrl=").append(downloadUrl);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}