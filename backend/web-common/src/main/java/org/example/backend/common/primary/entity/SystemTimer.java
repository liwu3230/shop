package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 定时器
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemTimer implements Serializable {
    private Integer id;

    /**
     * 定时器名称
     */
    private String name;

    /**
     * 标签
     */
    private String mark;

    /**
     * 说明
     */
    private String content;

    /**
     * 周期状态 1=每隔多少秒 2=每隔多少分钟 3=每隔多少小时 4=每隔多少天 5=每天几点执行 6=每周周几几点执行 7=每月几号几点执行
     */
    private Integer type;

    /**
     * 月
     */
    private Integer month;

    /**
     * 周
     */
    private Integer week;

    /**
     * 日
     */
    private Integer day;

    /**
     * 时
     */
    private Integer hour;

    /**
     * 分
     */
    private Integer minute;

    /**
     * 秒
     */
    private Integer second;

    /**
     * 上次执行时间
     */
    private Integer lastExecutionTime;

    /**
     * 下次执行时间
     */
    private Integer nextExecutionTime;

    /**
     * 添加时间
     */
    private Integer addTime;

    /**
     * 是否删除
     */
    private Integer isDel;

    /**
     * 是否开启
     */
    private Integer isOpen;

    /**
     * 执行代码
     */
    private String customcode;

    /**
     * 时间代码
     */
    private String timestr;

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

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getWeek() {
        return week;
    }

    public void setWeek(Integer week) {
        this.week = week;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinute() {
        return minute;
    }

    public void setMinute(Integer minute) {
        this.minute = minute;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getLastExecutionTime() {
        return lastExecutionTime;
    }

    public void setLastExecutionTime(Integer lastExecutionTime) {
        this.lastExecutionTime = lastExecutionTime;
    }

    public Integer getNextExecutionTime() {
        return nextExecutionTime;
    }

    public void setNextExecutionTime(Integer nextExecutionTime) {
        this.nextExecutionTime = nextExecutionTime;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

    public Integer getIsOpen() {
        return isOpen;
    }

    public void setIsOpen(Integer isOpen) {
        this.isOpen = isOpen;
    }

    public String getCustomcode() {
        return customcode;
    }

    public void setCustomcode(String customcode) {
        this.customcode = customcode;
    }

    public String getTimestr() {
        return timestr;
    }

    public void setTimestr(String timestr) {
        this.timestr = timestr;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", name=").append(name);
        sb.append(", mark=").append(mark);
        sb.append(", content=").append(content);
        sb.append(", type=").append(type);
        sb.append(", month=").append(month);
        sb.append(", week=").append(week);
        sb.append(", day=").append(day);
        sb.append(", hour=").append(hour);
        sb.append(", minute=").append(minute);
        sb.append(", second=").append(second);
        sb.append(", lastExecutionTime=").append(lastExecutionTime);
        sb.append(", nextExecutionTime=").append(nextExecutionTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", isDel=").append(isDel);
        sb.append(", isOpen=").append(isOpen);
        sb.append(", customcode=").append(customcode);
        sb.append(", timestr=").append(timestr);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}