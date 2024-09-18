package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 通知记录表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemNoticeAdmin implements Serializable {
    /**
     * 通知记录ID
     */
    private Integer id;

    /**
     * 通知类型
     */
    private String noticeType;

    /**
     * 通知的管理员
     */
    private Short adminId;

    /**
     * 关联ID
     */
    private Integer linkId;

    /**
     * 通知的数据
     */
    private String tableData;

    /**
     * 点击次数
     */
    private Integer isClick;

    /**
     * 访问次数
     */
    private Integer isVisit;

    /**
     * 访问时间
     */
    private Integer visitTime;

    /**
     * 通知时间
     */
    private Integer addTime;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNoticeType() {
        return noticeType;
    }

    public void setNoticeType(String noticeType) {
        this.noticeType = noticeType;
    }

    public Short getAdminId() {
        return adminId;
    }

    public void setAdminId(Short adminId) {
        this.adminId = adminId;
    }

    public Integer getLinkId() {
        return linkId;
    }

    public void setLinkId(Integer linkId) {
        this.linkId = linkId;
    }

    public String getTableData() {
        return tableData;
    }

    public void setTableData(String tableData) {
        this.tableData = tableData;
    }

    public Integer getIsClick() {
        return isClick;
    }

    public void setIsClick(Integer isClick) {
        this.isClick = isClick;
    }

    public Integer getIsVisit() {
        return isVisit;
    }

    public void setIsVisit(Integer isVisit) {
        this.isVisit = isVisit;
    }

    public Integer getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(Integer visitTime) {
        this.visitTime = visitTime;
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
        sb.append(", noticeType=").append(noticeType);
        sb.append(", adminId=").append(adminId);
        sb.append(", linkId=").append(linkId);
        sb.append(", tableData=").append(tableData);
        sb.append(", isClick=").append(isClick);
        sb.append(", isVisit=").append(isVisit);
        sb.append(", visitTime=").append(visitTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}