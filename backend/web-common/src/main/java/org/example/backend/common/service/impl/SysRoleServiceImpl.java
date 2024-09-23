package org.example.backend.common.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.config.DbConstant;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysRoleDto;
import org.example.backend.common.model.enums.MenuType;
import org.example.backend.common.model.enums.RoleType;
import org.example.backend.common.model.param.SysRoleParam;
import org.example.backend.common.model.param.SysUserParam;
import org.example.backend.common.primary.base.dao.SysRoleDao;
import org.example.backend.common.primary.base.dao.SysRoleMenuDao;
import org.example.backend.common.primary.base.dao.SysUserRoleDao;
import org.example.backend.common.primary.entity.*;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysMenuService;
import org.example.backend.common.service.SysRoleService;
import org.example.backend.common.service.SysUserService;
import org.example.backend.common.util.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:50
 */
@Slf4j
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Resource
    private SysRoleDao sysRoleDao;
    @Resource
    private SysRoleMenuDao sysRoleMenuDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;
    @Resource
    private SysUserService sysUserService;
    @Resource
    private SysMenuService sysMenuService;

    @Override
    public SysRole findById(Integer roleId) {
        return sysRoleDao.selectByPrimaryKey(roleId);
    }

    @Override
    public Page<SysRoleDto> pageList(SysRoleParam param) {
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(param.getName())) {
            criteria.andNameLike("%" + param.getName() + "%");
        }
        if (T.isNotNull(param.getStatus())) {
            criteria.andStatusEqualTo(param.getStatus());
        }

        long count =  sysRoleDao.countByExample(example);
        example.setLimit(param.getLimit());
        example.setOffset(param.getOffset());
        example.setOrderByClause(" create_time desc");
        List<SysRoleDto> list =  sysRoleDao.selectByExample(example).stream().map(e -> {
            SysRoleDto dto = new SysRoleDto();
            BeanUtils.copyProperties(e, dto);
            dto.setRoleId(e.getId());
            return dto;
        }).collect(Collectors.toList());
        return new Page<>(list, param.getPage(), param.getLimit(), count);
    }

    @Override
    public List<Integer> findMenuIdsByRoleId(Integer roleId) {
        SysRoleMenuExample example = new SysRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return sysRoleMenuDao.selectByExample(example).stream().map(SysRoleMenuKey::getMenuId).distinct().collect(Collectors.toList());
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void addOrEdit(SysRoleParam param) {
        boolean isUpdate = param.getId() != null && param.getId() > 0;
        SysRoleExample example = new SysRoleExample();
        SysRoleExample.Criteria criteria = example.createCriteria();
        criteria.andNameEqualTo(param.getName());
        if (isUpdate) {
            criteria.andIdNotEqualTo(param.getId());
        }
        if ( sysRoleDao.countByExample(example) > 0) {
            throw new IllegalArgumentException("该名称已存在！");
        }

        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(param, sysRole);
        sysRole.setType(RoleType.NORMAL.getValue());
        if (isUpdate) {
            SysRole old =  sysRoleDao.selectByPrimaryKey(param.getId());
            if (T.isNull(old)) {
                throw new IllegalArgumentException("该记录不存在！");
            }
            sysRole.setUpdater(AuthenticationUtil.getUserName());
            sysRole.setUpdateTime(new Date());
            sysRole.setCreator(old.getCreator());
            sysRole.setCreateTime(old.getCreateTime());
             sysRoleDao.updateByPrimaryKey(sysRole);
        } else {
            sysRole.setCreator(AuthenticationUtil.getUserName());
            sysRole.setCreateTime(new Date());
             sysRoleDao.insert(sysRole);
        }
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void grantMenu(SysRoleParam param) {
        Integer roleId = param.getId();

        SysRole sysRole =  sysRoleDao.selectByPrimaryKey(roleId);
        if (T.isNull(sysRole)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        //过滤掉grantMenuIdList目录级别的id
        List<SysMenu> menuList = sysMenuService.findByTypeIsNot(MenuType.CATALOG.getValue());
        Set<Integer> menuIdSet = Optional.ofNullable(menuList).orElseGet(ArrayList::new).stream().filter(Objects::nonNull).map(SysMenu::getId).collect(Collectors.toSet());
        //取交集
        Optional.ofNullable(param.getGrantMenuIdList()).orElseGet(ArrayList::new).retainAll(menuIdSet);

        //删除所拥有菜单
        SysRoleMenuExample delExp = new SysRoleMenuExample();
        delExp.createCriteria().andRoleIdEqualTo(roleId);
        sysRoleMenuDao.deleteByExample(delExp);
        //授权菜单
        if (T.isNotEmpty(param.getGrantMenuIdList())) {
            param.getGrantMenuIdList().stream().distinct().forEach(menuId -> {
                SysRoleMenuKey sysRoleMenuKey = new SysRoleMenuKey();
                sysRoleMenuKey.setRoleId(roleId);
                sysRoleMenuKey.setMenuId(menuId);
                sysRoleMenuDao.insert(sysRoleMenuKey);
            });
        }
    }

    @Override
    public List<SysUser> findUserListByRoleId(Integer roleId) {
        List<Integer> userIds = findUserIdsByRoleId(roleId);
        if (T.isEmpty(userIds)) {
            return Collections.emptyList();
        }
        return sysUserService.findByIds(userIds);
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void roleAssocUser(SysRoleParam param) {
        List<Integer> assocUserIds = param.getAssocUserIds();
        if (T.isEmpty(assocUserIds)) {
            return;
        }
        Integer roleId = param.getId();
        //查询已关联的用户
        List<Integer> userIds = this.findUserIdsByRoleId(roleId);
        assocUserIds.removeAll(userIds);
        if (T.isNotEmpty(assocUserIds)) {
            assocUserIds.stream().distinct().forEach(userId -> {
                SysUserRoleKey sysUserRoleKey = new SysUserRoleKey();
                sysUserRoleKey.setRoleId(roleId);
                sysUserRoleKey.setUserId(userId);
                sysUserRoleDao.insert(sysUserRoleKey);
            });
        }
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void roleCancelUser(SysRoleParam param) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andRoleIdEqualTo(param.getId()).andUserIdIn(param.getAssocUserIds());
        sysUserRoleDao.deleteByExample(example);
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        SysRole sysRole =  sysRoleDao.selectByPrimaryKey(id);
        if (T.isNull(sysRole)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        if (!Objects.equals(RoleType.NORMAL.getValue(), sysRole.getType())) {
            throw new IllegalArgumentException("该角色类型不能删除！");
        }
         sysRoleDao.deleteByPrimaryKey(id);
        //根据角色id删除角色菜单关联表
        SysRoleMenuExample example = new SysRoleMenuExample();
        example.createCriteria().andRoleIdEqualTo(id);
        sysRoleMenuDao.deleteByExample(example);
        //根据角色id删除用户角色关联表
        SysUserRoleExample exp = new SysUserRoleExample();
        exp.createCriteria().andRoleIdEqualTo(id);
        sysUserRoleDao.deleteByExample(exp);
    }

    @Override
    public List<SysRole> findAllList() {
        return  sysRoleDao.selectByExample(null);
    }

    @Override
    public List<SysRole> findByType(Integer type) {
        SysRoleExample example = new SysRoleExample();
        example.createCriteria().andTypeEqualTo(type);
        return  sysRoleDao.selectByExample(example);
    }

    @Override
    public List<Integer> findUserIdsByRoleId(Integer roleId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andRoleIdEqualTo(roleId);
        return sysUserRoleDao.selectByExample(example).stream().map(SysUserRoleKey::getUserId).distinct().collect(Collectors.toList());
    }

    @Override
    public List<String> findUserNamesByRoleId(Integer roleId) {
        List<Integer> userIds = findUserIdsByRoleId(roleId);
        return sysUserService.findByIds(userIds).stream().map(SysUser::getUserName).distinct().collect(Collectors.toList());
    }

    @Override
    public List<Integer> findRolesByUserId(Integer userId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Integer> roleIds = sysUserRoleDao.selectByExample(example).stream().map(SysUserRoleKey::getRoleId).distinct().collect(Collectors.toList());
        if (T.isEmpty(roleIds)) {
            return Collections.emptyList();
        }
        return roleIds;
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void userAssocRole(SysUserParam param) {
        Integer userId = param.getId();
        //删除已关联的角色
        SysUserRoleExample exp = new SysUserRoleExample();
        exp.createCriteria().andUserIdEqualTo(userId);
        sysUserRoleDao.deleteByExample(exp);
        //关联角色
        if (T.isNotEmpty(param.getGrantRoleIdList())) {
            param.getGrantRoleIdList().stream().distinct().forEach(roleId -> {
                SysUserRoleKey record = new SysUserRoleKey();
                record.setRoleId(roleId);
                record.setUserId(userId);
                sysUserRoleDao.insert(record);
            });
        }
    }

}
