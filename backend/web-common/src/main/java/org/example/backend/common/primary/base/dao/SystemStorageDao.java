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
import org.example.backend.common.primary.entity.SystemStorage;
import org.example.backend.common.primary.entity.SystemStorageExample;

public interface SystemStorageDao {
    @SelectProvider(type=SystemStorageSqlProvider.class, method="countByExample")
    long countByExample(SystemStorageExample example);

    @DeleteProvider(type=SystemStorageSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemStorageExample example);

    @Delete({
        "delete from eb_system_storage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_storage (access_key, `type`, ",
        "`name`, region, acl, ",
        "`domain`, cdn, cname, ",
        "is_ssl, `status`, is_delete, ",
        "add_time, update_time)",
        "values (#{accessKey,jdbcType=VARCHAR}, #{type,jdbcType=BIT}, ",
        "#{name,jdbcType=VARCHAR}, #{region,jdbcType=VARCHAR}, #{acl,jdbcType=CHAR}, ",
        "#{domain,jdbcType=VARCHAR}, #{cdn,jdbcType=VARCHAR}, #{cname,jdbcType=VARCHAR}, ",
        "#{isSsl,jdbcType=BIT}, #{status,jdbcType=BIT}, #{isDelete,jdbcType=BIT}, ",
        "#{addTime,jdbcType=INTEGER}, #{updateTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemStorage record);

    @InsertProvider(type=SystemStorageSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemStorage record);

    @SelectProvider(type=SystemStorageSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="access_key", property="accessKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="acl", property="acl", jdbcType=JdbcType.CHAR),
        @Result(column="domain", property="domain", jdbcType=JdbcType.VARCHAR),
        @Result(column="cdn", property="cdn", jdbcType=JdbcType.VARCHAR),
        @Result(column="cname", property="cname", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_ssl", property="isSsl", jdbcType=JdbcType.BIT),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.BIT),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.INTEGER)
    })
    List<SystemStorage> selectByExample(SystemStorageExample example);

    @Select({
        "select",
        "id, access_key, `type`, `name`, region, acl, `domain`, cdn, cname, is_ssl, `status`, ",
        "is_delete, add_time, update_time",
        "from eb_system_storage",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="access_key", property="accessKey", jdbcType=JdbcType.VARCHAR),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="region", property="region", jdbcType=JdbcType.VARCHAR),
        @Result(column="acl", property="acl", jdbcType=JdbcType.CHAR),
        @Result(column="domain", property="domain", jdbcType=JdbcType.VARCHAR),
        @Result(column="cdn", property="cdn", jdbcType=JdbcType.VARCHAR),
        @Result(column="cname", property="cname", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_ssl", property="isSsl", jdbcType=JdbcType.BIT),
        @Result(column="status", property="status", jdbcType=JdbcType.BIT),
        @Result(column="is_delete", property="isDelete", jdbcType=JdbcType.BIT),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.INTEGER)
    })
    SystemStorage selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemStorageSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemStorage record, @Param("example") SystemStorageExample example);

    @UpdateProvider(type=SystemStorageSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemStorage record, @Param("example") SystemStorageExample example);

    @UpdateProvider(type=SystemStorageSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemStorage record);

    @Update({
        "update eb_system_storage",
        "set access_key = #{accessKey,jdbcType=VARCHAR},",
          "`type` = #{type,jdbcType=BIT},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "region = #{region,jdbcType=VARCHAR},",
          "acl = #{acl,jdbcType=CHAR},",
          "`domain` = #{domain,jdbcType=VARCHAR},",
          "cdn = #{cdn,jdbcType=VARCHAR},",
          "cname = #{cname,jdbcType=VARCHAR},",
          "is_ssl = #{isSsl,jdbcType=BIT},",
          "`status` = #{status,jdbcType=BIT},",
          "is_delete = #{isDelete,jdbcType=BIT},",
          "add_time = #{addTime,jdbcType=INTEGER},",
          "update_time = #{updateTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemStorage record);
}