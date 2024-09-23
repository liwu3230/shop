package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysDict;
import org.example.backend.common.primary.entity.SysDictExample;

import java.util.List;

public interface SysDictDao {
    @SelectProvider(type=SysDictSqlProvider.class, method="countByExample")
    long countByExample(SysDictExample example);

    @DeleteProvider(type=SysDictSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDictExample example);

    @Delete({
        "delete from sys_dict",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_dict (code, `name`, ",
        "`status`, sort, remark, ",
        "creator, create_time, ",
        "updater, update_time, ",
        "`data`)",
        "values (#{code,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{status,jdbcType=TINYINT}, #{sort,jdbcType=INTEGER}, #{remark,jdbcType=VARCHAR}, ",
        "#{creator,jdbcType=VARCHAR}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updater,jdbcType=VARCHAR}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{data,jdbcType=LONGVARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SysDict record);

    @InsertProvider(type=SysDictSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SysDict record);

    @SelectProvider(type=SysDictSqlProvider.class, method="selectByExampleWithBLOBs")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    List<SysDict> selectByExampleWithBLOBs(SysDictExample example);

    @SelectProvider(type=SysDictSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysDict> selectByExample(SysDictExample example);

    @Select({
        "select",
        "id, code, `name`, `status`, sort, remark, creator, create_time, updater, update_time, ",
        "`data`",
        "from sys_dict",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="code", property="code", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="data", property="data", jdbcType=JdbcType.LONGVARCHAR)
    })
    SysDict selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExampleWithBLOBs")
    int updateByExampleWithBLOBs(@Param("record") SysDict record, @Param("example") SysDictExample example);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);

    @UpdateProvider(type=SysDictSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDict record);

    @Update({
        "update sys_dict",
        "set code = #{code,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=TINYINT},",
          "sort = #{sort,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP},",
          "`data` = #{data,jdbcType=LONGVARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKeyWithBLOBs(SysDict record);

    @Update({
        "update sys_dict",
        "set code = #{code,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "`status` = #{status,jdbcType=TINYINT},",
          "sort = #{sort,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysDict record);
}