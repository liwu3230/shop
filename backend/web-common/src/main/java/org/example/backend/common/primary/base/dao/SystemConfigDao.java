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
import org.example.backend.common.primary.entity.SystemConfig;
import org.example.backend.common.primary.entity.SystemConfigExample;

public interface SystemConfigDao {
    @SelectProvider(type=SystemConfigSqlProvider.class, method="countByExample")
    long countByExample(SystemConfigExample example);

    @DeleteProvider(type=SystemConfigSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemConfigExample example);

    @Delete({
        "delete from eb_system_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_config (menu_name, `type`, ",
        "input_type, config_tab_id, ",
        "`parameter`, upload_type, ",
        "required, width, ",
        "high, `value`, info, ",
        "`desc`, sort, `status`, ",
        "`level`, link_id, link_value)",
        "values (#{menuName,jdbcType=VARCHAR}, #{type,jdbcType=VARCHAR}, ",
        "#{inputType,jdbcType=VARCHAR}, #{configTabId,jdbcType=INTEGER}, ",
        "#{parameter,jdbcType=VARCHAR}, #{uploadType,jdbcType=TINYINT}, ",
        "#{required,jdbcType=VARCHAR}, #{width,jdbcType=INTEGER}, ",
        "#{high,jdbcType=INTEGER}, #{value,jdbcType=VARCHAR}, #{info,jdbcType=VARCHAR}, ",
        "#{desc,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER}, #{status,jdbcType=TINYINT}, ",
        "#{level,jdbcType=INTEGER}, #{linkId,jdbcType=INTEGER}, #{linkValue,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemConfig record);

    @InsertProvider(type=SystemConfigSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemConfig record);

    @SelectProvider(type=SystemConfigSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="input_type", property="inputType", jdbcType=JdbcType.VARCHAR),
        @Result(column="config_tab_id", property="configTabId", jdbcType=JdbcType.INTEGER),
        @Result(column="parameter", property="parameter", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_type", property="uploadType", jdbcType=JdbcType.TINYINT),
        @Result(column="required", property="required", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="high", property="high", jdbcType=JdbcType.INTEGER),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="link_id", property="linkId", jdbcType=JdbcType.INTEGER),
        @Result(column="link_value", property="linkValue", jdbcType=JdbcType.INTEGER)
    })
    List<SystemConfig> selectByExample(SystemConfigExample example);

    @Select({
        "select",
        "id, menu_name, `type`, input_type, config_tab_id, `parameter`, upload_type, ",
        "required, width, high, `value`, info, `desc`, sort, `status`, `level`, link_id, ",
        "link_value",
        "from eb_system_config",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.VARCHAR),
        @Result(column="input_type", property="inputType", jdbcType=JdbcType.VARCHAR),
        @Result(column="config_tab_id", property="configTabId", jdbcType=JdbcType.INTEGER),
        @Result(column="parameter", property="parameter", jdbcType=JdbcType.VARCHAR),
        @Result(column="upload_type", property="uploadType", jdbcType=JdbcType.TINYINT),
        @Result(column="required", property="required", jdbcType=JdbcType.VARCHAR),
        @Result(column="width", property="width", jdbcType=JdbcType.INTEGER),
        @Result(column="high", property="high", jdbcType=JdbcType.INTEGER),
        @Result(column="value", property="value", jdbcType=JdbcType.VARCHAR),
        @Result(column="info", property="info", jdbcType=JdbcType.VARCHAR),
        @Result(column="desc", property="desc", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="link_id", property="linkId", jdbcType=JdbcType.INTEGER),
        @Result(column="link_value", property="linkValue", jdbcType=JdbcType.INTEGER)
    })
    SystemConfig selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemConfigSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    @UpdateProvider(type=SystemConfigSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    @UpdateProvider(type=SystemConfigSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemConfig record);

    @Update({
        "update eb_system_config",
        "set menu_name = #{menuName,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=VARCHAR},",
          "input_type = #{inputType,jdbcType=VARCHAR},",
          "config_tab_id = #{configTabId,jdbcType=INTEGER},",
          "`parameter` = #{parameter,jdbcType=VARCHAR},",
          "upload_type = #{uploadType,jdbcType=TINYINT},",
          "required = #{required,jdbcType=VARCHAR},",
          "width = #{width,jdbcType=INTEGER},",
          "high = #{high,jdbcType=INTEGER},",
          "`value` = #{value,jdbcType=VARCHAR},",
          "info = #{info,jdbcType=VARCHAR},",
          "`desc` = #{desc,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "`status` = #{status,jdbcType=TINYINT},",
          "`level` = #{level,jdbcType=INTEGER},",
          "link_id = #{linkId,jdbcType=INTEGER},",
          "link_value = #{linkValue,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemConfig record);
}