package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 附件管理表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemAttachment implements Serializable {
    /**
     * 自增ID
     */
    private Integer attId;

    /**
     * 附件名称
     */
    private String name;

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
    private String attSize;

    /**
     * 附件类型
     */
    private String attType;

    /**
     * 分类ID0编辑器,1商品图片,2拼团图片,3砍价图片,4秒杀图片,5文章图片,6组合数据图
     */
    private Integer pid;

    /**
     * 上传时间
     */
    private Integer time;

    /**
     * 图片上传类型 1本地 2七牛云 3OSS 4COS 
     */
    private Integer imageType;

    /**
     * 图片上传模块类型 1 后台上传 2 用户生成
     */
    private Integer moduleType;

    /**
     * 原始文件名
     */
    private String realName;

    /**
     * 扫码上传的token
     */
    private String scanToken;

    private static final long serialVersionUID = 1L;

    public Integer getAttId() {
        return attId;
    }

    public void setAttId(Integer attId) {
        this.attId = attId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getAttSize() {
        return attSize;
    }

    public void setAttSize(String attSize) {
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

    public Integer getTime() {
        return time;
    }

    public void setTime(Integer time) {
        this.time = time;
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

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getScanToken() {
        return scanToken;
    }

    public void setScanToken(String scanToken) {
        this.scanToken = scanToken;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", attId=").append(attId);
        sb.append(", name=").append(name);
        sb.append(", attDir=").append(attDir);
        sb.append(", sattDir=").append(sattDir);
        sb.append(", attSize=").append(attSize);
        sb.append(", attType=").append(attType);
        sb.append(", pid=").append(pid);
        sb.append(", time=").append(time);
        sb.append(", imageType=").append(imageType);
        sb.append(", moduleType=").append(moduleType);
        sb.append(", realName=").append(realName);
        sb.append(", scanToken=").append(scanToken);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}