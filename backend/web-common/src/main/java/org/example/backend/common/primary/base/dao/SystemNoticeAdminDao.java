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
import org.example.backend.common.primary.entity.SystemNoticeAdmin;
import org.example.backend.common.primary.entity.SystemNoticeAdminExample;

public interface SystemNoticeAdminDao {
    @SelectProvider(type=SystemNoticeAdminSqlProvider.class, method="countByExample")
    long countByExample(SystemNoticeAdminExample example);

    @DeleteProvider(type=SystemNoticeAdminSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemNoticeAdminExample example);

    @Delete({
        "delete from eb_system_notice_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_notice_admin (notice_type, admin_id, ",
        "link_id, table_data, ",
        "is_click, is_visit, ",
        "visit_time, add_time)",
        "values (#{noticeType,jdbcType=VARCHAR}, #{adminId,jdbcType=SMALLINT}, ",
        "#{linkId,jdbcType=INTEGER}, #{tableData,jdbcType=VARCHAR}, ",
        "#{isClick,jdbcType=TINYINT}, #{isVisit,jdbcType=TINYINT}, ",
        "#{visitTime,jdbcType=INTEGER}, #{addTime,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemNoticeAdmin record);

    @InsertProvider(type=SystemNoticeAdminSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemNoticeAdmin record);

    @SelectProvider(type=SystemNoticeAdminSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_type", property="noticeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.SMALLINT),
        @Result(column="link_id", property="linkId", jdbcType=JdbcType.INTEGER),
        @Result(column="table_data", property="tableData", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_click", property="isClick", jdbcType=JdbcType.TINYINT),
        @Result(column="is_visit", property="isVisit", jdbcType=JdbcType.TINYINT),
        @Result(column="visit_time", property="visitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER)
    })
    List<SystemNoticeAdmin> selectByExample(SystemNoticeAdminExample example);

    @Select({
        "select",
        "id, notice_type, admin_id, link_id, table_data, is_click, is_visit, visit_time, ",
        "add_time",
        "from eb_system_notice_admin",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="notice_type", property="noticeType", jdbcType=JdbcType.VARCHAR),
        @Result(column="admin_id", property="adminId", jdbcType=JdbcType.SMALLINT),
        @Result(column="link_id", property="linkId", jdbcType=JdbcType.INTEGER),
        @Result(column="table_data", property="tableData", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_click", property="isClick", jdbcType=JdbcType.TINYINT),
        @Result(column="is_visit", property="isVisit", jdbcType=JdbcType.TINYINT),
        @Result(column="visit_time", property="visitTime", jdbcType=JdbcType.INTEGER),
        @Result(column="add_time", property="addTime", jdbcType=JdbcType.INTEGER)
    })
    SystemNoticeAdmin selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemNoticeAdminSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemNoticeAdmin record, @Param("example") SystemNoticeAdminExample example);

    @UpdateProvider(type=SystemNoticeAdminSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemNoticeAdmin record, @Param("example") SystemNoticeAdminExample example);

    @UpdateProvider(type=SystemNoticeAdminSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemNoticeAdmin record);

    @Update({
        "update eb_system_notice_admin",
        "set notice_type = #{noticeType,jdbcType=VARCHAR},",
          "admin_id = #{adminId,jdbcType=SMALLINT},",
          "link_id = #{linkId,jdbcType=INTEGER},",
          "table_data = #{tableData,jdbcType=VARCHAR},",
          "is_click = #{isClick,jdbcType=TINYINT},",
          "is_visit = #{isVisit,jdbcType=TINYINT},",
          "visit_time = #{visitTime,jdbcType=INTEGER},",
          "add_time = #{addTime,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemNoticeAdmin record);
}