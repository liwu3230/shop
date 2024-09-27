package org.example.backend.common.primary.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.backend.common.primary.base.dao.SysAttachmentDao;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/25 18:29
 */
public interface ISysAttachmentDao extends SysAttachmentDao {

    @Update({"""
            <script> 
                UPDATE sys_attachment SET pid = #{pid} WHERE att_id in 
                  <foreach collection="attIds" index="index" item="item" open="(" separator="," close=")">
                      #{item}
                 </foreach>
            </script>
            """})
    int updatePidByAttIds(@Param("attIds") List<Long> attIds, @Param("pid") Integer pid);

}
