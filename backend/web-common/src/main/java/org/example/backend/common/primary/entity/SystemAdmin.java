package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 后台管理员表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemAdmin implements Serializable {
    /**
     * 后台管理员表ID
     */
    private Integer id;

    /**
     * 后台管理员账号
     */
    private String account;

    /**
     * 管理员头像
     */
    private String headPic;

    /**
     * 后台管理员密码
     */
    private String pwd;

    /**
     * 后台管理员姓名
     */
    private String realName;

    /**
     * 后台管理员权限(menus_id)
     */
    private String roles;

    /**
     * 后台管理员最后一次登录ip
     */
    private String lastIp;

    /**
     * 后台管理员最后一次登录时间
     */
    private Integer lastTime;

    /**
     * 后台管理员添加时间
     */
    private Integer addTime;

    /**
     * 登录次数
     */
    private Integer loginCount;

    /**
     * 后台管理员级别
     */
    private Integer level;

    /**
     * 后台管理员状态 1有效0无效
     */
    private Integer status;

    /**
     * 事业部id
     */
    private Integer divisionId;

    /**
     * 是否删除
     */
    private Integer isDel;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getHeadPic() {
        return headPic;
    }

    public void setHeadPic(String headPic) {
        this.headPic = headPic;
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

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getLastIp() {
        return lastIp;
    }

    public void setLastIp(String lastIp) {
        this.lastIp = lastIp;
    }

    public Integer getLastTime() {
        return lastTime;
    }

    public void setLastTime(Integer lastTime) {
        this.lastTime = lastTime;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
    }

    public Integer getLoginCount() {
        return loginCount;
    }

    public void setLoginCount(Integer loginCount) {
        this.loginCount = loginCount;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(Integer divisionId) {
        this.divisionId = divisionId;
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
        sb.append(", id=").append(id);
        sb.append(", account=").append(account);
        sb.append(", headPic=").append(headPic);
        sb.append(", pwd=").append(pwd);
        sb.append(", realName=").append(realName);
        sb.append(", roles=").append(roles);
        sb.append(", lastIp=").append(lastIp);
        sb.append(", lastTime=").append(lastTime);
        sb.append(", addTime=").append(addTime);
        sb.append(", loginCount=").append(loginCount);
        sb.append(", level=").append(level);
        sb.append(", status=").append(status);
        sb.append(", divisionId=").append(divisionId);
        sb.append(", isDel=").append(isDel);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}