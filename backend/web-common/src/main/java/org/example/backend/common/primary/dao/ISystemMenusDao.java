package org.example.backend.common.primary.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.backend.common.primary.base.dao.SystemMenusDao;
import org.example.backend.common.primary.entity.SystemMenus;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 13:09
 */
public interface ISystemMenusDao extends SystemMenusDao {

    @Select({"""
            SELECT m.* FROM eb_system_menus m 
            right join eb_system_role r on FIND_IN_SET(m.id, r.rules) 
            right join eb_system_admin a on FIND_IN_SET(r.id, a.roles) 
            where  m.is_del = 0 and r.`status` = 1 and m.auth_type != 2 and m.is_show = 1 
            and a.id = #{userId}
            GROUP BY m.id 
            """})
    List<SystemMenus> getMenusByUserId(@Param("userId") Integer userId);

    @Select({"""
             SELECT m.* 
             FROM eb_system_menu m 
             right join eb_system_role r on FIND_IN_SET(m.id, r.rules) 
             right join eb_system_admin a on FIND_IN_SET(r.id, a.roles) 
             where  m.is_del = 0 and r.`status` = 1 and a.id = #{userId} 
             GROUP BY m.id 
            """})
    List<SystemMenus> findPermissionByUserId(@Param("userId") Integer userId);
}
