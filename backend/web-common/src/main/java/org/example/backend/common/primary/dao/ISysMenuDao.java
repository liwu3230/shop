package org.example.backend.common.primary.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.backend.common.primary.base.dao.SysMenuDao;
import org.example.backend.common.primary.entity.SysMenu;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/29 14:26
 */
public interface ISysMenuDao extends SysMenuDao {

    @Select({"""
            <script> 
             select m.*  
             from sys_role_menu rm  
             left join sys_menu m on m.id = rm.menu_id  
             where (m.type in  
             <foreach collection="typeList" item="type" open="(" separator="," close=")"> 
              #{type} 
             </foreach> 
             and rm.role_id in (select distinct id from sys_role r where r.status = 0 )) 
             <if test="userId !=null and userId > 0 "> 
             or (m.type in  
             <foreach collection="typeList" item="type" open="(" separator="," close=")"> 
              #{type} 
             </foreach> 
             and rm.role_id in  
             (select distinct role_id from sys_user_role ur  
             left join sys_role r on r.id = ur.role_id  
             where r.status = 0 and ur.user_id = #{userId}))  
             </if> 
             group by m.id  
             order by m.sort asc  
            </script>
            """
    })
    List<SysMenu> findMenuListByUserId(@Param("typeList") List<Integer> typeList, @Param("userId") Integer userId);


    @Select({"""
             <script> 
             select m.* from sys_menu m
             left join sys_role_menu rm on m.id = rm.menu_id 
             left join sys_user_role ur on ur.role_id = rm.role_id  
             left join sys_role r on r.id = ur.role_id 
             where r.status = 0 and ur.user_id = #{userId}
             </script>
            """})
    List<SysMenu> findMenuByUserId(@Param("userId") Integer userId);

}
