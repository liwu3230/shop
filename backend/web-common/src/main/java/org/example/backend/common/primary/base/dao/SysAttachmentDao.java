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
import org.example.backend.common.primary.entity.SysAttachment;
import org.example.backend.common.primary.entity.SysAttachmentExample;

public interface SysAttachmentDao {
    @SelectProvider(type=SysAttachmentSqlProvider.class, method="countByExample")
    long countByExample(SysAttachmentExample example);

    @DeleteProvider(type=SysAttachmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysAttachmentExample example);

    @Delete({
        "delete from sys_attachment",
        "where att_id = #{attId,jdbcType=BIGINT}"
    })
    int deleteByPrimaryKey(Long attId);

    @Insert({
        "insert into sys_attachment (`name`, real_name, ",
        "att_dir, satt_dir, ",
        "att_size, att_type, ",
        "pid, image_type, ",
        "module_type, create_time, ",
        "update_time, remark, ",
        "scan_token, user_name)",
        "values (#{name,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, ",
        "#{attDir,jdbcType=VARCHAR}, #{sattDir,jdbcType=VARCHAR}, ",
        "#{attSize,jdbcType=BIGINT}, #{attType,jdbcType=VARCHAR}, ",
        "#{pid,jdbcType=INTEGER}, #{imageType,jdbcType=TINYINT}, ",
        "#{moduleType,jdbcType=TINYINT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remark,jdbcType=VARCHAR}, ",
        "#{scanToken,jdbcType=VARCHAR}, #{userName,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="attId")
    int insert(SysAttachment record);

    @InsertProvider(type=SysAttachmentSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="attId")
    int insertSelective(SysAttachment record);

    @SelectProvider(type=SysAttachmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="att_id", property="attId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_dir", property="attDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="satt_dir", property="sattDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_size", property="attSize", jdbcType=JdbcType.BIGINT),
        @Result(column="att_type", property="attType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="image_type", property="imageType", jdbcType=JdbcType.TINYINT),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="scan_token", property="scanToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    List<SysAttachment> selectByExample(SysAttachmentExample example);

    @Select({
        "select",
        "att_id, `name`, real_name, att_dir, satt_dir, att_size, att_type, pid, image_type, ",
        "module_type, create_time, update_time, remark, scan_token, user_name",
        "from sys_attachment",
        "where att_id = #{attId,jdbcType=BIGINT}"
    })
    @Results({
        @Result(column="att_id", property="attId", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_dir", property="attDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="satt_dir", property="sattDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_size", property="attSize", jdbcType=JdbcType.BIGINT),
        @Result(column="att_type", property="attType", jdbcType=JdbcType.VARCHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="image_type", property="imageType", jdbcType=JdbcType.TINYINT),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="scan_token", property="scanToken", jdbcType=JdbcType.VARCHAR),
        @Result(column="user_name", property="userName", jdbcType=JdbcType.VARCHAR)
    })
    SysAttachment selectByPrimaryKey(Long attId);

    @UpdateProvider(type=SysAttachmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysAttachment record, @Param("example") SysAttachmentExample example);

    @UpdateProvider(type=SysAttachmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysAttachment record, @Param("example") SysAttachmentExample example);

    @UpdateProvider(type=SysAttachmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysAttachment record);

    @Update({
        "update sys_attachment",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "att_dir = #{attDir,jdbcType=VARCHAR},",
          "satt_dir = #{sattDir,jdbcType=VARCHAR},",
          "att_size = #{attSize,jdbcType=BIGINT},",
          "att_type = #{attType,jdbcType=VARCHAR},",
          "pid = #{pid,jdbcType=INTEGER},",
          "image_type = #{imageType,jdbcType=TINYINT},",
          "module_type = #{moduleType,jdbcType=TINYINT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "scan_token = #{scanToken,jdbcType=VARCHAR},",
          "user_name = #{userName,jdbcType=VARCHAR}",
        "where att_id = #{attId,jdbcType=BIGINT}"
    })
    int updateByPrimaryKey(SysAttachment record);
}