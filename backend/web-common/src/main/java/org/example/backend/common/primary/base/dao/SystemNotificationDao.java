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
import org.example.backend.common.primary.entity.SystemNotification;
import org.example.backend.common.primary.entity.SystemNotificationExample;

public interface SystemNotificationDao {
    @SelectProvider(type=SystemNotificationSqlProvider.class, method="countByExample")
    long countByExample(SystemNotificationExample example);

    @DeleteProvider(type=SystemNotificationSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemNotificationExample example);

    @Delete({
        "delete from eb_system_notification",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_notification (mark, `name`, ",
        "title, is_system, system_title, ",
        "system_text, is_wechat, ",
        "wechat_tempkey, wechat_content, ",
        "wechat_kid, wechat_tempid, ",
        "wechat_data, wechat_link, ",
        "wechat_to_routine, is_routine, ",
        "routine_tempkey, routine_content, ",
        "routine_kid, routine_tempid, ",
        "routine_data, routine_link, ",
        "is_sms, sms_id, sms_text, ",
        "is_ent_wechat, ent_wechat_text, ",
        "url, is_app, app_id, ",
        "`variable`, `type`, add_time, ",
        "custom_trigger, custom_variable)",
        "values (#{mark,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{title,jdbcType=VARCHAR}, #{isSystem,jdbcType=BIT}, #{systemTitle,jdbcType=VARCHAR}, ",
        "#{systemText,jdbcType=VARCHAR}, #{isWechat,jdbcType=BIT}, ",
        "#{wechatTempkey,jdbcType=VARCHAR}, #{wechatContent,jdbcType=VARCHAR}, ",
        "#{wechatKid,jdbcType=VARCHAR}, #{wechatTempid,jdbcType=VARCHAR}, ",
        "#{wechatData,jdbcType=VARCHAR}, #{wechatLink,jdbcType=VARCHAR}, ",
        "#{wechatToRoutine,jdbcType=INTEGER}, #{isRoutine,jdbcType=BIT}, ",
        "#{routineTempkey,jdbcType=VARCHAR}, #{routineContent,jdbcType=VARCHAR}, ",
        "#{routineKid,jdbcType=VARCHAR}, #{routineTempid,jdbcType=VARCHAR}, ",
        "#{routineData,jdbcType=VARCHAR}, #{routineLink,jdbcType=VARCHAR}, ",
        "#{isSms,jdbcType=BIT}, #{smsId,jdbcType=VARCHAR}, #{smsText,jdbcType=VARCHAR}, ",
        "#{isEntWechat,jdbcType=BIT}, #{entWechatText,jdbcType=VARCHAR}, ",
        "#{url,jdbcType=VARCHAR}, #{isApp,jdbcType=BIT}, #{appId,jdbcType=INTEGER}, ",
        "#{variable,jdbcType=VARCHAR}, #{type,jdbcType=BIT}, #{addTime,jdbcType=INTEGER}, ",
        "#{customTrigger,jdbcType=VARCHAR}, #{customVariable,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemNotification record);

    @InsertProvider(type=SystemNotificationSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemNotification record);

    @SelectProvider(type=SystemNotificationSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_system", property="isSystem", jdbcType=JdbcType.BIT),
        @Result(column="system_title", property="systemTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="system_text", property="systemText", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_wechat", property="isWechat", jdbcType=JdbcType.BIT),
        @Result(column="wechat_tempkey", property="wechatTempkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_content", property="wechatContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_kid", property="wechatKid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_tempid", property="wechatTempid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_data", property="wechatData", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_link", property="wechatLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_to_routine", property="wechatToRoutine", jdbcType=JdbcType.INTEGER),
        @Result(column="is_routine", property="isRoutine", jdbcType=JdbcType.BIT),
        @Result(column="routine_tempkey", property="routineTempkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_content", property="routineContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_kid", property="routineKid", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_tempid", property="routineTempid", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_data", property="routineData", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_link", property="routineLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_sms", property="isSms", jdbcType=JdbcType.BIT),
        @Result(column="sms_id", property="smsId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sms_text", property="smsText", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_ent_wechat", property="isEntWechat", jdbcType=JdbcType.BIT),
        @Result(column="ent_wechat_text", property="entWechatText", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_app", property="isApp", jdbcType=JdbcType.BIT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="variable", property="variable", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="custom_trigger", property="customTrigger", jdbcType=JdbcType.VARCHAR),
        @Result(column="custom_variable", property="customVariable", jdbcType=JdbcType.VARCHAR)
    })
    List<SystemNotification> selectByExample(SystemNotificationExample example);

    @Select({
        "select",
        "id, mark, `name`, title, is_system, system_title, system_text, is_wechat, wechat_tempkey, ",
        "wechat_content, wechat_kid, wechat_tempid, wechat_data, wechat_link, wechat_to_routine, ",
        "is_routine, routine_tempkey, routine_content, routine_kid, routine_tempid, routine_data, ",
        "routine_link, is_sms, sms_id, sms_text, is_ent_wechat, ent_wechat_text, url, ",
        "is_app, app_id, `variable`, `type`, add_time, custom_trigger, custom_variable",
        "from eb_system_notification",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_system", property="isSystem", jdbcType=JdbcType.BIT),
        @Result(column="system_title", property="systemTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="system_text", property="systemText", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_wechat", property="isWechat", jdbcType=JdbcType.BIT),
        @Result(column="wechat_tempkey", property="wechatTempkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_content", property="wechatContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_kid", property="wechatKid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_tempid", property="wechatTempid", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_data", property="wechatData", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_link", property="wechatLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="wechat_to_routine", property="wechatToRoutine", jdbcType=JdbcType.INTEGER),
        @Result(column="is_routine", property="isRoutine", jdbcType=JdbcType.BIT),
        @Result(column="routine_tempkey", property="routineTempkey", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_content", property="routineContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_kid", property="routineKid", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_tempid", property="routineTempid", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_data", property="routineData", jdbcType=JdbcType.VARCHAR),
        @Result(column="routine_link", property="routineLink", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_sms", property="isSms", jdbcType=JdbcType.BIT),
        @Result(column="sms_id", property="smsId", jdbcType=JdbcType.VARCHAR),
        @Result(column="sms_text", property="smsText", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_ent_wechat", property="isEntWechat", jdbcType=JdbcType.BIT),
        @Result(column="ent_wechat_text", property="entWechatText", jdbcType=JdbcType.VARCHAR),
        @Result(column="url", property="url", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_app", property="isApp", jdbcType=JdbcType.BIT),
        @Result(column="app_id", property="appId", jdbcType=JdbcType.INTEGER),
        @Result(column="variable", property="variable", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="custom_trigger", property="customTrigger", jdbcType=JdbcType.VARCHAR),
        @Result(column="custom_variable", property="customVariable", jdbcType=JdbcType.VARCHAR)
    })
    SystemNotification selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemNotificationSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemNotification record, @Param("example") SystemNotificationExample example);

    @UpdateProvider(type=SystemNotificationSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemNotification record, @Param("example") SystemNotificationExample example);

    @UpdateProvider(type=SystemNotificationSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemNotification record);

    @Update({
        "update eb_system_notification",
        "set mark = #{mark,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "title = #{title,jdbcType=VARCHAR},",
          "is_system = #{isSystem,jdbcType=BIT},",
          "system_title = #{systemTitle,jdbcType=VARCHAR},",
          "system_text = #{systemText,jdbcType=VARCHAR},",
          "is_wechat = #{isWechat,jdbcType=BIT},",
          "wechat_tempkey = #{wechatTempkey,jdbcType=VARCHAR},",
          "wechat_content = #{wechatContent,jdbcType=VARCHAR},",
          "wechat_kid = #{wechatKid,jdbcType=VARCHAR},",
          "wechat_tempid = #{wechatTempid,jdbcType=VARCHAR},",
          "wechat_data = #{wechatData,jdbcType=VARCHAR},",
          "wechat_link = #{wechatLink,jdbcType=VARCHAR},",
          "wechat_to_routine = #{wechatToRoutine,jdbcType=INTEGER},",
          "is_routine = #{isRoutine,jdbcType=BIT},",
          "routine_tempkey = #{routineTempkey,jdbcType=VARCHAR},",
          "routine_content = #{routineContent,jdbcType=VARCHAR},",
          "routine_kid = #{routineKid,jdbcType=VARCHAR},",
          "routine_tempid = #{routineTempid,jdbcType=VARCHAR},",
          "routine_data = #{routineData,jdbcType=VARCHAR},",
          "routine_link = #{routineLink,jdbcType=VARCHAR},",
          "is_sms = #{isSms,jdbcType=BIT},",
          "sms_id = #{smsId,jdbcType=VARCHAR},",
          "sms_text = #{smsText,jdbcType=VARCHAR},",
          "is_ent_wechat = #{isEntWechat,jdbcType=BIT},",
          "ent_wechat_text = #{entWechatText,jdbcType=VARCHAR},",
          "url = #{url,jdbcType=VARCHAR},",
          "is_app = #{isApp,jdbcType=BIT},",
          "app_id = #{appId,jdbcType=INTEGER},",
          "`variable` = #{variable,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=INTEGER},",
          "custom_trigger = #{customTrigger,jdbcType=VARCHAR},",
          "custom_variable = #{customVariable,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemNotification record);
}