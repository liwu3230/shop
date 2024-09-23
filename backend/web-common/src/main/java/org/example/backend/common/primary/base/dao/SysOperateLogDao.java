package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysOperateLog;
import org.example.backend.common.primary.entity.SysOperateLogExample;

import java.util.List;

public interface SysOperateLogDao {
    @SelectProvider(type=SysOperateLogSqlProvider.class, method="countByExample")
    long countByExample(SysOperateLogExample example);

    @DeleteProvider(type=SysOperateLogSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysOperateLogExample example);

    @Delete({
        "delete from sys_operate_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long id);

    @Insert({
        "insert into sys_operate_log (id, op_type, ",
        "subject, subject_ext, ",
        "content, remark, ",
        "create_time, user_ip, ",
        "user_id, user_name)",
        "values (#{id,jdbcType=BIGINT}, #{opType,jdbcType=VARCHAR}, ",
        "#{subject,jdbcType=VARCHAR}, #{subjectExt,jdbcType=VARCHAR}, ",
        "#{content,jdbcType=VARCHAR}, #{remark,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{userIp,jdbcType=VARCHAR}, ",
        "#{userId,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR})"
    })
    int insert(SysOperateLog record);

    @InsertProvider(type=SysOperateLogSqlProvider.class, method="insertSelective")
    int insertSelective(SysOperateLog record);

    @SelectProvider(type=SysOperateLogSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="op_type", property="opType", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_ext", property="subjectExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_ip", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    List<SysOperateLog> selectByExample(SysOperateLogExample example);

    @Select({
        "select",
        "id, op_type, subject, subject_ext, content, remark, create_time, user_ip, user_id, ",
        "user_name",
        "from sys_operate_log",
        "where id = #{id,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="op_type", property="opType", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject", property="subject", jdbcType=JdbcType.VARCHAR),
        @Result(column="subject_ext", property="subjectExt", jdbcType=JdbcType.VARCHAR),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="user_ip", property="userIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    SysOperateLog selectByPrimaryKey(Long id);

    @UpdateProvider(type=SysOperateLogSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysOperateLog record, @Param("example") SysOperateLogExample example);

    @UpdateProvider(type=SysOperateLogSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysOperateLog record, @Param("example") SysOperateLogExample example);

    @UpdateProvider(type=SysOperateLogSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysOperateLog record);

    @Update({
        "update sys_operate_log",
        "set op_type = #{opType,jdbcType=VARCHAR},",
          "subject = #{subject,jdbcType=VARCHAR},",
          "subject_ext = #{subjectExt,jdbcType=VARCHAR},",
          "content = #{content,jdbcType=VARCHAR},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "user_ip = #{userIp,jdbcType=VARCHAR},",
          "user_id = #{userId,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysOperateLog record);
}