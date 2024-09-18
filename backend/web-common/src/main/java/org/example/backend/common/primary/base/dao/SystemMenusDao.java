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
import org.example.backend.common.primary.entity.SystemMenus;
import org.example.backend.common.primary.entity.SystemMenusExample;

public interface SystemMenusDao {
    @SelectProvider(type=SystemMenusSqlProvider.class, method="countByExample")
    long countByExample(SystemMenusExample example);

    @DeleteProvider(type=SystemMenusSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemMenusExample example);

    @Delete({
        "delete from eb_system_menus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_menus (pid, icon, ",
        "menu_name, `module`, ",
        "controller, `action`, ",
        "api_url, methods, ",
        "params, sort, is_show, ",
        "is_show_path, `access`, ",
        "menu_path, `path`, ",
        "auth_type, `header`, is_header, ",
        "unique_auth, is_del, mark)",
        "values (#{pid,jdbcType=INTEGER}, #{icon,jdbcType=VARCHAR}, ",
        "#{menuName,jdbcType=VARCHAR}, #{module,jdbcType=VARCHAR}, ",
        "#{controller,jdbcType=VARCHAR}, #{action,jdbcType=VARCHAR}, ",
        "#{apiUrl,jdbcType=VARCHAR}, #{methods,jdbcType=VARCHAR}, ",
        "#{params,jdbcType=VARCHAR}, #{sort,jdbcType=TINYINT}, #{isShow,jdbcType=TINYINT}, ",
        "#{isShowPath,jdbcType=BIT}, #{access,jdbcType=TINYINT}, ",
        "#{menuPath,jdbcType=VARCHAR}, #{path,jdbcType=VARCHAR}, ",
        "#{authType,jdbcType=BIT}, #{header,jdbcType=VARCHAR}, #{isHeader,jdbcType=BIT}, ",
        "#{uniqueAuth,jdbcType=VARCHAR}, #{isDel,jdbcType=BIT}, #{mark,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemMenus record);

    @InsertProvider(type=SystemMenusSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemMenus record);

    @SelectProvider(type=SystemMenusSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="api_url", property="apiUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="methods", property="methods", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.TINYINT),
        @Result(column="is_show_path", property="isShowPath", jdbcType=JdbcType.BIT),
        @Result(column="access", property="access", jdbcType=JdbcType.TINYINT),
        @Result(column="menu_path", property="menuPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="auth_type", property="authType", jdbcType=JdbcType.BIT),
        @Result(column="header", property="header", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_header", property="isHeader", jdbcType=JdbcType.BIT),
        @Result(column="unique_auth", property="uniqueAuth", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR)
    })
    List<SystemMenus> selectByExample(SystemMenusExample example);

    @Select({
        "select",
        "id, pid, icon, menu_name, `module`, controller, `action`, api_url, methods, ",
        "params, sort, is_show, is_show_path, `access`, menu_path, `path`, auth_type, ",
        "`header`, is_header, unique_auth, is_del, mark",
        "from eb_system_menus",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="menu_name", property="menuName", jdbcType=JdbcType.VARCHAR),
        @Result(column="module", property="module", jdbcType=JdbcType.VARCHAR),
        @Result(column="controller", property="controller", jdbcType=JdbcType.VARCHAR),
        @Result(column="action", property="action", jdbcType=JdbcType.VARCHAR),
        @Result(column="api_url", property="apiUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="methods", property="methods", jdbcType=JdbcType.VARCHAR),
        @Result(column="params", property="params", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.TINYINT),
        @Result(column="is_show_path", property="isShowPath", jdbcType=JdbcType.BIT),
        @Result(column="access", property="access", jdbcType=JdbcType.TINYINT),
        @Result(column="menu_path", property="menuPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="auth_type", property="authType", jdbcType=JdbcType.BIT),
        @Result(column="header", property="header", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_header", property="isHeader", jdbcType=JdbcType.BIT),
        @Result(column="unique_auth", property="uniqueAuth", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT),
        @Result(column="mark", property="mark", jdbcType=JdbcType.VARCHAR)
    })
    SystemMenus selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemMenusSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemMenus record, @Param("example") SystemMenusExample example);

    @UpdateProvider(type=SystemMenusSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemMenus record, @Param("example") SystemMenusExample example);

    @UpdateProvider(type=SystemMenusSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemMenus record);

    @Update({
        "update eb_system_menus",
        "set pid = #{pid,jdbcType=INTEGER},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "menu_name = #{menuName,jdbcType=VARCHAR},",
          "`module` = #{module,jdbcType=VARCHAR},",
          "controller = #{controller,jdbcType=VARCHAR},",
          "`action` = #{action,jdbcType=VARCHAR},",
          "api_url = #{apiUrl,jdbcType=VARCHAR},",
          "methods = #{methods,jdbcType=VARCHAR},",
          "params = #{params,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=TINYINT},",
          "is_show = #{isShow,jdbcType=TINYINT},",
          "is_show_path = #{isShowPath,jdbcType=BIT},",
          "`access` = #{access,jdbcType=TINYINT},",
          "menu_path = #{menuPath,jdbcType=VARCHAR},",
          "`path` = #{path,jdbcType=VARCHAR},",
          "auth_type = #{authType,jdbcType=BIT},",
          "`header` = #{header,jdbcType=VARCHAR},",
          "is_header = #{isHeader,jdbcType=BIT},",
          "unique_auth = #{uniqueAuth,jdbcType=VARCHAR},",
          "is_del = #{isDel,jdbcType=BIT},",
          "mark = #{mark,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemMenus record);
}