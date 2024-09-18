package org.example.backend.common.primary.base.dao;

import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.User;
import org.example.backend.common.primary.entity.UserExample;

public interface UserDao {
    @SelectProvider(type=UserSqlProvider.class, method="countByExample")
    long countByExample(UserExample example);

    @DeleteProvider(type=UserSqlProvider.class, method="deleteByExample")
    int deleteByExample(UserExample example);

    @Delete({
        "delete from eb_user",
        "where `uid` = #{uid,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer uid);

    @Insert({
        "insert into eb_user (account, pwd, ",
        "real_name, birthday, ",
        "card_id, mark, partner_id, ",
        "group_id, nickname, ",
        "avatar, phone, add_time, ",
        "add_ip, last_time, ",
        "last_ip, now_money, ",
        "brokerage_price, integral, ",
        "`exp`, sign_num, sign_remind, ",
        "`status`, `level`, agent_level, ",
        "spread_open, spread_uid, ",
        "spread_time, user_type, ",
        "is_promoter, pay_count, ",
        "spread_count, clean_time, ",
        "addres, adminid, ",
        "login_type, record_phone, ",
        "is_money_level, is_ever_level, ",
        "overdue_time, uniqid, ",
        "division_name, division_type, ",
        "division_status, is_division, ",
        "is_agent, is_staff, division_id, ",
        "agent_id, staff_id, ",
        "division_percent, division_change_time, ",
        "division_end_time, division_invite, ",
        "is_del)",
        "values (#{account,jdbcType=VARCHAR}, #{pwd,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{birthday,jdbcType=INTEGER}, ",
        "#{cardId,jdbcType=VARCHAR}, #{mark,jdbcType=VARCHAR}, #{partnerId,jdbcType=INTEGER}, ",
        "#{groupId,jdbcType=INTEGER}, #{nickname,jdbcType=VARCHAR}, ",
        "#{avatar,jdbcType=VARCHAR}, #{phone,jdbcType=CHAR}, #{addTime,jdbcType=TIMESTAMP}, ",
        "#{addIp,jdbcType=VARCHAR}, #{lastTime,jdbcType=TIMESTAMP}, ",
        "#{lastIp,jdbcType=VARCHAR}, #{nowMoney,jdbcType=DECIMAL}, ",
        "#{brokeragePrice,jdbcType=DECIMAL}, #{integral,jdbcType=INTEGER}, ",
        "#{exp,jdbcType=DECIMAL}, #{signNum,jdbcType=INTEGER}, #{signRemind,jdbcType=BIT}, ",
        "#{status,jdbcType=BIT}, #{level,jdbcType=TINYINT}, #{agentLevel,jdbcType=INTEGER}, ",
        "#{spreadOpen,jdbcType=BIT}, #{spreadUid,jdbcType=INTEGER}, ",
        "#{spreadTime,jdbcType=TIMESTAMP}, #{userType,jdbcType=VARCHAR}, ",
        "#{isPromoter,jdbcType=TINYINT}, #{payCount,jdbcType=INTEGER}, ",
        "#{spreadCount,jdbcType=INTEGER}, #{cleanTime,jdbcType=TIMESTAMP}, ",
        "#{addres,jdbcType=VARCHAR}, #{adminid,jdbcType=INTEGER}, ",
        "#{loginType,jdbcType=VARCHAR}, #{recordPhone,jdbcType=VARCHAR}, ",
        "#{isMoneyLevel,jdbcType=BIT}, #{isEverLevel,jdbcType=BIT}, ",
        "#{overdueTime,jdbcType=TIMESTAMP}, #{uniqid,jdbcType=VARCHAR}, ",
        "#{divisionName,jdbcType=VARCHAR}, #{divisionType,jdbcType=BIT}, ",
        "#{divisionStatus,jdbcType=BIT}, #{isDivision,jdbcType=BIT}, ",
        "#{isAgent,jdbcType=BIT}, #{isStaff,jdbcType=BIT}, #{divisionId,jdbcType=INTEGER}, ",
        "#{agentId,jdbcType=INTEGER}, #{staffId,jdbcType=INTEGER}, ",
        "#{divisionPercent,jdbcType=INTEGER}, #{divisionChangeTime,jdbcType=INTEGER}, ",
        "#{divisionEndTime,jdbcType=INTEGER}, #{divisionInvite,jdbcType=INTEGER}, ",
        "#{isDel,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="uid")
    int insert(User record);

    @InsertProvider(type=UserSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="uid")
    int insertSelective(User record);

    @SelectProvider(type=UserSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.INTEGER),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
        @Result(column="partner_id", property="partnerId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="add_ip", property="addIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_ip", property="lastIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="now_money", property="nowMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="brokerage_price", property="brokeragePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="integral", property="integral", jdbcType=JdbcType.INTEGER),
        @Result(column="exp", property="exp", jdbcType=JdbcType.DECIMAL),
        @Result(column="sign_num", property="signNum", jdbcType=JdbcType.INTEGER),
        @Result(column="sign_remind", property="signRemind", jdbcType=JdbcType.BIT),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="agent_level", property="agentLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="spread_open", property="spreadOpen", jdbcType=JdbcType.BIT),
        @Result(column="spread_uid", property="spreadUid", jdbcType=JdbcType.INTEGER),
        @Result(column="spread_time", property="spreadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_promoter", property="isPromoter", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_count", property="payCount", jdbcType=JdbcType.INTEGER),
        @Result(column="spread_count", property="spreadCount", jdbcType=JdbcType.INTEGER),
        @Result(column="clean_time", property="cleanTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="addres", property="addres", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminid", property="adminid", jdbcType=JdbcType.INTEGER),
        @Result(column="login_type", property="loginType", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_phone", property="recordPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_money_level", property="isMoneyLevel", jdbcType=JdbcType.BIT),
        @Result(column="is_ever_level", property="isEverLevel", jdbcType=JdbcType.BIT),
        @Result(column="overdue_time", property="overdueTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uniqid", property="uniqid", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_name", property="divisionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_type", property="divisionType", jdbcType=JdbcType.BIT),
        @Result(column="division_status", property="divisionStatus", jdbcType=JdbcType.BIT),
        @Result(column="is_division", property="isDivision", jdbcType=JdbcType.BIT),
        @Result(column="is_agent", property="isAgent", jdbcType=JdbcType.BIT),
        @Result(column="is_staff", property="isStaff", jdbcType=JdbcType.BIT),
        @Result(column="division_id", property="divisionId", jdbcType=JdbcType.INTEGER),
        @Result(column="agent_id", property="agentId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="division_percent", property="divisionPercent", jdbcType=JdbcType.INTEGER),
        @Result(column="division_change_time", property="divisionChangeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="division_end_time", property="divisionEndTime", jdbcType=JdbcType.INTEGER),
        @Result(column="division_invite", property="divisionInvite", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT)
    })
    List<User> selectByExample(UserExample example);

    @Select({
        "select",
        "`uid`, account, pwd, real_name, birthday, card_id, mark, partner_id, group_id, ",
        "nickname, avatar, phone, add_time, add_ip, last_time, last_ip, now_money, brokerage_price, ",
        "integral, `exp`, sign_num, sign_remind, `status`, `level`, agent_level, spread_open, ",
        "spread_uid, spread_time, user_type, is_promoter, pay_count, spread_count, clean_time, ",
        "addres, adminid, login_type, record_phone, is_money_level, is_ever_level, overdue_time, ",
        "uniqid, division_name, division_type, division_status, is_division, is_agent, ",
        "is_staff, division_id, agent_id, staff_id, division_percent, division_change_time, ",
        "division_end_time, division_invite, is_del",
        "from eb_user",
        "where `uid` = #{uid,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="birthday", property="birthday", jdbcType=JdbcType.INTEGER),
        @Result(column="card_id", property="cardId", jdbcType=JdbcType.VARCHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
        @Result(column="partner_id", property="partnerId", jdbcType=JdbcType.INTEGER),
        @Result(column="group_id", property="groupId", jdbcType=JdbcType.INTEGER),
        @Result(column="nickname", property="nickname", jdbcType=JdbcType.VARCHAR),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="add_ip", property="addIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="last_ip", property="lastIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="now_money", property="nowMoney", jdbcType=JdbcType.DECIMAL),
        @Result(column="brokerage_price", property="brokeragePrice", jdbcType=JdbcType.DECIMAL),
        @Result(column="integral", property="integral", jdbcType=JdbcType.INTEGER),
        @Result(column="exp", property="exp", jdbcType=JdbcType.DECIMAL),
        @Result(column="sign_num", property="signNum", jdbcType=JdbcType.INTEGER),
        @Result(column="sign_remind", property="signRemind", jdbcType=JdbcType.BIT),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="agent_level", property="agentLevel", jdbcType=JdbcType.INTEGER),
        @Result(column="spread_open", property="spreadOpen", jdbcType=JdbcType.BIT),
        @Result(column="spread_uid", property="spreadUid", jdbcType=JdbcType.INTEGER),
        @Result(column="spread_time", property="spreadTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_type", property="userType", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_promoter", property="isPromoter", jdbcType=JdbcType.TINYINT),
        @Result(column="pay_count", property="payCount", jdbcType=JdbcType.INTEGER),
        @Result(column="spread_count", property="spreadCount", jdbcType=JdbcType.INTEGER),
        @Result(column="clean_time", property="cleanTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="addres", property="addres", jdbcType=JdbcType.VARCHAR),
        @Result(column="adminid", property="adminid", jdbcType=JdbcType.INTEGER),
        @Result(column="login_type", property="loginType", jdbcType=JdbcType.VARCHAR),
        @Result(column="record_phone", property="recordPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_money_level", property="isMoneyLevel", jdbcType=JdbcType.BIT),
        @Result(column="is_ever_level", property="isEverLevel", jdbcType=JdbcType.BIT),
        @Result(column="overdue_time", property="overdueTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="uniqid", property="uniqid", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_name", property="divisionName", jdbcType=JdbcType.VARCHAR),
        @Result(column="division_type", property="divisionType", jdbcType=JdbcType.BIT),
        @Result(column="division_status", property="divisionStatus", jdbcType=JdbcType.BIT),
        @Result(column="is_division", property="isDivision", jdbcType=JdbcType.BIT),
        @Result(column="is_agent", property="isAgent", jdbcType=JdbcType.BIT),
        @Result(column="is_staff", property="isStaff", jdbcType=JdbcType.BIT),
        @Result(column="division_id", property="divisionId", jdbcType=JdbcType.INTEGER),
        @Result(column="agent_id", property="agentId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_id", property="staffId", jdbcType=JdbcType.INTEGER),
        @Result(column="division_percent", property="divisionPercent", jdbcType=JdbcType.INTEGER),
        @Result(column="division_change_time", property="divisionChangeTime", jdbcType=JdbcType.INTEGER),
        @Result(column="division_end_time", property="divisionEndTime", jdbcType=JdbcType.INTEGER),
        @Result(column="division_invite", property="divisionInvite", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT)
    })
    User selectByPrimaryKey(Integer uid);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    @UpdateProvider(type=UserSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(User record);

    @Update({
        "update eb_user",
        "set account = #{account,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "birthday = #{birthday,jdbcType=INTEGER},",
          "card_id = #{cardId,jdbcType=VARCHAR},",
          "mark = #{mark,jdbcType=VARCHAR},",
          "partner_id = #{partnerId,jdbcType=INTEGER},",
          "group_id = #{groupId,jdbcType=INTEGER},",
          "nickname = #{nickname,jdbcType=VARCHAR},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "add_time = #{addTime,jdbcType=TIMESTAMP},",
          "add_ip = #{addIp,jdbcType=VARCHAR},",
          "last_time = #{lastTime,jdbcType=TIMESTAMP},",
          "last_ip = #{lastIp,jdbcType=VARCHAR},",
          "now_money = #{nowMoney,jdbcType=DECIMAL},",
          "brokerage_price = #{brokeragePrice,jdbcType=DECIMAL},",
          "integral = #{integral,jdbcType=INTEGER},",
          "`exp` = #{exp,jdbcType=DECIMAL},",
          "sign_num = #{signNum,jdbcType=INTEGER},",
          "sign_remind = #{signRemind,jdbcType=BIT},",
          "`status` = #{status,jdbcType=BIT},",
          "`level` = #{level,jdbcType=TINYINT},",
          "agent_level = #{agentLevel,jdbcType=INTEGER},",
          "spread_open = #{spreadOpen,jdbcType=BIT},",
          "spread_uid = #{spreadUid,jdbcType=INTEGER},",
          "spread_time = #{spreadTime,jdbcType=TIMESTAMP},",
          "user_type = #{userType,jdbcType=VARCHAR},",
          "is_promoter = #{isPromoter,jdbcType=TINYINT},",
          "pay_count = #{payCount,jdbcType=INTEGER},",
          "spread_count = #{spreadCount,jdbcType=INTEGER},",
          "clean_time = #{cleanTime,jdbcType=TIMESTAMP},",
          "addres = #{addres,jdbcType=VARCHAR},",
          "adminid = #{adminid,jdbcType=INTEGER},",
          "login_type = #{loginType,jdbcType=VARCHAR},",
          "record_phone = #{recordPhone,jdbcType=VARCHAR},",
          "is_money_level = #{isMoneyLevel,jdbcType=BIT},",
          "is_ever_level = #{isEverLevel,jdbcType=BIT},",
          "overdue_time = #{overdueTime,jdbcType=TIMESTAMP},",
          "uniqid = #{uniqid,jdbcType=VARCHAR},",
          "division_name = #{divisionName,jdbcType=VARCHAR},",
          "division_type = #{divisionType,jdbcType=BIT},",
          "division_status = #{divisionStatus,jdbcType=BIT},",
          "is_division = #{isDivision,jdbcType=BIT},",
          "is_agent = #{isAgent,jdbcType=BIT},",
          "is_staff = #{isStaff,jdbcType=BIT},",
          "division_id = #{divisionId,jdbcType=INTEGER},",
          "agent_id = #{agentId,jdbcType=INTEGER},",
          "staff_id = #{staffId,jdbcType=INTEGER},",
          "division_percent = #{divisionPercent,jdbcType=INTEGER},",
          "division_change_time = #{divisionChangeTime,jdbcType=INTEGER},",
          "division_end_time = #{divisionEndTime,jdbcType=INTEGER},",
          "division_invite = #{divisionInvite,jdbcType=INTEGER},",
          "is_del = #{isDel,jdbcType=BIT}",
        "where `uid` = #{uid,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(User record);
}