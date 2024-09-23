package org.example.backend.common.primary.base.dao;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.example.backend.common.primary.entity.SysCity;
import org.example.backend.common.primary.entity.SysCityExample;

import java.util.List;

public interface SysCityDao {
    @SelectProvider(type=SysCitySqlProvider.class, method="countByExample")
    long countByExample(SysCityExample example);

    @DeleteProvider(type=SysCitySqlProvider.class, method="deleteByExample")
    int deleteByExample(SysCityExample example);

    @Delete({
        "delete from sys_city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_city (id, city_id, ",
        "`level`, parent_id, ",
        "area_code, `name`, ",
        "merger_name, lng, ",
        "lat, is_show, create_time, ",
        "update_time)",
        "values (#{id,jdbcType=INTEGER}, #{cityId,jdbcType=INTEGER}, ",
        "#{level,jdbcType=INTEGER}, #{parentId,jdbcType=INTEGER}, ",
        "#{areaCode,jdbcType=VARCHAR}, #{name,jdbcType=VARCHAR}, ",
        "#{mergerName,jdbcType=VARCHAR}, #{lng,jdbcType=VARCHAR}, ",
        "#{lat,jdbcType=VARCHAR}, #{isShow,jdbcType=BIT}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateTime,jdbcType=TIMESTAMP})"
    })
    int insert(SysCity record);

    @InsertProvider(type=SysCitySqlProvider.class, method="insertSelective")
    int insertSelective(SysCity record);

    @SelectProvider(type=SysCitySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_code", property="areaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="merger_name", property="mergerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<SysCity> selectByExample(SysCityExample example);

    @Select({
        "select",
        "id, city_id, `level`, parent_id, area_code, `name`, merger_name, lng, lat, is_show, ",
        "create_time, update_time",
        "from sys_city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="city_id", property="cityId", jdbcType=JdbcType.INTEGER),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER),
        @Result(column="parent_id", property="parentId", jdbcType=JdbcType.INTEGER),
        @Result(column="area_code", property="areaCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="merger_name", property="mergerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="lng", property="lng", jdbcType=JdbcType.VARCHAR),
        @Result(column="lat", property="lat", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    SysCity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysCitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysCity record, @Param("example") SysCityExample example);

    @UpdateProvider(type=SysCitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysCity record, @Param("example") SysCityExample example);

    @UpdateProvider(type=SysCitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysCity record);

    @Update({
        "update sys_city",
        "set city_id = #{cityId,jdbcType=INTEGER},",
          "`level` = #{level,jdbcType=INTEGER},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "area_code = #{areaCode,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "merger_name = #{mergerName,jdbcType=VARCHAR},",
          "lng = #{lng,jdbcType=VARCHAR},",
          "lat = #{lat,jdbcType=VARCHAR},",
          "is_show = #{isShow,jdbcType=BIT},",
          "create_time = #{createTime,jdbcType=TIMESTAMP},",
          "update_time = #{updateTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysCity record);
}