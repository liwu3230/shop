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
import org.example.backend.common.primary.entity.SystemCity;
import org.example.backend.common.primary.entity.SystemCityExample;

public interface SystemCityDao {
    @SelectProvider(type=SystemCitySqlProvider.class, method="countByExample")
    long countByExample(SystemCityExample example);

    @DeleteProvider(type=SystemCitySqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemCityExample example);

    @Delete({
        "delete from eb_system_city",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_city (city_id, `level`, ",
        "parent_id, area_code, ",
        "`name`, merger_name, ",
        "lng, lat, is_show)",
        "values (#{cityId,jdbcType=INTEGER}, #{level,jdbcType=INTEGER}, ",
        "#{parentId,jdbcType=INTEGER}, #{areaCode,jdbcType=VARCHAR}, ",
        "#{name,jdbcType=VARCHAR}, #{mergerName,jdbcType=VARCHAR}, ",
        "#{lng,jdbcType=VARCHAR}, #{lat,jdbcType=VARCHAR}, #{isShow,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemCity record);

    @InsertProvider(type=SystemCitySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemCity record);

    @SelectProvider(type=SystemCitySqlProvider.class, method="selectByExample")
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
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.BIT)
    })
    List<SystemCity> selectByExample(SystemCityExample example);

    @Select({
        "select",
        "id, city_id, `level`, parent_id, area_code, `name`, merger_name, lng, lat, is_show",
        "from eb_system_city",
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
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.BIT)
    })
    SystemCity selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemCitySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemCity record, @Param("example") SystemCityExample example);

    @UpdateProvider(type=SystemCitySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemCity record, @Param("example") SystemCityExample example);

    @UpdateProvider(type=SystemCitySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemCity record);

    @Update({
        "update eb_system_city",
        "set city_id = #{cityId,jdbcType=INTEGER},",
          "`level` = #{level,jdbcType=INTEGER},",
          "parent_id = #{parentId,jdbcType=INTEGER},",
          "area_code = #{areaCode,jdbcType=VARCHAR},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "merger_name = #{mergerName,jdbcType=VARCHAR},",
          "lng = #{lng,jdbcType=VARCHAR},",
          "lat = #{lat,jdbcType=VARCHAR},",
          "is_show = #{isShow,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemCity record);
}