package org.example.backend.common.primary.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @Description: 用户表
 * @Author: liwu3
 * @Date: 2024/09/18 13:43
 */
public class User implements Serializable {
    /**
     * 用户id
     */
    private Integer uid;

    /**
     * 用户账号
     */
    private String account;

    /**
     * 用户密码
     */
    private String pwd;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 生日
     */
    private Integer birthday;

    /**
     * 身份证号码
     */
    private String cardId;

    /**
     * 用户备注
     */
    private String mark;

    /**
     * 合伙人id
     */
    private Integer partnerId;

    /**
     * 用户分组id
     */
    private Integer groupId;

    /**
     * 用户昵称
     */
    private String nickname;

    /**
     * 用户头像
     */
    private String avatar;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * 添加时间
     */
    private Date addTime;

    /**
     * 添加ip
     */
    private String addIp;

    /**
     * 最后一次登录时间
     */
    private Date lastTime;

    /**
     * 最后一次登录ip
     */
    private String lastIp;

    /**
     * 用户余额
     */
    private BigDecimal nowMoney;

    /**
     * 佣金金额
     */
    private BigDecimal brokeragePrice;

    /**
     * 用户剩余积分
     */
    private Integer integral;

    /**
     * 会员经验
     */
    private BigDecimal exp;

    /**
     * 连续签到天数
     */
    private Integer signNum;

    /**
     * 签到提醒状态
     */
    private Integer signRemind;

    /**
     * 1为正常，0为禁止
     */
    private Integer status;

    /**
     * 等级
     */
    private Integer level;

    /**
     * 分销等级
     */
    private Integer agentLevel;

    /**
     * 是否有推广资格
     */
    private Integer spreadOpen;

    /**
     * 推广元id
     */
    private Integer spreadUid;

    /**
     * 推广员关联时间
     */
    private Date spreadTime;

    /**
     * 用户类型
     */
    private String userType;

    /**
     * 是否为推广员
     */
    private Integer isPromoter;

    /**
     * 用户购买次数
     */
    private Integer payCount;

    /**
     * 下级人数
     */
    private Integer spreadCount;

    /**
     * 清理会员时间
     */
    private Date cleanTime;

    /**
     * 详细地址
     */
    private String addres;

    /**
     * 管理员编号 
     */
    private Integer adminid;

    /**
     * 用户登陆类型，h5,wechat,routine
     */
    private String loginType;

    /**
     * 记录临时电话
     */
    private String recordPhone;

    /**
     * 会员来源  0: 购买商品升级   1：花钱购买的会员2: 会员卡领取
     */
    private Integer isMoneyLevel;

    /**
     * 是否永久性会员  0: 非永久会员  1：永久会员
     */
    private Integer isEverLevel;

    /**
     * 会员到期时间
     */
    private Date overdueTime;

    /**
     * 用户唯一值
     */
    private String uniqid;

    /**
     * 事业部/代理商名称
     */
    private String divisionName;

    /**
     * 代理类型：0普通，1事业部，2代理，3员工
     */
    private Integer divisionType;

    /**
     * 代理状态
     */
    private Integer divisionStatus;

    /**
     * 事业部状态
     */
    private Integer isDivision;

    /**
     * 代理状态
     */
    private Integer isAgent;

    /**
     * 员工状态
     */
    private Integer isStaff;

    /**
     * 事业部id
     */
    private Integer divisionId;

    /**
     * 代理商id
     */
    private Integer agentId;

    /**
     * 员工id
     */
    private Integer staffId;

    /**
     * 分佣比例
     */
    private Integer divisionPercent;

    /**
     * 事业部/代理/员工修改时间
     */
    private Integer divisionChangeTime;

    /**
     * 事业部/代理/员工结束时间
     */
    private Integer divisionEndTime;

    /**
     * 代理商邀请码
     */
    private Integer divisionInvite;

    /**
     * 是否注销
     */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getBirthday() {
        return birthday;
    }

    public void setBirthday(Integer birthday) {
        this.birthday = birthday;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark;
    }

