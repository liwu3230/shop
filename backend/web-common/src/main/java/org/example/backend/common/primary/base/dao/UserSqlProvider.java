package org.example.backend.common.primary.base.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;
import org.example.backend.common.primary.entity.User;
import org.example.backend.common.primary.entity.UserExample.Criteria;
import org.example.backend.common.primary.entity.UserExample.Criterion;
import org.example.backend.common.primary.entity.UserExample;

public class UserSqlProvider {

    public String countByExample(UserExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("eb_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(UserExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("eb_user");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(User record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("eb_user");
        
        if (record.getAccount() != null) {
            sql.VALUES("account", "#{account,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.VALUES("pwd", "#{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.VALUES("real_name", "#{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.VALUES("birthday", "#{birthday,jdbcType=INTEGER}");
        }
        
        if (record.getCardId() != null) {
            sql.VALUES("card_id", "#{cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getMark() != null) {
            sql.VALUES("mark", "#{mark,jdbcType=VARCHAR}");
        }
        
        if (record.getPartnerId() != null) {
            sql.VALUES("partner_id", "#{partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getGroupId() != null) {
            sql.VALUES("group_id", "#{groupId,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            sql.VALUES("nickname", "#{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.VALUES("avatar", "#{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.VALUES("phone", "#{phone,jdbcType=CHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.VALUES("add_time", "#{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddIp() != null) {
            sql.VALUES("add_ip", "#{addIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastTime() != null) {
            sql.VALUES("last_time", "#{lastTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastIp() != null) {
            sql.VALUES("last_ip", "#{lastIp,jdbcType=VARCHAR}");
        }
        
        if (record.getNowMoney() != null) {
            sql.VALUES("now_money", "#{nowMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getBrokeragePrice() != null) {
            sql.VALUES("brokerage_price", "#{brokeragePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegral() != null) {
            sql.VALUES("integral", "#{integral,jdbcType=INTEGER}");
        }
        
        if (record.getExp() != null) {
            sql.VALUES("`exp`", "#{exp,jdbcType=DECIMAL}");
        }
        
        if (record.getSignNum() != null) {
            sql.VALUES("sign_num", "#{signNum,jdbcType=INTEGER}");
        }
        
        if (record.getSignRemind() != null) {
            sql.VALUES("sign_remind", "#{signRemind,jdbcType=BIT}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("`status`", "#{status,jdbcType=BIT}");
        }
        
        if (record.getLevel() != null) {
            sql.VALUES("`level`", "#{level,jdbcType=TINYINT}");
        }
        
        if (record.getAgentLevel() != null) {
            sql.VALUES("agent_level", "#{agentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadOpen() != null) {
            sql.VALUES("spread_open", "#{spreadOpen,jdbcType=BIT}");
        }
        
        if (record.getSpreadUid() != null) {
            sql.VALUES("spread_uid", "#{spreadUid,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadTime() != null) {
            sql.VALUES("spread_time", "#{spreadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserType() != null) {
            sql.VALUES("user_type", "#{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPromoter() != null) {
            sql.VALUES("is_promoter", "#{isPromoter,jdbcType=TINYINT}");
        }
        
        if (record.getPayCount() != null) {
            sql.VALUES("pay_count", "#{payCount,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadCount() != null) {
            sql.VALUES("spread_count", "#{spreadCount,jdbcType=INTEGER}");
        }
        
        if (record.getCleanTime() != null) {
            sql.VALUES("clean_time", "#{cleanTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddres() != null) {
            sql.VALUES("addres", "#{addres,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminid() != null) {
            sql.VALUES("adminid", "#{adminid,jdbcType=INTEGER}");
        }
        
        if (record.getLoginType() != null) {
            sql.VALUES("login_type", "#{loginType,jdbcType=VARCHAR}");
        }
        
        if (record.getRecordPhone() != null) {
            sql.VALUES("record_phone", "#{recordPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMoneyLevel() != null) {
            sql.VALUES("is_money_level", "#{isMoneyLevel,jdbcType=BIT}");
        }
        
        if (record.getIsEverLevel() != null) {
            sql.VALUES("is_ever_level", "#{isEverLevel,jdbcType=BIT}");
        }
        
        if (record.getOverdueTime() != null) {
            sql.VALUES("overdue_time", "#{overdueTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUniqid() != null) {
            sql.VALUES("uniqid", "#{uniqid,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionName() != null) {
            sql.VALUES("division_name", "#{divisionName,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionType() != null) {
            sql.VALUES("division_type", "#{divisionType,jdbcType=BIT}");
        }
        
        if (record.getDivisionStatus() != null) {
            sql.VALUES("division_status", "#{divisionStatus,jdbcType=BIT}");
        }
        
        if (record.getIsDivision() != null) {
            sql.VALUES("is_division", "#{isDivision,jdbcType=BIT}");
        }
        
        if (record.getIsAgent() != null) {
            sql.VALUES("is_agent", "#{isAgent,jdbcType=BIT}");
        }
        
        if (record.getIsStaff() != null) {
            sql.VALUES("is_staff", "#{isStaff,jdbcType=BIT}");
        }
        
        if (record.getDivisionId() != null) {
            sql.VALUES("division_id", "#{divisionId,jdbcType=INTEGER}");
        }
        
        if (record.getAgentId() != null) {
            sql.VALUES("agent_id", "#{agentId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffId() != null) {
            sql.VALUES("staff_id", "#{staffId,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionPercent() != null) {
            sql.VALUES("division_percent", "#{divisionPercent,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionChangeTime() != null) {
            sql.VALUES("division_change_time", "#{divisionChangeTime,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionEndTime() != null) {
            sql.VALUES("division_end_time", "#{divisionEndTime,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionInvite() != null) {
            sql.VALUES("division_invite", "#{divisionInvite,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.VALUES("is_del", "#{isDel,jdbcType=BIT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(UserExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("`uid`");
        } else {
            sql.SELECT("`uid`");
        }
        sql.SELECT("account");
        sql.SELECT("pwd");
        sql.SELECT("real_name");
        sql.SELECT("birthday");
        sql.SELECT("card_id");
        sql.SELECT("mark");
        sql.SELECT("partner_id");
        sql.SELECT("group_id");
        sql.SELECT("nickname");
        sql.SELECT("avatar");
        sql.SELECT("phone");
        sql.SELECT("add_time");
        sql.SELECT("add_ip");
        sql.SELECT("last_time");
        sql.SELECT("last_ip");
        sql.SELECT("now_money");
        sql.SELECT("brokerage_price");
        sql.SELECT("integral");
        sql.SELECT("`exp`");
        sql.SELECT("sign_num");
        sql.SELECT("sign_remind");
        sql.SELECT("`status`");
        sql.SELECT("`level`");
        sql.SELECT("agent_level");
        sql.SELECT("spread_open");
        sql.SELECT("spread_uid");
        sql.SELECT("spread_time");
        sql.SELECT("user_type");
        sql.SELECT("is_promoter");
        sql.SELECT("pay_count");
        sql.SELECT("spread_count");
        sql.SELECT("clean_time");
        sql.SELECT("addres");
        sql.SELECT("adminid");
        sql.SELECT("login_type");
        sql.SELECT("record_phone");
        sql.SELECT("is_money_level");
        sql.SELECT("is_ever_level");
        sql.SELECT("overdue_time");
        sql.SELECT("uniqid");
        sql.SELECT("division_name");
        sql.SELECT("division_type");
        sql.SELECT("division_status");
        sql.SELECT("is_division");
        sql.SELECT("is_agent");
        sql.SELECT("is_staff");
        sql.SELECT("division_id");
        sql.SELECT("agent_id");
        sql.SELECT("staff_id");
        sql.SELECT("division_percent");
        sql.SELECT("division_change_time");
        sql.SELECT("division_end_time");
        sql.SELECT("division_invite");
        sql.SELECT("is_del");
        sql.FROM("eb_user");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        if (example != null && example.getOffset() != null && example.getLimit() != null) {
            return sql.toString() + " limit " + example.getOffset() + "," + example.getLimit();
        }
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        User record = (User) parameter.get("record");
        UserExample example = (UserExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("eb_user");
        
        if (record.getUid() != null) {
            sql.SET("`uid` = #{record.uid,jdbcType=INTEGER}");
        }
        
        if (record.getAccount() != null) {
            sql.SET("account = #{record.account,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{record.pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.SET("birthday = #{record.birthday,jdbcType=INTEGER}");
        }
        
        if (record.getCardId() != null) {
            sql.SET("card_id = #{record.cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        }
        
        if (record.getPartnerId() != null) {
            sql.SET("partner_id = #{record.partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getGroupId() != null) {
            sql.SET("group_id = #{record.groupId,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{record.phone,jdbcType=CHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddIp() != null) {
            sql.SET("add_ip = #{record.addIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastTime() != null) {
            sql.SET("last_time = #{record.lastTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastIp() != null) {
            sql.SET("last_ip = #{record.lastIp,jdbcType=VARCHAR}");
        }
        
        if (record.getNowMoney() != null) {
            sql.SET("now_money = #{record.nowMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getBrokeragePrice() != null) {
            sql.SET("brokerage_price = #{record.brokeragePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegral() != null) {
            sql.SET("integral = #{record.integral,jdbcType=INTEGER}");
        }
        
        if (record.getExp() != null) {
            sql.SET("`exp` = #{record.exp,jdbcType=DECIMAL}");
        }
        
        if (record.getSignNum() != null) {
            sql.SET("sign_num = #{record.signNum,jdbcType=INTEGER}");
        }
        
        if (record.getSignRemind() != null) {
            sql.SET("sign_remind = #{record.signRemind,jdbcType=BIT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{record.status,jdbcType=BIT}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{record.level,jdbcType=TINYINT}");
        }
        
        if (record.getAgentLevel() != null) {
            sql.SET("agent_level = #{record.agentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadOpen() != null) {
            sql.SET("spread_open = #{record.spreadOpen,jdbcType=BIT}");
        }
        
        if (record.getSpreadUid() != null) {
            sql.SET("spread_uid = #{record.spreadUid,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadTime() != null) {
            sql.SET("spread_time = #{record.spreadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("user_type = #{record.userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPromoter() != null) {
            sql.SET("is_promoter = #{record.isPromoter,jdbcType=TINYINT}");
        }
        
        if (record.getPayCount() != null) {
            sql.SET("pay_count = #{record.payCount,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadCount() != null) {
            sql.SET("spread_count = #{record.spreadCount,jdbcType=INTEGER}");
        }
        
        if (record.getCleanTime() != null) {
            sql.SET("clean_time = #{record.cleanTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddres() != null) {
            sql.SET("addres = #{record.addres,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminid() != null) {
            sql.SET("adminid = #{record.adminid,jdbcType=INTEGER}");
        }
        
        if (record.getLoginType() != null) {
            sql.SET("login_type = #{record.loginType,jdbcType=VARCHAR}");
        }
        
        if (record.getRecordPhone() != null) {
            sql.SET("record_phone = #{record.recordPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMoneyLevel() != null) {
            sql.SET("is_money_level = #{record.isMoneyLevel,jdbcType=BIT}");
        }
        
        if (record.getIsEverLevel() != null) {
            sql.SET("is_ever_level = #{record.isEverLevel,jdbcType=BIT}");
        }
        
        if (record.getOverdueTime() != null) {
            sql.SET("overdue_time = #{record.overdueTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUniqid() != null) {
            sql.SET("uniqid = #{record.uniqid,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionName() != null) {
            sql.SET("division_name = #{record.divisionName,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionType() != null) {
            sql.SET("division_type = #{record.divisionType,jdbcType=BIT}");
        }
        
        if (record.getDivisionStatus() != null) {
            sql.SET("division_status = #{record.divisionStatus,jdbcType=BIT}");
        }
        
        if (record.getIsDivision() != null) {
            sql.SET("is_division = #{record.isDivision,jdbcType=BIT}");
        }
        
        if (record.getIsAgent() != null) {
            sql.SET("is_agent = #{record.isAgent,jdbcType=BIT}");
        }
        
        if (record.getIsStaff() != null) {
            sql.SET("is_staff = #{record.isStaff,jdbcType=BIT}");
        }
        
        if (record.getDivisionId() != null) {
            sql.SET("division_id = #{record.divisionId,jdbcType=INTEGER}");
        }
        
        if (record.getAgentId() != null) {
            sql.SET("agent_id = #{record.agentId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffId() != null) {
            sql.SET("staff_id = #{record.staffId,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionPercent() != null) {
            sql.SET("division_percent = #{record.divisionPercent,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionChangeTime() != null) {
            sql.SET("division_change_time = #{record.divisionChangeTime,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionEndTime() != null) {
            sql.SET("division_end_time = #{record.divisionEndTime,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionInvite() != null) {
            sql.SET("division_invite = #{record.divisionInvite,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("eb_user");
        
        sql.SET("`uid` = #{record.uid,jdbcType=INTEGER}");
        sql.SET("account = #{record.account,jdbcType=VARCHAR}");
        sql.SET("pwd = #{record.pwd,jdbcType=VARCHAR}");
        sql.SET("real_name = #{record.realName,jdbcType=VARCHAR}");
        sql.SET("birthday = #{record.birthday,jdbcType=INTEGER}");
        sql.SET("card_id = #{record.cardId,jdbcType=VARCHAR}");
        sql.SET("mark = #{record.mark,jdbcType=VARCHAR}");
        sql.SET("partner_id = #{record.partnerId,jdbcType=INTEGER}");
        sql.SET("group_id = #{record.groupId,jdbcType=INTEGER}");
        sql.SET("nickname = #{record.nickname,jdbcType=VARCHAR}");
        sql.SET("avatar = #{record.avatar,jdbcType=VARCHAR}");
        sql.SET("phone = #{record.phone,jdbcType=CHAR}");
        sql.SET("add_time = #{record.addTime,jdbcType=TIMESTAMP}");
        sql.SET("add_ip = #{record.addIp,jdbcType=VARCHAR}");
        sql.SET("last_time = #{record.lastTime,jdbcType=TIMESTAMP}");
        sql.SET("last_ip = #{record.lastIp,jdbcType=VARCHAR}");
        sql.SET("now_money = #{record.nowMoney,jdbcType=DECIMAL}");
        sql.SET("brokerage_price = #{record.brokeragePrice,jdbcType=DECIMAL}");
        sql.SET("integral = #{record.integral,jdbcType=INTEGER}");
        sql.SET("`exp` = #{record.exp,jdbcType=DECIMAL}");
        sql.SET("sign_num = #{record.signNum,jdbcType=INTEGER}");
        sql.SET("sign_remind = #{record.signRemind,jdbcType=BIT}");
        sql.SET("`status` = #{record.status,jdbcType=BIT}");
        sql.SET("`level` = #{record.level,jdbcType=TINYINT}");
        sql.SET("agent_level = #{record.agentLevel,jdbcType=INTEGER}");
        sql.SET("spread_open = #{record.spreadOpen,jdbcType=BIT}");
        sql.SET("spread_uid = #{record.spreadUid,jdbcType=INTEGER}");
        sql.SET("spread_time = #{record.spreadTime,jdbcType=TIMESTAMP}");
        sql.SET("user_type = #{record.userType,jdbcType=VARCHAR}");
        sql.SET("is_promoter = #{record.isPromoter,jdbcType=TINYINT}");
        sql.SET("pay_count = #{record.payCount,jdbcType=INTEGER}");
        sql.SET("spread_count = #{record.spreadCount,jdbcType=INTEGER}");
        sql.SET("clean_time = #{record.cleanTime,jdbcType=TIMESTAMP}");
        sql.SET("addres = #{record.addres,jdbcType=VARCHAR}");
        sql.SET("adminid = #{record.adminid,jdbcType=INTEGER}");
        sql.SET("login_type = #{record.loginType,jdbcType=VARCHAR}");
        sql.SET("record_phone = #{record.recordPhone,jdbcType=VARCHAR}");
        sql.SET("is_money_level = #{record.isMoneyLevel,jdbcType=BIT}");
        sql.SET("is_ever_level = #{record.isEverLevel,jdbcType=BIT}");
        sql.SET("overdue_time = #{record.overdueTime,jdbcType=TIMESTAMP}");
        sql.SET("uniqid = #{record.uniqid,jdbcType=VARCHAR}");
        sql.SET("division_name = #{record.divisionName,jdbcType=VARCHAR}");
        sql.SET("division_type = #{record.divisionType,jdbcType=BIT}");
        sql.SET("division_status = #{record.divisionStatus,jdbcType=BIT}");
        sql.SET("is_division = #{record.isDivision,jdbcType=BIT}");
        sql.SET("is_agent = #{record.isAgent,jdbcType=BIT}");
        sql.SET("is_staff = #{record.isStaff,jdbcType=BIT}");
        sql.SET("division_id = #{record.divisionId,jdbcType=INTEGER}");
        sql.SET("agent_id = #{record.agentId,jdbcType=INTEGER}");
        sql.SET("staff_id = #{record.staffId,jdbcType=INTEGER}");
        sql.SET("division_percent = #{record.divisionPercent,jdbcType=INTEGER}");
        sql.SET("division_change_time = #{record.divisionChangeTime,jdbcType=INTEGER}");
        sql.SET("division_end_time = #{record.divisionEndTime,jdbcType=INTEGER}");
        sql.SET("division_invite = #{record.divisionInvite,jdbcType=INTEGER}");
        sql.SET("is_del = #{record.isDel,jdbcType=BIT}");
        
        UserExample example = (UserExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(User record) {
        SQL sql = new SQL();
        sql.UPDATE("eb_user");
        
        if (record.getAccount() != null) {
            sql.SET("account = #{account,jdbcType=VARCHAR}");
        }
        
        if (record.getPwd() != null) {
            sql.SET("pwd = #{pwd,jdbcType=VARCHAR}");
        }
        
        if (record.getRealName() != null) {
            sql.SET("real_name = #{realName,jdbcType=VARCHAR}");
        }
        
        if (record.getBirthday() != null) {
            sql.SET("birthday = #{birthday,jdbcType=INTEGER}");
        }
        
        if (record.getCardId() != null) {
            sql.SET("card_id = #{cardId,jdbcType=VARCHAR}");
        }
        
        if (record.getMark() != null) {
            sql.SET("mark = #{mark,jdbcType=VARCHAR}");
        }
        
        if (record.getPartnerId() != null) {
            sql.SET("partner_id = #{partnerId,jdbcType=INTEGER}");
        }
        
        if (record.getGroupId() != null) {
            sql.SET("group_id = #{groupId,jdbcType=INTEGER}");
        }
        
        if (record.getNickname() != null) {
            sql.SET("nickname = #{nickname,jdbcType=VARCHAR}");
        }
        
        if (record.getAvatar() != null) {
            sql.SET("avatar = #{avatar,jdbcType=VARCHAR}");
        }
        
        if (record.getPhone() != null) {
            sql.SET("phone = #{phone,jdbcType=CHAR}");
        }
        
        if (record.getAddTime() != null) {
            sql.SET("add_time = #{addTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddIp() != null) {
            sql.SET("add_ip = #{addIp,jdbcType=VARCHAR}");
        }
        
        if (record.getLastTime() != null) {
            sql.SET("last_time = #{lastTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getLastIp() != null) {
            sql.SET("last_ip = #{lastIp,jdbcType=VARCHAR}");
        }
        
        if (record.getNowMoney() != null) {
            sql.SET("now_money = #{nowMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getBrokeragePrice() != null) {
            sql.SET("brokerage_price = #{brokeragePrice,jdbcType=DECIMAL}");
        }
        
        if (record.getIntegral() != null) {
            sql.SET("integral = #{integral,jdbcType=INTEGER}");
        }
        
        if (record.getExp() != null) {
            sql.SET("`exp` = #{exp,jdbcType=DECIMAL}");
        }
        
        if (record.getSignNum() != null) {
            sql.SET("sign_num = #{signNum,jdbcType=INTEGER}");
        }
        
        if (record.getSignRemind() != null) {
            sql.SET("sign_remind = #{signRemind,jdbcType=BIT}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("`status` = #{status,jdbcType=BIT}");
        }
        
        if (record.getLevel() != null) {
            sql.SET("`level` = #{level,jdbcType=TINYINT}");
        }
        
        if (record.getAgentLevel() != null) {
            sql.SET("agent_level = #{agentLevel,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadOpen() != null) {
            sql.SET("spread_open = #{spreadOpen,jdbcType=BIT}");
        }
        
        if (record.getSpreadUid() != null) {
            sql.SET("spread_uid = #{spreadUid,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadTime() != null) {
            sql.SET("spread_time = #{spreadTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUserType() != null) {
            sql.SET("user_type = #{userType,jdbcType=VARCHAR}");
        }
        
        if (record.getIsPromoter() != null) {
            sql.SET("is_promoter = #{isPromoter,jdbcType=TINYINT}");
        }
        
        if (record.getPayCount() != null) {
            sql.SET("pay_count = #{payCount,jdbcType=INTEGER}");
        }
        
        if (record.getSpreadCount() != null) {
            sql.SET("spread_count = #{spreadCount,jdbcType=INTEGER}");
        }
        
        if (record.getCleanTime() != null) {
            sql.SET("clean_time = #{cleanTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getAddres() != null) {
            sql.SET("addres = #{addres,jdbcType=VARCHAR}");
        }
        
        if (record.getAdminid() != null) {
            sql.SET("adminid = #{adminid,jdbcType=INTEGER}");
        }
        
        if (record.getLoginType() != null) {
            sql.SET("login_type = #{loginType,jdbcType=VARCHAR}");
        }
        
        if (record.getRecordPhone() != null) {
            sql.SET("record_phone = #{recordPhone,jdbcType=VARCHAR}");
        }
        
        if (record.getIsMoneyLevel() != null) {
            sql.SET("is_money_level = #{isMoneyLevel,jdbcType=BIT}");
        }
        
        if (record.getIsEverLevel() != null) {
            sql.SET("is_ever_level = #{isEverLevel,jdbcType=BIT}");
        }
        
        if (record.getOverdueTime() != null) {
            sql.SET("overdue_time = #{overdueTime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getUniqid() != null) {
            sql.SET("uniqid = #{uniqid,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionName() != null) {
            sql.SET("division_name = #{divisionName,jdbcType=VARCHAR}");
        }
        
        if (record.getDivisionType() != null) {
            sql.SET("division_type = #{divisionType,jdbcType=BIT}");
        }
        
        if (record.getDivisionStatus() != null) {
            sql.SET("division_status = #{divisionStatus,jdbcType=BIT}");
        }
        
        if (record.getIsDivision() != null) {
            sql.SET("is_division = #{isDivision,jdbcType=BIT}");
        }
        
        if (record.getIsAgent() != null) {
            sql.SET("is_agent = #{isAgent,jdbcType=BIT}");
        }
        
        if (record.getIsStaff() != null) {
            sql.SET("is_staff = #{isStaff,jdbcType=BIT}");
        }
        
        if (record.getDivisionId() != null) {
            sql.SET("division_id = #{divisionId,jdbcType=INTEGER}");
        }
        
        if (record.getAgentId() != null) {
            sql.SET("agent_id = #{agentId,jdbcType=INTEGER}");
        }
        
        if (record.getStaffId() != null) {
            sql.SET("staff_id = #{staffId,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionPercent() != null) {
            sql.SET("division_percent = #{divisionPercent,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionChangeTime() != null) {
            sql.SET("division_change_time = #{divisionChangeTime,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionEndTime() != null) {
            sql.SET("division_end_time = #{divisionEndTime,jdbcType=INTEGER}");
        }
        
        if (record.getDivisionInvite() != null) {
            sql.SET("division_invite = #{divisionInvite,jdbcType=INTEGER}");
        }
        
        if (record.getIsDel() != null) {
            sql.SET("is_del = #{isDel,jdbcType=BIT}");
        }
        
        sql.WHERE("`uid` = #{uid,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, UserExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}