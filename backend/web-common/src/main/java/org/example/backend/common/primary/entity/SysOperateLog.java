package org.example.backend.common.primary.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @Description: 操作日志
 * @Author: liwu3
 * @Date: 2024/04/05 23:47
 */
public class SysOperateLog implements Serializable {
    private Long id;

    /**
     * 操作类型
     */
    private String opType;

    /**
     * 操作对象
     */
    private String subject;

    /**
     * 扩展操作对象
     */
    private String subjectExt;

    /**
     * 操作内容
     */
    private String content;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 操作用户ip
     */
    private String userIp;

    /**
     * 操作用户
     */
    private String userId;

    /**
     * 操作用户账号
     */
    private String userName;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getSubjectExt() {
        return subjectExt;
    }

    public void setSubjectExt(String subjectExt) {
        this.subjectExt = subjectExt;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUserIp() {
        return userIp;
    }

    public void setUserIp(String userIp) {
        this.userIp = userIp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", opType=").append(opType);
        sb.append(", subject=").append(subject);
        sb.append(", subjectExt=").append(subjectExt);
        sb.append(", content=").append(content);
        sb.append(", remark=").append(remark);
        sb.append(", createTime=").append(createTime);
        sb.append(", userIp=").append(userIp);
        sb.append(", userId=").append(userId);
        sb.append(", userName=").append(userName);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}