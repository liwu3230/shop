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
import org.example.backend.common.primary.entity.SystemLog;
import org.example.backend.common.primary.entity.SystemLogExample;

public interface SystemLogDao {
    @SelectProvider(type=SystemLogSqlProvider.class, method="countByExample")
    long countByExample(SystemLogExample example);

    @DeleteProvider(type=SystemLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemLogExample example);

    @Delete({
        "delete from eb_system_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into eb_system_log (admin_id, admin_name, ",
        "`path`, page, `method`, ",
        "ip, `type`, add_time, ",
        "merchant_id)",
        "values (#{adminId,jdbcType=INTEGER}, #{adminName,jdbcType=VARCHAR}, ",
        "#{path,jdbcType=VARCHAR}, #{page,jdbcType=VARCHAR}, #{method,jdbcType=VARCHAR}, ",
        "#{ip,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, #{addTime,jdbcType=INTEGER}, ",
        "#{merchantId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemLog record);

    @InsertProvider(type=SystemLogSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemLog record);

    @SelectProvider(type=SystemLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER),
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="page", property="page", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER)
    })
    List<SystemLog> selectByExample(SystemLogExample example);

    @Select({
        "select",
        "id, admin_id, admin_name, `path`, page, `method`, ip, `type`, add_time, merchant_id",
        "from eb_system_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.INTEGER),
        @Result(column="admin_name", property="adminName", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="page", property="page", jdbcType=JdbcType.VARCHAR),
        @Result(column="method", property="method", jdbcType=JdbcType.VARCHAR),
        @Result(column="ip", property="ip", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="merchant_id", property="merchantId", jdbcType=JdbcType.INTEGER)
    })
    SystemLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=SystemLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    @UpdateProvider(type=SystemLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemLog record, @Param("example") SystemLogExample example);

    @UpdateProvider(type=SystemLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemLog record);

    @Update({
        "update eb_system_log",
        "set admin_id = #{adminId,jdbcType=INTEGER},",
          "admin_name = #{adminName,jdbcType=VARCHAR},",
          "`path` = #{path,jdbcType=VARCHAR},",
          "page = #{page,jdbcType=VARCHAR},",
          "`method` = #{method,jdbcType=VARCHAR},",
          "ip = #{ip,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "add_time = #{addTime,jdbcType=INTEGER},",
          "merchant_id = #{merchantId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SystemLog record);
}