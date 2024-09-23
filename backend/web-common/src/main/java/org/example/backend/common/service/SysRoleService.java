package org.example.backend.common.service;

import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysRoleDto;
import org.example.backend.common.model.param.SysRoleParam;
import org.example.backend.common.model.param.SysUserParam;
import org.example.backend.common.primary.entity.SysRole;
import org.example.backend.common.primary.entity.SysUser;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:50
 */
public interface SysRoleService {

    SysRole findById(Integer roleId);

    Page<SysRoleDto> pageList(SysRoleParam param);

    List<Integer> findMenuIdsByRoleId(Integer roleId);

    void addOrEdit(SysRoleParam param);

    void grantMenu(SysRoleParam sysRoleParam);

    List<SysUser> findUserListByRoleId(Integer roleId);

    void roleAssocUser(SysRoleParam sysUserParam);

    void roleCancelUser(SysRoleParam sysUserParam);

    void deleteById(Integer id);

    List<SysRole> findAllList();

    List<SysRole> findByType(Integer type);

    List<Integer> findUserIdsByRoleId(Integer roleId);

    List<String> findUserNamesByRoleId(Integer roleId);

    List<Integer> findRolesByUserId(Integer userId);

    void userAssocRole(SysUserParam sysUserParam);

}
