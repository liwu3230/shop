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
import org.example.backend.common.primary.entity.SystemStore;
import org.example.backend.common.primary.entity.SystemStoreExample;

public interface SystemStoreDao {
    @SelectProvider(type=SystemStoreSqlProvider.class, method="countByExample")
    long countByExample(SystemStoreExample example);

    @DeleteProvider(type=SystemStoreSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemStoreExample example);

    @Delete({
        "delete from eb_system_store",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_store (`name`, introduction, ",
        "phone, address, detailed_address, ",
        "image, oblong_image, ",
        "latitude, longitude, valid_time, ",
        "day_time, add_time, ",
        "is_show, is_del)",
        "values (#{name,jdbcType=VARCHAR}, #{introduction,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=CHAR}, #{address,jdbcType=VARCHAR}, #{detailedAddress,jdbcType=VARCHAR}, ",
        "#{image,jdbcType=VARCHAR}, #{oblongImage,jdbcType=VARCHAR}, ",
        "#{latitude,jdbcType=CHAR}, #{longitude,jdbcType=CHAR}, #{validTime,jdbcType=VARCHAR}, ",
        "#{dayTime,jdbcType=VARCHAR}, #{addTime,jdbcType=INTEGER}, ",
        "#{isShow,jdbcType=BIT}, #{isDel,jdbcType=BIT})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemStore record);

    @InsertProvider(type=SystemStoreSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemStore record);

    @SelectProvider(type=SystemStoreSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailed_address", property="detailedAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="oblong_image", property="oblongImage", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.CHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.CHAR),
        @Result(column="valid_time", property="validTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="day_time", property="dayTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.BIT),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT)
    })
    List<SystemStore> selectByExample(SystemStoreExample example);

    @Select({
        "select",
        "id, `name`, introduction, phone, address, detailed_address, image, oblong_image, ",
        "latitude, longitude, valid_time, day_time, add_time, is_show, is_del",
        "from eb_system_store",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="introduction", property="introduction", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="address", property="address", jdbcType=JdbcType.VARCHAR),
        @Result(column="detailed_address", property="detailedAddress", jdbcType=JdbcType.VARCHAR),
        @Result(column="image", property="image", jdbcType=JdbcType.VARCHAR),
        @Result(column="oblong_image", property="oblongImage", jdbcType=JdbcType.VARCHAR),
        @Result(column="latitude", property="latitude", jdbcType=JdbcType.CHAR),
        @Result(column="longitude", property="longitude", jdbcType=JdbcType.CHAR),
        @Result(column="valid_time", property="validTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="day_time", property="dayTime", jdbcType=JdbcType.VARCHAR),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="is_show", property="isShow", jdbcType=JdbcType.BIT),
        @Result(column="is_del", property="isDel", jdbcType=JdbcType.BIT)
    })
    SystemStore selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemStoreSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemStore record, @Param("example") SystemStoreExample example);

    @UpdateProvider(type=SystemStoreSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemStore record, @Param("example") SystemStoreExample example);

    @UpdateProvider(type=SystemStoreSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemStore record);

    @Update({
        "update eb_system_store",
        "set `name` = #{name,jdbcType=VARCHAR},",
          "introduction = #{introduction,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "address = #{address,jdbcType=VARCHAR},",
          "detailed_address = #{detailedAddress,jdbcType=VARCHAR},",
          "image = #{image,jdbcType=VARCHAR},",
          "oblong_image = #{oblongImage,jdbcType=VARCHAR},",
          "latitude = #{latitude,jdbcType=CHAR},",
          "longitude = #{longitude,jdbcType=CHAR},",
          "valid_time = #{validTime,jdbcType=VARCHAR},",
          "day_time = #{dayTime,jdbcType=VARCHAR},",
          "add_time = #{addTime,jdbcType=INTEGER},",
          "is_show = #{isShow,jdbcType=BIT},",
          "is_del = #{isDel,jdbcType=BIT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemStore record);
}