package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysMenu;
import org.example.backend.common.primary.entity.SysMenuExample;

import java.util.List;

public interface SysMenuDao {
    @SelectProvider(type=SysMenuSqlProvider.class, method="countByExample")
    long countByExample(SysMenuExample example);

    @DeleteProvider(type=SysMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysMenuExample example);

    @Delete({
        "delete from sys_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_menu (parent_id, `path`, ",
        "`name`, `type`, icon, ",
        "router, is_bread_crumb, ",
        "permission_path, perms, ",
        "open_type, link, ",
        "redirect, visible, ",
        "sort, remark, is_init, ",
        "creator, create_time, ",
        "updater, update_time)",
        "values (#{parentId,jdbcType=INTEGER}, #{path,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{type,jdbcType=TINYINT}, #{icon,jdbcType=VARCHAR}, ",
        "#{router,jdbcType=VARCHAR}, #{isBreadCrumb,jdbcType=TINYINT}, ",
        "#{permissionPath,jdbcType=VARCHAR}, #{perms,jdbcType=VARCHAR}, ",
        "#{openType,jdbcType=TINYINT}, #{link,jdbcType=VARCHAR}, ",
        "#{redirect,jdbcType=VARCHAR}, #{visible,jdbcType=TINYINT}, ",
        "#{sort,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, #{isInit,jdbcType=BIT}, ",
        "#{creator,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updater,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SysMenu record);

    @InsertProvider(type=SysMenuSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SysMenu record);

    @SelectProvider(type=SysMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="router", property="router", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_bread_crumb", property="isBreadCrumb", jdbcType=JdbcType.TINYINT),
        @Result(column="permission_path", property="permissionPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="perms", property="perms", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_type", property="openType", jdbcType=JdbcType.TINYINT),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="redirect", property="redirect", jdbcType=JdbcType.VARCHAR),
        @Result(column="visible", property="visible", jdbcType=JdbcType.TINYINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_init", property="isInit", jdbcType=JdbcType.BIT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysMenu> selectByExample(SysMenuExample example);

    @Select({
        "select",
        "id, parent_id, `path`, `name`, `type`, icon, router, is_bread_crumb, permission_path, ",
        "perms, open_type, link, redirect, visible, sort, remark, is_init, creator, create_time, ",
        "updater, update_time",
        "from sys_menu",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.TINYINT),
        @Result(column="icon", property="icon", jdbcType=JdbcType.VARCHAR),
        @Result(column="router", property="router", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_bread_crumb", property="isBreadCrumb", jdbcType=JdbcType.TINYINT),
        @Result(column="permission_path", property="permissionPath", jdbcType=JdbcType.VARCHAR),
        @Result(column="perms", property="perms", jdbcType=JdbcType.VARCHAR),
        @Result(column="open_type", property="openType", jdbcType=JdbcType.TINYINT),
        @Result(column="link", property="link", jdbcType=JdbcType.VARCHAR),
        @Result(column="redirect", property="redirect", jdbcType=JdbcType.VARCHAR),
        @Result(column="visible", property="visible", jdbcType=JdbcType.TINYINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_init", property="isInit", jdbcType=JdbcType.BIT),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysMenu selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysMenu record, @Param("example") SysMenuExample example);

    @UpdateProvider(type=SysMenuSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysMenu record);

    @Update({
        "update sys_menu",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "`path` = #{path,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=TINYINT},",
          "icon = #{icon,jdbcType=VARCHAR},",
          "router = #{router,jdbcType=VARCHAR},",
          "is_bread_crumb = #{isBreadCrumb,jdbcType=TINYINT},",
          "permission_path = #{permissionPath,jdbcType=VARCHAR},",
          "perms = #{perms,jdbcType=VARCHAR},",
          "open_type = #{openType,jdbcType=TINYINT},",
          "link = #{link,jdbcType=VARCHAR},",
          "redirect = #{redirect,jdbcType=VARCHAR},",
          "visible = #{visible,jdbcType=TINYINT},",
          "sort = #{sort,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "is_init = #{isInit,jdbcType=BIT},",
          "creator = #{creator,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysMenu record);
}