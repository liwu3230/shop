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
import org.example.backend.common.primary.entity.SystemStoreStaff;
import org.example.backend.common.primary.entity.SystemStoreStaffExample;

public interface SystemStoreStaffDao {
    @SelectProvider(type=SystemStoreStaffSqlProvider.class, method="countByExample")
    long countByExample(SystemStoreStaffExample example);

    @DeleteProvider(type=SystemStoreStaffSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemStoreStaffExample example);

    @Delete({
        "delete from eb_system_store_staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_store_staff (`uid`, avatar, ",
        "store_id, staff_name, ",
        "phone, verify_status, ",
        "`status`, add_time)",
        "values (#{uid,jdbcType=INTEGER}, #{avatar,jdbcType=VARCHAR}, ",
        "#{storeId,jdbcType=INTEGER}, #{staffName,jdbcType=VARCHAR}, ",
        "#{phone,jdbcType=CHAR}, #{verifyStatus,jdbcType=TINYINT}, ",
        "#{status,jdbcType=TINYINT}, #{addTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemStoreStaff record);

    @InsertProvider(type=SystemStoreStaffSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemStoreStaff record);

    @SelectProvider(type=SystemStoreStaffSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_name", property="staffName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER)
    })
    List<SystemStoreStaff> selectByExample(SystemStoreStaffExample example);

    @Select({
        "select",
        "id, `uid`, avatar, store_id, staff_name, phone, verify_status, `status`, add_time",
        "from eb_system_store_staff",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="uid", property="uid", jdbcType=JdbcType.INTEGER),
        @Result(column="avatar", property="avatar", jdbcType=JdbcType.VARCHAR),
        @Result(column="store_id", property="storeId", jdbcType=JdbcType.INTEGER),
        @Result(column="staff_name", property="staffName", jdbcType=JdbcType.VARCHAR),
        @Result(column="phone", property="phone", jdbcType=JdbcType.CHAR),
        @Result(column="verify_status", property="verifyStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER)
    })
    SystemStoreStaff selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemStoreStaffSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemStoreStaff record, @Param("example") SystemStoreStaffExample example);

    @UpdateProvider(type=SystemStoreStaffSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemStoreStaff record, @Param("example") SystemStoreStaffExample example);

    @UpdateProvider(type=SystemStoreStaffSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemStoreStaff record);

    @Update({
        "update eb_system_store_staff",
        "set `uid` = #{uid,jdbcType=INTEGER},",
          "avatar = #{avatar,jdbcType=VARCHAR},",
          "store_id = #{storeId,jdbcType=INTEGER},",
          "staff_name = #{staffName,jdbcType=VARCHAR},",
          "phone = #{phone,jdbcType=CHAR},",
          "verify_status = #{verifyStatus,jdbcType=TINYINT},",
          "`status` = #{status,jdbcType=TINYINT},",
          "add_time = #{addTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemStoreStaff record);
}