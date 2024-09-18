package org.example.backend.common.primary.entity;

import java.io.Serializable;

/**
 * @Description: 系统签到奖励表
 * @Author: liwu3
 * @Date: 2024/09/16 22:15
 */
public class SystemSignReward implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 类型，0连续签到奖励，1累计签到奖励
     */
    private Integer type;

    /**
     * 天数
     */
    private Integer days;

    /**
     * 赠送积分
     */
    private Integer point;

    /**
     * 赠送经验
     */
    private Integer exp;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getDays() {
        return days;
    }

    public void setDays(Integer days) {
        this.days = days;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", type=").append(type);
        sb.append(", days=").append(days);
        sb.append(", point=").append(point);
        sb.append(", exp=").append(exp);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}