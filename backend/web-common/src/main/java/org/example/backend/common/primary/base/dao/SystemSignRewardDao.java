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
import org.example.backend.common.primary.entity.SystemSignReward;
import org.example.backend.common.primary.entity.SystemSignRewardExample;

public interface SystemSignRewardDao {
    @SelectProvider(type=SystemSignRewardSqlProvider.class, method="countByExample")
    long countByExample(SystemSignRewardExample example);

    @DeleteProvider(type=SystemSignRewardSqlProvider.class, method="deleteByExample")
    int deleteByExample(SystemSignRewardExample example);

    @Delete({
        "delete from eb_system_sign_reward",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into eb_system_sign_reward (`type`, `days`, ",
        "point, `exp`)",
        "values (#{type,jdbcType=BIT}, #{days,jdbcType=INTEGER}, ",
        "#{point,jdbcType=INTEGER}, #{exp,jdbcType=INTEGER})"
    })
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insert(SystemSignReward record);

    @InsertProvider(type=SystemSignRewardSqlProvider.class, method="insertSelective")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int insertSelective(SystemSignReward record);

    @SelectProvider(type=SystemSignRewardSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="days", property="days", jdbcType=JdbcType.INTEGER),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="exp", property="exp", jdbcType=JdbcType.INTEGER)
    })
    List<SystemSignReward> selectByExample(SystemSignRewardExample example);

    @Select({
        "select",
        "id, `type`, `days`, point, `exp`",
        "from eb_system_sign_reward",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="type", property="type", jdbcType=JdbcType.BIT),
        @Result(column="days", property="days", jdbcType=JdbcType.INTEGER),
        @Result(column="point", property="point", jdbcType=JdbcType.INTEGER),
        @Result(column="exp", property="exp", jdbcType=JdbcType.INTEGER)
    })
    SystemSignReward selectByPrimaryKey(Integer id);

    @UpdateProvider(type=SystemSignRewardSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") SystemSignReward record, @Param("example") SystemSignRewardExample example);

    @UpdateProvider(type=SystemSignRewardSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") SystemSignReward record, @Param("example") SystemSignRewardExample example);

    @UpdateProvider(type=SystemSignRewardSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(SystemSignReward record);

    @Update({
        "update eb_system_sign_reward",
        "set `type` = #{type,jdbcType=BIT},",
          "`days` = #{days,jdbcType=INTEGER},",
          "point = #{point,jdbcType=INTEGER},",
          "`exp` = #{exp,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(SystemSignReward record);
}