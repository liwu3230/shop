package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 通知设置
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemNotification implements Serializable {
    /**
     * 自增ID
     */
    private Integer id;

    /**
     * 标识
     */
    private String mark;

    /**
     * 通知类型
     */
    private String name;

    /**
     * 通知场景说明
     */
    private String title;

    /**
     * 站内信（0：不存在，1：开启，2：关闭）
     */
    private Integer isSystem;

    /**
     * 站内信标题
     */
    private String systemTitle;

    /**
     * 系统消息id
     */
    private String systemText;

    /**
     * 公众号模板消息（0：不存在，1：开启，2：关闭）
     */
    private Integer isWechat;

    /**
     * 模版消息tempkey
     */
    private String wechatTempkey;

    /**
     * 模版消息内容
     */
    private String wechatContent;

    /**
     * 模版消息kid
     */
    private String wechatKid;

    /**
     * 模版消息tempid
     */
    private String wechatTempid;

    /**
     * 模版消息参数
     */
    private String wechatData;

    /**
     * 模版消息链接
     */
    private String wechatLink;

    /**
     * 模版消息跳转小程序
     */
    private Integer wechatToRoutine;

    /**
     * 小程序订阅消息（0：不存在，1：开启，2：关闭）
     */
    private Integer isRoutine;

    /**
     * 订阅消息id
     */
    private String routineTempkey;

    /**
     * 订阅消息内容
     */
    private String routineContent;

    /**
     * 订阅消息kid
     */
    private String routineKid;

    /**
     * 订阅消息tempid
     */
    private String routineTempid;

    /**
     * 订阅消息参数
     */
    private String routineData;

    /**
     * 订阅消息链接
     */
    private String routineLink;

    /**
     * 发送短信（0：不存在，1：开启，2：关闭）
     */
    private Integer isSms;

    /**
     * 短信id
     */
    private String smsId;

    /**
     * 短信模版内容
     */
    private String smsText;

    /**
     * 企业微信群通知（0：不存在，1：开启，2：关闭）
     */
    private Integer isEntWechat;

    /**
     * 企业微信消息
     */
    private String entWechatText;

    /**
     * 群机器人链接
     */
    private String url;

    /**
     * APP推送（0：不存在，1：开启，2：关闭）
     */
    private Integer isApp;

    /**
     * app推送id
     */
    private Integer appId;

    /**
     * 变量
     */
    private String variable;

    /**
     * 类型（1：用户，2：管理员）
     */
    private Integer type;

    /**
     * 添加时间
     */
    private Integer addTime;

    /**
     * 自定义消息触发位置
     */
    private String customTrigger;

    /**
     * 自定义消息变量
     */
    private String customVariable;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getIsSystem() {
        return isSystem;
    }

    public void setIsSystem(Integer isSystem) {
        this.isSystem = isSystem;
    }

    public String getSystemTitle() {
        return systemTitle;
    }

    public void setSystemTitle(String systemTitle) {
        this.systemTitle = systemTitle;
    }

    public String getSystemText() {
        return systemText;
    }

    public void setSystemText(String systemText) {
        this.systemText = systemText;
    }

    public Integer getIsWechat() {
        return isWechat;
    }

    public void setIsWechat(Integer isWechat) {
        this.isWechat = isWechat;
    }

    public String getWechatTempkey() {
        return wechatTempkey;
    }

    public void setWechatTempkey(String wechatTempkey) {
        this.wechatTempkey = wechatTempkey;
    }

    public String getWechatContent() {
        return wechatContent;
    }

    public void setWechatContent(String wechatContent) {
        this.wechatContent = wechatContent;
    }

    public String getWechatKid() {
        return wechatKid;
    }

    public void setWechatKid(String wechatKid) {
        this.wechatKid = wechatKid;
    }

    public String getWechatTempid() {
        return wechatTempid;
    }

    public void setWechatTempid(String wechatTempid) {
        this.wechatTempid = wechatTempid;
    }

    public String getWechatData() {
        return wechatData;
    }

    public void setWechatData(String wechatData) {
        this.wechatData = wechatData;
    }

    public String getWechatLink() {
        return wechatLink;
    }

    public void setWechatLink(String wechatLink) {
        this.wechatLink = wechatLink;
    }

    public Integer getWechatToRoutine() {
        return wechatToRoutine;
    }

    public void setWechatToRoutine(Integer wechatToRoutine) {
        this.wechatToRoutine = wechatToRoutine;
    }

    public Integer getIsRoutine() {
        return isRoutine;
    }

    public void setIsRoutine(Integer isRoutine) {
        this.isRoutine = isRoutine;
    }

    public String getRoutineTempkey() {
        return routineTempkey;
    }

    public void setRoutineTempkey(String routineTempkey) {
        this.routineTempkey = routineTempkey;
    }

    public String getRoutineContent() {
        return routineContent;
    }

    public void setRoutineContent(String routineContent) {
        this.routineContent = routineContent;
    }

    public String getRoutineKid() {
        return routineKid;
    }

    public void setRoutineKid(String routineKid) {
        this.routineKid = routineKid;
    }

    public String getRoutineTempid() {
        return routineTempid;
    }

    public void setRoutineTempid(String routineTempid) {
        this.routineTempid = routineTempid;
    }

    public String getRoutineData() {
        return routineData;
    }

    public void setRoutineData(String routineData) {
        this.routineData = routineData;
    }

    public String getRoutineLink() {
        return routineLink;
    }

    public void setRoutineLink(String routineLink) {
        this.routineLink = routineLink;
    }

    public Integer getIsSms() {
        return isSms;
    }

    public void setIsSms(Integer isSms) {
        this.isSms = isSms;
    }

    public String getSmsId() {
        return smsId;
    }

    public void setSmsId(String smsId) {
        this.smsId = smsId;
    }

    public String getSmsText() {
        return smsText;
    }

    public void setSmsText(String smsText) {
        this.smsText = smsText;
    }

    public Integer getIsEntWechat() {
        return isEntWechat;
    }

    public void setIsEntWechat(Integer isEntWechat) {
        this.isEntWechat = isEntWechat;
    }

    public String getEntWechatText() {
        return entWechatText;
    }

    public void setEntWechatText(String entWechatText) {
        this.entWechatText = entWechatText;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getIsApp() {
        return isApp;
    }

    public void setIsApp(Integer isApp) {
        this.isApp = isApp;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public String getVariable() {
        return variable;
    }

    public void setVariable(String variable) {
        this.variable = variable;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public String getCustomTrigger() {
        return customTrigger;
    }

    public void setCustomTrigger(String customTrigger) {
        this.customTrigger = customTrigger;
    }

    public String getCustomVariable() {
        return customVariable;
    }

    public void setCustomVariable(String customVariable) {
        this.customVariable = customVariable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", mark=").append(mark);
        sb.append(", name=").append(name);
        sb.append(", title=").append(title);
        sb.append(", isSystem=").append(isSystem);
        sb.append(", systemTitle=").append(systemTitle);
        sb.append(", systemText=").append(systemText);
        sb.append(", isWechat=").append(isWechat);
        sb.append(", wechatTempkey=").append(wechatTempkey);
        sb.append(", wechatContent=").append(wechatContent);
        sb.append(", wechatKid=").append(wechatKid);
        sb.append(", wechatTempid=").append(wechatTempid);
        sb.append(", wechatData=").append(wechatData);
        sb.append(", wechatLink=").append(wechatLink);
        sb.append(", wechatToRoutine=").append(wechatToRoutine);
        sb.append(", isRoutine=").append(isRoutine);
        sb.append(", routineTempkey=").append(routineTempkey);
        sb.append(", routineContent=").append(routineContent);
        sb.append(", routineKid=").append(routineKid);
        sb.append(", routineTempid=").append(routineTempid);
        sb.append(", routineData=").append(routineData);
        sb.append(", routineLink=").append(routineLink);
        sb.append(", isSms=").append(isSms);
        sb.append(", smsId=").append(smsId);
        sb.append(", smsText=").append(smsText);
        sb.append(", isEntWechat=").append(isEntWechat);
        sb.append(", entWechatText=").append(entWechatText);
        sb.append(", url=").append(url);
        sb.append(", isApp=").append(isApp);
        sb.append(", appId=").append(appId);
        sb.append(", variable=").append(variable);
        sb.append(", type=").append(type);
        sb.append(", addTime=").append(addTime);
        sb.append(", customTrigger=").append(customTrigger);
        sb.append(", customVariable=").append(customVariable);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}