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
import org.example.backend.common.primary.entity.SystemConfigTab;
import org.example.backend.common.primary.entity.SystemConfigTabExample;

public interface SystemConfigTabDao {
    @SelectProvider(type=SystemConfigTabSqlProvider.class, method="countByExample")
    long countByExample(SystemConfigTabExample example);

    @DeleteProvider(type=SystemConfigTabSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemConfigTabExample example);

    @Delete({
        "delete from eb_system_config_tab",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_config_tab (pid, title, ",
        "eng_title, `status`, ",
        "info, icon, `type`, ",
        "sort, menus_id)",
        "values (#{pid,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, ",
        "#{engTitle,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{info,jdbcType=TINYINT}, #{icon,jdbcType=VARCHAR}, #{type,jdbcType=INTEGER}, ",
        "#{sort,jdbcType=INTEGER}, #{menusId,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemConfigTab record);

    @InsertProvider(type=SystemConfigTabSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemConfigTab record);

    @SelectProvider(type=SystemConfigTabSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="eng_title", property="engTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="info", property="info", jdbcType=JdbcType.TINYINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="menus_id", property="menusId", jdbcType=JdbcType.INTEGER)
    })
    List<SystemConfigTab> selectByExample(SystemConfigTabExample example);

    @Select({
        "select",
        "id, pid, title, eng_title, `status`, info, icon, `type`, sort, menus_id",
        "from eb_system_config_tab",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="eng_title", property="engTitle", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="info", property="info", jdbcType=JdbcType.TINYINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.INTEGER),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="menus_id", property="menusId", jdbcType=JdbcType.INTEGER)
    })
    SystemConfigTab selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemConfigTabSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemConfigTab record, @Param("example") SystemConfigTabExample example);

    @UpdateProvider(type=SystemConfigTabSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemConfigTab record, @Param("example") SystemConfigTabExample example);

    @UpdateProvider(type=SystemConfigTabSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemConfigTab record);

    @Update({
        "update eb_system_config_tab",
        "set pid = #{pid,jdbcType=INTEGER},",
          "title = #{title,jdbcType=VARCHAR},",
          "eng_title = #{engTitle,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=TINYINT},",
          "info = #{info,jdbcType=TINYINT},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=INTEGER},",
          "sort = #{sort,jdbcType=INTEGER},",
          "menus_id = #{menusId,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemConfigTab record);
}