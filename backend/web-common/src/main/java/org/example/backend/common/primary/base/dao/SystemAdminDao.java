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
import org.example.backend.common.primary.entity.SystemAdmin;
import org.example.backend.common.primary.entity.SystemAdminExample;

public interface SystemAdminDao {
    @SelectProvider(type=SystemAdminSqlProvider.class, method="countByExample")
    long countByExample(SystemAdminExample example);

    @DeleteProvider(type=SystemAdminSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemAdminExample example);

    @Delete({
        "delete from eb_system_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_admin (account, head_pic, ",
        "pwd, real_name, roles, ",
        "last_ip, last_time, ",
        "add_time, login_count, ",
        "`level`, `status`, division_id, ",
        "is_del)",
        "values (#{account,jdbcType=VARCHAR}, #{headPic,jdbcType=VARCHAR}, ",
        "#{pwd,jdbcType=VARCHAR}, #{realName,jdbcType=VARCHAR}, #{roles,jdbcType=VARCHAR}, ",
        "#{lastIp,jdbcType=VARCHAR}, #{lastTime,jdbcType=INTEGER}, ",
        "#{addTime,jdbcType=INTEGER}, #{loginCount,jdbcType=INTEGER}, ",
        "#{level,jdbcType=TINYINT}, #{status,jdbcType=TINYINT}, #{divisionId,jdbcType=INTEGER}, ",
        "#{isDel,jdbcType=TINYINT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemAdmin record);

    @InsertProvider(type=SystemAdminSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemAdmin record);

    @SelectProvider(type=SystemAdminSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="head_pic", property="headPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="roles", property="roles", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_ip", property="lastIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="login_count", property="loginCount", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="division_id", property="divisionId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.TINYINT)
    })
    List<SystemAdmin> selectByExample(SystemAdminExample example);

    @Select({
        "select",
        "id, account, head_pic, pwd, real_name, roles, last_ip, last_time, add_time, ",
        "login_count, `level`, `status`, division_id, is_del",
        "from eb_system_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="account", property="account", jdbcType=JdbcType.VARCHAR),
        @Result(column="head_pic", property="headPic", jdbcType=JdbcType.VARCHAR),
        @Result(column="pwd", property="pwd", jdbcType=JdbcType.VARCHAR),
        @Result(column="real_name", property="realName", jdbcType=JdbcType.VARCHAR),
        @Result(column="roles", property="roles", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_ip", property="lastIp", jdbcType=JdbcType.VARCHAR),
        @Result(column="last_time", property="lastTime", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="login_count", property="loginCount", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="division_id", property="divisionId", jdbcType=JdbcType.INTEGER),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.TINYINT)
    })
    SystemAdmin selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemAdminSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemAdmin record, @Param("example") SystemAdminExample example);

    @UpdateProvider(type=SystemAdminSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemAdmin record, @Param("example") SystemAdminExample example);

    @UpdateProvider(type=SystemAdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemAdmin record);

    @Update({
        "update eb_system_admin",
        "set account = #{account,jdbcType=VARCHAR},",
          "head_pic = #{headPic,jdbcType=VARCHAR},",
          "pwd = #{pwd,jdbcType=VARCHAR},",
          "real_name = #{realName,jdbcType=VARCHAR},",
          "roles = #{roles,jdbcType=VARCHAR},",
          "last_ip = #{lastIp,jdbcType=VARCHAR},",
          "last_time = #{lastTime,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=INTEGER},",
          "login_count = #{loginCount,jdbcType=INTEGER},",
          "`level` = #{level,jdbcType=TINYINT},",
          "`status` = #{status,jdbcType=TINYINT},",
          "division_id = #{divisionId,jdbcType=INTEGER},",
          "is_del = #{isDel,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemAdmin record);
}