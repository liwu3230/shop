package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysUserRoleExample;
import org.example.backend.common.primary.entity.SysUserRoleKey;

import java.util.List;

public interface SysUserRoleDao {
    @SelectProvider(type=SysUserRoleSqlProvider.class, method="countByExample")
    long countByExample(SysUserRoleExample example);

    @DeleteProvider(type=SysUserRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysUserRoleExample example);

    @Delete({
        "delete from sys_user_role",
        "where user_id = #{userId,jdbcType=INTEGER}",
          "and role_id = #{roleId,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(SysUserRoleKey key);

    @Insert({
        "insert into sys_user_role (user_id, role_id)",
        "values (#{userId,jdbcType=INTEGER}, #{roleId,jdbcType=INTEGER})"
    })
    int insert(SysUserRoleKey record);

    @InsertProvider(type=SysUserRoleSqlProvider.class, method="insertSelective")
    int insertSelective(SysUserRoleKey record);

    @SelectProvider(type=SysUserRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_id", property="roleId", jdbcType=JdbcType.INTEGER, id=true)
    })
    List<SysUserRoleKey> selectByExample(SysUserRoleExample example);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);

    @UpdateProvider(type=SysUserRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysUserRoleKey record, @Param("example") SysUserRoleExample example);
}