    public Integer getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(Integer partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getGroupId() {
        return groupId;
    }

    public void setGroupId(Integer groupId) {
        this.groupId = groupId;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public String getAddIp() {
        return addIp;
    }

    public void setAddIp(String addIp) {
        this.addIp = addIp;
    }

    public Date getLastTime() {
        return lastTime;
    }

    public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public BigDecimal getNowMoney() {
        return nowMoney;
    }

    public void setNowMoney(BigDecimal nowMoney) {
        this.nowMoney = nowMoney;
    }

    public BigDecimal getBrokeragePrice() {
        return brokeragePrice;
    }

    public void setBrokeragePrice(BigDecimal brokeragePrice) {
        this.brokeragePrice = brokeragePrice;
    }

    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    public BigDecimal getExp() {
        return exp;
    }

    public void setExp(BigDecimal exp) {
        this.exp = exp;
    }

    public Integer getSignNum() {
        return signNum;
    }

    public void setSignNum(Integer signNum) {
        this.signNum = signNum;
    }

    public Integer getSignRemind() {
        return signRemind;
    }

    public void setSignRemind(Integer signRemind) {
        this.signRemind = signRemind;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getAgentLevel() {
        return agentLevel;
    }

    public void setAgentLevel(Integer agentLevel) {
        this.agentLevel = agentLevel;
    }

    public Integer getSpreadOpen() {
        return spreadOpen;
    }

    public void setSpreadOpen(Integer spreadOpen) {
        this.spreadOpen = spreadOpen;
    }

    public Integer getSpreadUid() {
        return spreadUid;
    }

    public void setSpreadUid(Integer spreadUid) {
        this.spreadUid = spreadUid;
    }

    public Date getSpreadTime() {
        return spreadTime;
    }

    public void setSpreadTime(Date spreadTime) {
        this.spreadTime = spreadTime;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public Integer getIsPromoter() {
        return isPromoter;
    }

    public void setIsPromoter(Integer isPromoter) {
        this.isPromoter = isPromoter;
    }

    public Integer getPayCount() {
        return payCount;
    }

    public void setPayCount(Integer payCount) {
        this.payCount = payCount;
    }

    public Integer getSpreadCount() {
        return spreadCount;
    }

    public void setSpreadCount(Integer spreadCount) {
        this.spreadCount = spreadCount;
    }

    public Date getCleanTime() {
        return cleanTime;
    }

    public void setCleanTime(Date cleanTime) {
        this.cleanTime = cleanTime;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Integer getAdminid() {
        return adminid;
    }

    public void setAdminid(Integer adminid) {
        this.adminid = adminid;
    }

    public String getLoginType() {
        return loginType;
    }

    public void setLoginType(String loginType) {
        this.loginType = loginType;
    }

    public String getRecordPhone() {
        return recordPhone;
    }

    public void setRecordPhone(String recordPhone) {
        this.recordPhone = recordPhone;
    }

    public Integer getIsMoneyLevel() {
        return isMoneyLevel;
    }

    public void setIsMoneyLevel(Integer isMoneyLevel) {
        this.isMoneyLevel = isMoneyLevel;
    }

    public Integer getIsEverLevel() {
        return isEverLevel;
    }

    public void setIsEverLevel(Integer isEverLevel) {
        this.isEverLevel = isEverLevel;
    }

    public Date getOverdueTime() {
        return overdueTime;
    }

    public void setOverdueTime(Date overdueTime) {
        this.overdueTime = overdueTime;
    }

    public String getUniqid() {
        return uniqid;
    }

    public void setUniqid(String uniqid) {
        this.uniqid = uniqid;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String divisionName) {
        this.divisionName = divisionName;
    }

    public Integer getDivisionType() {
        return divisionType;
    }

    public void setDivisionType(Integer divisionType) {
        this.divisionType = divisionType;
    }

    public Integer getDivisionStatus() {
        return divisionStatus;
    }

    public void setDivisionStatus(Integer divisionStatus) {
        this.divisionStatus = divisionStatus;
    }

    public Integer getIsDivision() {
        return isDivision;
    }

    public void setIsDivision(Integer isDivision) {
        this.isDivision = isDivision;
    }

    public Integer getIsAgent() {
        return isAgent;
    }

    public void setIsAgent(Integer isAgent) {
        this.isAgent = isAgent;
    }

    public Integer getIsStaff() {
        return isStaff;
    }

    public void setIsStaff(Integer isStaff) {
        this.isStaff = isStaff;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
    }

    public Integer getAgentId() {
        return agentId;
    }

    public void setAgentId(Integer agentId) {
        this.agentId = agentId;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getDivisionPercent() {
        return divisionPercent;
    }

    public void setDivisionPercent(Integer divisionPercent) {
        this.divisionPercent = divisionPercent;
    }

    public Integer getDivisionChangeTime() {
        return divisionChangeTime;
    }

    public void setDivisionChangeTime(Integer divisionChangeTime) {
        this.divisionChangeTime = divisionChangeTime;
    }

    public Integer getDivisionEndTime() {
        return divisionEndTime;
    }

    public void setDivisionEndTime(Integer divisionEndTime) {
        this.divisionEndTime = divisionEndTime;
    }

    public Integer getDivisionInvite() {
        return divisionInvite;
    }

    public void setDivisionInvite(Integer divisionInvite) {
        this.divisionInvite = divisionInvite;
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
        sb.append(", uid=").append(uid);
        sb.append(", account=").append(account);
        sb.append(", pwd=").append(pwd);
        sb.append(", realName=").append(realName);
        sb.append(", birthday=").append(birthday);
        sb.append(", cardId=").append(cardId);
        sb.append(", mark=").append(mark);
        sb.append(", partnerId=").append(partnerId);
        sb.append(", groupId=").append(groupId);
        sb.append(", nickname=").append(nickname);
        sb.append(", avatar=").append(avatar);
        sb.append(", phone=").append(phone);
        sb.append(", addTime=").append(addTime);
        sb.append(", addIp=").append(addIp);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", nowMoney=").append(nowMoney);
        sb.append(", brokeragePrice=").append(brokeragePrice);
        sb.append(", integral=").append(integral);
        sb.append(", exp=").append(exp);
        sb.append(", signNum=").append(signNum);
        sb.append(", signRemind=").append(signRemind);
        sb.append(", status=").append(status);
        sb.append(", level=").append(level);
        sb.append(", agentLevel=").append(agentLevel);
        sb.append(", spreadOpen=").append(spreadOpen);
        sb.append(", spreadUid=").append(spreadUid);
        sb.append(", spreadTime=").append(spreadTime);
        sb.append(", userType=").append(userType);
        sb.append(", isPromoter=").append(isPromoter);
        sb.append(", payCount=").append(payCount);
        sb.append(", spreadCount=").append(spreadCount);
        sb.append(", cleanTime=").append(cleanTime);
        sb.append(", addres=").append(addres);
        sb.append(", adminid=").append(adminid);
        sb.append(", loginType=").append(loginType);
        sb.append(", recordPhone=").append(recordPhone);
        sb.append(", isMoneyLevel=").append(isMoneyLevel);
        sb.append(", isEverLevel=").append(isEverLevel);
        sb.append(", overdueTime=").append(overdueTime);
        sb.append(", uniqid=").append(uniqid);
        sb.append(", divisionName=").append(divisionName);
        sb.append(", divisionType=").append(divisionType);
        sb.append(", divisionStatus=").append(divisionStatus);
        sb.append(", isDivision=").append(isDivision);
        sb.append(", isAgent=").append(isAgent);
        sb.append(", isStaff=").append(isStaff);
        sb.append(", divisionId=").append(divisionId);
        sb.append(", agentId=").append(agentId);
        sb.append(", staffId=").append(staffId);
        sb.append(", divisionPercent=").append(divisionPercent);
        sb.append(", divisionChangeTime=").append(divisionChangeTime);
        sb.append(", divisionEndTime=").append(divisionEndTime);
        sb.append(", divisionInvite=").append(divisionInvite);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}