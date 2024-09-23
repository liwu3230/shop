package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysConfig;
import org.example.backend.common.primary.entity.SysConfigExample;

import java.util.List;

public interface SysConfigDao {
    @SelectProvider(type=SysConfigSqlProvider.class, method="countByExample")
    long countByExample(SysConfigExample example);

    @DeleteProvider(type=SysConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysConfigExample example);

    @Delete({
        "delete from m_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into m_config (sys_key, `value`, ",
        "remark, creator, ",
        "create_time, updater, ",
        "update_time)",
        "values (#{sysKey,jdbcType=VARCHAR}, #{value,jdbcType=VARCHAR}, ",
        "#{remark,jdbcType=VARCHAR}, #{creator,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SysConfig record);

    @InsertProvider(type=SysConfigSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SysConfig record);

    @SelectProvider(type=SysConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sys_key", property="sysKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysConfig> selectByExample(SysConfigExample example);

    @Select({
        "select",
        "id, sys_key, `value`, remark, creator, create_time, updater, update_time",
        "from m_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sys_key", property="sysKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysConfig selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    @UpdateProvider(type=SysConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysConfig record, @Param("example") SysConfigExample example);

    @UpdateProvider(type=SysConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysConfig record);

    @Update({
        "update m_config",
        "set sys_key = #{sysKey,jdbcType=VARCHAR},",
          "`value` = #{value,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=INTEGER},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysConfig record);
}