package org.example.backend.common.service;

import org.example.backend.common.model.dto.BreadcrumbDto;
import org.example.backend.common.model.dto.SysMenuDto;
import org.example.backend.common.model.param.SysMenuParam;
import org.example.backend.common.primary.entity.SysMenu;
import org.example.backend.common.primary.entity.SysRoleMenuKey;

import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:06
 */
public interface SysMenuService {

    List<SysMenuDto> listTree(SysMenuParam param);

    List<SysMenu> findAll();

    List<SysRoleMenuKey> findRoleMenuList();

    List<String> findButtonPermsByUser(Integer userId);

    List<SysMenuDto> findMenuByUser(Integer userId);

    List<SysMenu> findByTypeIsNot(Integer type);

    void addOrEdit(SysMenuParam param);

    void deleteById(Integer id);

    Map<String, List<BreadcrumbDto>> findBreadcrumbByUser(Integer userId);
}
