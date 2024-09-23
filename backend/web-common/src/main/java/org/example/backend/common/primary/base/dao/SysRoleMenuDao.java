package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysRoleMenuExample;
import org.example.backend.common.primary.entity.SysRoleMenuKey;

import java.util.List;

public interface SysRoleMenuDao {
    @SelectProvider(type=SysRoleMenuSqlProvider.class, method="countByExample")
    long countByExample(SysRoleMenuExample example);

    @DeleteProvider(type=SysRoleMenuSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysRoleMenuExample example);

    @Delete({
        "delete from sys_role_menu",
        "where role_id = #{roleId,jdbcType=INTEGER}",
          "and menu_id = #{menuId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(SysRoleMenuKey key);

    @Insert({
        "insert into sys_role_menu (role_id, menu_id)",
        "values (#{roleId,jdbcType=INTEGER}, #{menuId,jdbcType=INTEGER})"
    })
    int insert(SysRoleMenuKey record);

    @InsertProvider(type=SysRoleMenuSqlProvider.class, method="insertSelective")
    int insertSelective(SysRoleMenuKey record);

    @SelectProvider(type=SysRoleMenuSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="menu_id", property="menuId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<SysRoleMenuKey> selectByExample(SysRoleMenuExample example);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysRoleMenuKey record, @Param("example") SysRoleMenuExample example);

    @UpdateProvider(type=SysRoleMenuSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysRoleMenuKey record, @Param("example") SysRoleMenuExample example);
}