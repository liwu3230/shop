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
import org.example.backend.common.primary.entity.SystemAttachmentCategory;
import org.example.backend.common.primary.entity.SystemAttachmentCategoryExample;

public interface SystemAttachmentCategoryDao {
    @SelectProvider(type=SystemAttachmentCategorySqlProvider.class, method="countByExample")
    long countByExample(SystemAttachmentCategoryExample example);

    @DeleteProvider(type=SystemAttachmentCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemAttachmentCategoryExample example);

    @Delete({
        "delete from eb_system_attachment_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_attachment_category (pid, `name`, ",
        "enname)",
        "values (#{pid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{enname,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemAttachmentCategory record);

    @InsertProvider(type=SystemAttachmentCategorySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemAttachmentCategory record);

    @SelectProvider(type=SystemAttachmentCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enname", property="enname", jdbcType=JdbcType.VARCHAR)
    })
    List<SystemAttachmentCategory> selectByExample(SystemAttachmentCategoryExample example);

    @Select({
        "select",
        "id, pid, `name`, enname",
        "from eb_system_attachment_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enname", property="enname", jdbcType=JdbcType.VARCHAR)
    })
    SystemAttachmentCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemAttachmentCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemAttachmentCategory record, @Param("example") SystemAttachmentCategoryExample example);

    @UpdateProvider(type=SystemAttachmentCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemAttachmentCategory record, @Param("example") SystemAttachmentCategoryExample example);

    @UpdateProvider(type=SystemAttachmentCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemAttachmentCategory record);

    @Update({
        "update eb_system_attachment_category",
        "set pid = #{pid,jdbcType=INTEGER},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "enname = #{enname,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemAttachmentCategory record);
}