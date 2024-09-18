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
import org.example.backend.common.primary.entity.SystemRole;
import org.example.backend.common.primary.entity.SystemRoleExample;

public interface SystemRoleDao {
    @SelectProvider(type=SystemRoleSqlProvider.class, method="countByExample")
    long countByExample(SystemRoleExample example);

    @DeleteProvider(type=SystemRoleSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemRoleExample example);

    @Delete({
        "delete from eb_system_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_role (role_name, rules, ",
        "`level`, `status`)",
        "values (#{roleName,jdbcType=VARCHAR}, #{rules,jdbcType=VARCHAR}, ",
        "#{level,jdbcType=TINYINT}, #{status,jdbcType=TINYINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemRole record);

    @InsertProvider(type=SystemRoleSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemRole record);

    @SelectProvider(type=SystemRoleSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rules", property="rules", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    List<SystemRole> selectByExample(SystemRoleExample example);

    @Select({
        "select",
        "id, role_name, rules, `level`, `status`",
        "from eb_system_role",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="role_name", property="roleName", jdbcType=JdbcType.VARCHAR),
        @Result(column="rules", property="rules", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT)
    })
    SystemRole selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemRoleSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemRole record, @Param("example") SystemRoleExample example);

    @UpdateProvider(type=SystemRoleSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemRole record, @Param("example") SystemRoleExample example);

    @UpdateProvider(type=SystemRoleSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemRole record);

    @Update({
        "update eb_system_role",
        "set role_name = #{roleName,jdbcType=VARCHAR},",
          "rules = #{rules,jdbcType=VARCHAR},",
          "`level` = #{level,jdbcType=TINYINT},",
          "`status` = #{status,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemRole record);
}