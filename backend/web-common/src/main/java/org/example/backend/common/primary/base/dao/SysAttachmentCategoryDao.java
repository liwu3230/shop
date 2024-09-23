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
import org.example.backend.common.primary.entity.SysAttachmentCategory;
import org.example.backend.common.primary.entity.SysAttachmentCategoryExample;

public interface SysAttachmentCategoryDao {
    @SelectProvider(type=SysAttachmentCategorySqlProvider.class, method="countByExample")
    long countByExample(SysAttachmentCategoryExample example);

    @DeleteProvider(type=SysAttachmentCategorySqlProvider.class, method="deleteByExample")
    int deleteByExample(SysAttachmentCategoryExample example);

    @Delete({
        "delete from sys_attachment_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into sys_attachment_category (pid, `name`, ",
        "enname)",
        "values (#{pid,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{enname,jdbcType=VARCHAR})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SysAttachmentCategory record);

    @InsertProvider(type=SysAttachmentCategorySqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SysAttachmentCategory record);

    @SelectProvider(type=SysAttachmentCategorySqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enname", property="enname", jdbcType=JdbcType.VARCHAR)
    })
    List<SysAttachmentCategory> selectByExample(SysAttachmentCategoryExample example);

    @Select({
        "select",
        "id, pid, `name`, enname",
        "from sys_attachment_category",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="pid", property="pid", jdbcType=JdbcType.INTEGER),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="enname", property="enname", jdbcType=JdbcType.VARCHAR)
    })
    SysAttachmentCategory selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SysAttachmentCategorySqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SysAttachmentCategory record, @Param("example") SysAttachmentCategoryExample example);

    @UpdateProvider(type=SysAttachmentCategorySqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SysAttachmentCategory record, @Param("example") SysAttachmentCategoryExample example);

    @UpdateProvider(type=SysAttachmentCategorySqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SysAttachmentCategory record);

    @Update({
        "update sys_attachment_category",
        "set pid = #{pid,jdbcType=INTEGER},",
          "`name` = #{name,jdbcType=VARCHAR},",
          "enname = #{enname,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SysAttachmentCategory record);
}