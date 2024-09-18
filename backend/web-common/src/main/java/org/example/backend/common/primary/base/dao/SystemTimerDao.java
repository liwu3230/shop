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
import org.example.backend.common.primary.entity.SystemTimer;
import org.example.backend.common.primary.entity.SystemTimerExample;

public interface SystemTimerDao {
    @SelectProvider(type=SystemTimerSqlProvider.class, method="countByExample")
    long countByExample(SystemTimerExample example);

    @DeleteProvider(type=SystemTimerSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemTimerExample example);

    @Delete({
        "delete from eb_system_timer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_timer (`name`, mark, ",
        "content, `type`, `month`, ",
        "week, `day`, `hour`, ",
        "`minute`, `second`, ",
        "last_execution_time, next_execution_time, ",
        "add_time, is_del, is_open, ",
        "customCode, timeStr)",
        "values (#{name,jdbcType=VARCHAR}, #{mark,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{type,jdbcType=BIT}, #{month,jdbcType=INTEGER}, ",
        "#{week,jdbcType=INTEGER}, #{day,jdbcType=INTEGER}, #{hour,jdbcType=INTEGER}, ",
        "#{minute,jdbcType=INTEGER}, #{second,jdbcType=INTEGER}, ",
        "#{lastExecutionTime,jdbcType=INTEGER}, #{nextExecutionTime,jdbcType=INTEGER}, ",
        "#{addTime,jdbcType=INTEGER}, #{isDel,jdbcType=BIT}, #{isOpen,jdbcType=BIT}, ",
        "#{customcode,jdbcType=VARCHAR}, #{timestr,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemTimer record);

    @InsertProvider(type=SystemTimerSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemTimer record);

    @SelectProvider(type=SystemTimerSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER),
        @Result(column="day", property="day", jdbcType=JdbcType.INTEGER),
        @Result(column="hour", property="hour", jdbcType=JdbcType.INTEGER),
        @Result(column="minute", property="minute", jdbcType=JdbcType.INTEGER),
        @Result(column="second", property="second", jdbcType=JdbcType.INTEGER),
        @Result(column="last_execution_time", property="lastExecutionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="next_execution_time", property="nextExecutionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT),
        @Result(column="is_open", property="isOpen", jdbcType=JdbcType.BIT),
        @Result(column="customCode", property="customcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="timeStr", property="timestr", jdbcType=JdbcType.VARCHAR)
    })
    List<SystemTimer> selectByExample(SystemTimerExample example);

    @Select({
        "select",
        "id, `name`, mark, content, `type`, `month`, week, `day`, `hour`, `minute`, `second`, ",
        "last_execution_time, next_execution_time, add_time, is_del, is_open, customCode, ",
        "timeStr",
        "from eb_system_timer",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="month", property="month", jdbcType=JdbcType.INTEGER),
        @Result(column="week", property="week", jdbcType=JdbcType.INTEGER),
        @Result(column="day", property="day", jdbcType=JdbcType.INTEGER),
        @Result(column="hour", property="hour", jdbcType=JdbcType.INTEGER),
        @Result(column="minute", property="minute", jdbcType=JdbcType.INTEGER),
        @Result(column="second", property="second", jdbcType=JdbcType.INTEGER),
        @Result(column="last_execution_time", property="lastExecutionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="next_execution_time", property="nextExecutionTime", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT),
        @Result(column="is_open", property="isOpen", jdbcType=JdbcType.BIT),
        @Result(column="customCode", property="customcode", jdbcType=JdbcType.VARCHAR),
        @Result(column="timeStr", property="timestr", jdbcType=JdbcType.VARCHAR)
    })
    SystemTimer selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemTimerSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemTimer record, @Param("example") SystemTimerExample example);

    @UpdateProvider(type=SystemTimerSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemTimer record, @Param("example") SystemTimerExample example);

    @UpdateProvider(type=SystemTimerSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemTimer record);

    @Update({
        "update eb_system_timer",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "mark = #{mark,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=BIT},",
          "`month` = #{month,jdbcType=INTEGER},",
          "week = #{week,jdbcType=INTEGER},",
          "`day` = #{day,jdbcType=INTEGER},",
          "`hour` = #{hour,jdbcType=INTEGER},",
          "`minute` = #{minute,jdbcType=INTEGER},",
          "`second` = #{second,jdbcType=INTEGER},",
          "last_execution_time = #{lastExecutionTime,jdbcType=INTEGER},",
          "next_execution_time = #{nextExecutionTime,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=INTEGER},",
          "is_del = #{isDel,jdbcType=BIT},",
          "is_open = #{isOpen,jdbcType=BIT},",
          "customCode = #{customcode,jdbcType=VARCHAR},",
          "timeStr = #{timestr,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemTimer record);
}