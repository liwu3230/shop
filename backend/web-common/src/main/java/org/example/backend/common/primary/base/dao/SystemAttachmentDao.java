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
import org.example.backend.common.primary.entity.SystemAttachment;
import org.example.backend.common.primary.entity.SystemAttachmentExample;

public interface SystemAttachmentDao {
    @SelectProvider(type=SystemAttachmentSqlProvider.class, method="countByExample")
    long countByExample(SystemAttachmentExample example);

    @DeleteProvider(type=SystemAttachmentSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemAttachmentExample example);

    @Delete({
        "delete from eb_system_attachment",
        "where att_id = #{attId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer attId);

    @Insert({
        "insert into eb_system_attachment (`name`, att_dir, ",
        "satt_dir, att_size, att_type, ",
        "pid, `time`, image_type, ",
        "module_type, real_name, ",
        "scan_token)",
        "values (#{name,jdbcType=VARCHAR}, #{attDir,jdbcType=VARCHAR}, ",
        "#{sattDir,jdbcType=VARCHAR}, #{attSize,jdbcType=CHAR}, #{attType,jdbcType=CHAR}, ",
        "#{pid,jdbcType=INTEGER}, #{time,jdbcType=INTEGER}, #{imageType,jdbcType=TINYINT}, ",
        "#{moduleType,jdbcType=TINYINT}, #{realName,jdbcType=VARCHAR}, ",
        "#{scanToken,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="attId")
    int insert(SystemAttachment record);

    @InsertProvider(type=SystemAttachmentSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="attId")
    int insertSelective(SystemAttachment record);

    @SelectProvider(type=SystemAttachmentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="att_id", property="attId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_dir", property="attDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="satt_dir", property="sattDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_size", property="attSize", jdbcType=JdbcType.CHAR),
        @Result(column="att_type", property="attType", jdbcType=JdbcType.CHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.INTEGER),
        @Result(column="image_type", property="imageType", jdbcType=JdbcType.TINYINT),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.TINYINT),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="scan_token", property="scanToken", jdbcType=JdbcType.VARCHAR)
    })
    List<SystemAttachment> selectByExample(SystemAttachmentExample example);

    @Select({
        "select",
        "att_id, `name`, att_dir, satt_dir, att_size, att_type, pid, `time`, image_type, ",
        "module_type, real_name, scan_token",
        "from eb_system_attachment",
        "where att_id = #{attId,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="att_id", property="attId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_dir", property="attDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="satt_dir", property="sattDir", jdbcType=JdbcType.VARCHAR),
        @Result(column="att_size", property="attSize", jdbcType=JdbcType.CHAR),
        @Result(column="att_type", property="attType", jdbcType=JdbcType.CHAR),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="time", property="time", jdbcType=JdbcType.INTEGER),
        @Result(column="image_type", property="imageType", jdbcType=JdbcType.TINYINT),
        @Result(column="module_type", property="moduleType", jdbcType=JdbcType.TINYINT),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="scan_token", property="scanToken", jdbcType=JdbcType.VARCHAR)
    })
    SystemAttachment selectByPrimaryKey(Integer attId);

    @UpdateProvider(type=SystemAttachmentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemAttachment record, @Param("example") SystemAttachmentExample example);

    @UpdateProvider(type=SystemAttachmentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemAttachment record, @Param("example") SystemAttachmentExample example);

    @UpdateProvider(type=SystemAttachmentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemAttachment record);

    @Update({
        "update eb_system_attachment",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "att_dir = #{attDir,jdbcType=VARCHAR},",
          "satt_dir = #{sattDir,jdbcType=VARCHAR},",
          "att_size = #{attSize,jdbcType=CHAR},",
          "att_type = #{attType,jdbcType=CHAR},",
          "pid = #{pid,jdbcType=INTEGER},",
          "`time` = #{time,jdbcType=INTEGER},",
          "image_type = #{imageType,jdbcType=TINYINT},",
          "module_type = #{moduleType,jdbcType=TINYINT},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "scan_token = #{scanToken,jdbcType=VARCHAR}",
        "where att_id = #{attId,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemAttachment record);
}