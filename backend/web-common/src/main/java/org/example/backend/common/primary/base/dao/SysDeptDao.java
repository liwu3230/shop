package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysDept;
import org.example.backend.common.primary.entity.SysDeptExample;

import java.util.List;

public interface SysDeptDao {
    @SelectProvider(type=SysDeptSqlProvider.class, method="countByExample")
    long countByExample(SysDeptExample example);

    @DeleteProvider(type=SysDeptSqlProvider.class, method="deleteByExample")
    int deleteByExample(SysDeptExample example);

    @Delete({
        "delete from sys_dept",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_dept (id, parent_id, ",
        "`path`, `name`, sort, ",
        "remark, creator, ",
        "create_time, updater, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{path,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, #{sort,jdbcType=INTEGER}, ",
        "#{remark,jdbcType=VARCHAR}, #{creator,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updater,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(SysDept record);

    @InsertProvider(type=SysDeptSqlProvider.class, method="insertSelective")
    int insertSelective(SysDept record);

    @SelectProvider(type=SysDeptSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysDept> selectByExample(SysDeptExample example);

    @Select({
        "select",
        "id, parent_id, `path`, `name`, sort, remark, creator, create_time, updater, ",
        "update_time",
        "from sys_dept",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="path", property="path", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.INTEGER),
        @Result(column="remark", property="remark", jdbcType=JdbcType.VARCHAR),
        @Result(column="creator", property="creator", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updater", property="updater", jdbcType=JdbcType.VARCHAR),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysDept selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysDept record, @Param("example") SysDeptExample example);

    @UpdateProvider(type=SysDeptSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysDept record);

    @Update({
        "update sys_dept",
        "set parent_id = #{parentId,jdbcType=INTEGER},",
          "`path` = #{path,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "sort = #{sort,jdbcType=INTEGER},",
          "remark = #{remark,jdbcType=VARCHAR},",
          "creator = #{creator,jdbcType=VARCHAR},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "updater = #{updater,jdbcType=VARCHAR},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysDept record);
}