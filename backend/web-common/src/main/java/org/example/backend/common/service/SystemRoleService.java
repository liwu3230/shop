package org.example.backend.common.service;

import cn.hutool.core.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.req.SystemRoleRequest;
import org.example.backend.common.model.req.SystemRoleSearchRequest;
import org.example.backend.common.model.resp.RoleInfoResponse;
import org.example.backend.common.model.vo.LoginUserVo;
import org.example.backend.common.model.vo.MenuCheckTree;
import org.example.backend.common.model.vo.MenuCheckVo;
import org.example.backend.common.primary.base.dao.SystemRoleDao;
import org.example.backend.common.primary.entity.SystemAdmin;
import org.example.backend.common.primary.entity.SystemMenus;
import org.example.backend.common.primary.entity.SystemRole;
import org.example.backend.common.primary.entity.SystemRoleExample;
import org.example.backend.common.utils.CommaSplitUtils;
import org.example.backend.common.utils.SecurityUtil;
import org.example.backend.common.utils.T;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Slf4j
@Service
public class SystemRoleService {

    @Resource
    SystemRoleDao systemRoleDao;
    @Resource
    SystemMenuService systemMenuService;

    /**
     * 获取所有角色
     */
    public List<SystemRole> getAllList() {
        SystemRoleExample example = new SystemRoleExample();
        example.createCriteria().andStatusEqualTo(1);
        example.setOrderByClause(" id asc ");
        return systemRoleDao.selectByExample(example);
    }

    /**
     * 列表
     */
    public Page<SystemRole> getList(SystemRoleSearchRequest request) {
        SystemRoleExample example = new SystemRoleExample();
        SystemRoleExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(request.getRoleName())) {
            criteria.andRoleNameLike("%" + request.getRoleName() + "%");
        }
        if (T.nonNull(request.getStatus())) {
            criteria.andStatusEqualTo(request.getStatus());
        }
        long count = systemRoleDao.countByExample(example);

        example.setLimit(request.getLimit());
        example.setOffset(request.getOffset());
        example.setOrderByClause(" id asc ");

        List<SystemRole> list = systemRoleDao.selectByExample(example);
        return new Page<>(list, request.getPage(), request.getLimit(), count);
    }

    /**
     * 根据id集合获取对应权限列表
     */
    public List<SystemRole> getListInIds(List<Integer> ids) {
        if (T.isEmpty(ids)) {
            return Collections.emptyList();
        }
        SystemRoleExample example = new SystemRoleExample();
        example.createCriteria().andIdIn(ids);
        return systemRoleDao.selectByExample(example);
    }

    /**
     * 修改角色状态
     */
    public void updateStatus(Integer id, Integer status) {
        SystemRole role = systemRoleDao.selectByPrimaryKey(id);
        if (ObjectUtil.isNull(role)) {
            throw new RuntimeException("身份不存在");
        }
        if (Objects.equals(role.getStatus(), status)) {
            return;
        }
        role.setStatus(status);
        systemRoleDao.updateByPrimaryKey(role);
    }

    /**
     * 添加角色
     */
    public void add(SystemRoleRequest systemRoleRequest) {
        if (existName(systemRoleRequest.getRoleName(), null)) {
            throw new RuntimeException("角色名称重复");
        }
        List<Integer> ruleList = Stream.of(systemRoleRequest.getRules().split(",")).map(Integer::valueOf).distinct().collect(Collectors.toList());
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(systemRoleRequest, systemRole);
        systemRole.setId(null);
        systemRole.setRules(CommaSplitUtils.toString(ruleList));
        systemRoleDao.insert(systemRole);
    }

    /**
     * 判断角色名称是否存在
     */
    private Boolean existName(String roleName, Integer id) {
        SystemRoleExample example = new SystemRoleExample();
        SystemRoleExample.Criteria criteria = example.createCriteria();
        criteria.andRoleNameEqualTo(roleName);
        if (ObjectUtil.isNotNull(id)) {
            criteria.andIdNotEqualTo(id);
        }
        return systemRoleDao.countByExample(example) > 0;
    }

    /**
     * 修改角色
     */
    @Transactional(rollbackFor = Exception.class)
    public void edit(SystemRoleRequest systemRoleRequest) {
        SystemRole role = systemRoleDao.selectByPrimaryKey(systemRoleRequest.getId());
        if (ObjectUtil.isNull(role)) {
            throw new RuntimeException("角色不存在");
        }
        if (!role.getRoleName().equals(systemRoleRequest.getRoleName())) {
            if (existName(systemRoleRequest.getRoleName(), systemRoleRequest.getId())) {
                throw new RuntimeException("角色名称重复");
            }
        }
        List<Integer> ruleList = Stream.of(systemRoleRequest.getRules().split(",")).map(Integer::valueOf).distinct().collect(Collectors.toList());
        SystemRole systemRole = new SystemRole();
        BeanUtils.copyProperties(systemRoleRequest, systemRole);
        systemRole.setRules(CommaSplitUtils.toString(ruleList));

        systemRoleDao.updateByPrimaryKey(systemRole);
    }

    /**
     * 删除角色
     */
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        SystemRole systemRole = systemRoleDao.selectByPrimaryKey(id);
        if (ObjectUtil.isNull(systemRole)) {
            throw new RuntimeException("角色已删除");
        }
        systemRoleDao.deleteByPrimaryKey(id);
    }

    /**
     * 获取角色详情
     */
    public RoleInfoResponse getInfo(Integer id) {
        SystemRole systemRole = systemRoleDao.selectByPrimaryKey(id);
        if (ObjectUtil.isNull(systemRole)) {
            throw new RuntimeException("角色不存在");
        }
        // 查询角色对应的菜单(权限)
        List<SystemMenus> menuList = systemMenuService.getCacheList();
        List<Integer> menuIdList = CommaSplitUtils.toIntegerList(systemRole.getRules());

        List<MenuCheckVo> menuCheckVoList = menuList.stream().map(menu -> {
            MenuCheckVo menuCheckVo = new MenuCheckVo();
            BeanUtils.copyProperties(menu, menuCheckVo);
            if (menuIdList.contains(menu.getId())) {
                menuCheckVo.setChecked(true);
            } else {
                menuCheckVo.setChecked(false);
            }
            return menuCheckVo;
        }).collect(Collectors.toList());

        RoleInfoResponse response = new RoleInfoResponse();
        BeanUtils.copyProperties(systemRole, response);
        response.setMenuList(new MenuCheckTree(menuCheckVoList).buildTree());
        return response;
    }

    private List<Integer> getRoleListInRoleId() {
        //获取当前用户的所有权限
        LoginUserVo loginUserVo = SecurityUtil.getLoginUserVo();
        SystemAdmin systemAdmin = loginUserVo.getUser();
        if (null == systemAdmin || StringUtils.isBlank(systemAdmin.getRoles())) {
            throw new RuntimeException("没有权限访问！");
        }

        //获取用户权限组
        List<SystemRole> systemRoleList = getVoListInId(systemAdmin.getRoles());
        if (T.isEmpty(systemRoleList)) {
            throw new RuntimeException("没有权限访问！");
        }

        //获取用户权限规则
        List<Integer> categoryIdList = new ArrayList<>();
        for (SystemRole systemRole : systemRoleList) {
            if (StringUtils.isBlank(systemRole.getRules())) {
                continue;
            }
            categoryIdList.addAll(CommaSplitUtils.toIntegerList(systemRole.getRules()));
        }

        return categoryIdList;
    }

    private List<SystemRole> getVoListInId(String roles) {
        List<Integer> roleIds = CommaSplitUtils.toIntegerList(roles);
        if (T.isEmpty(roleIds)) {
            return Collections.emptyList();
        }
        SystemRoleExample example = new SystemRoleExample();
        example.createCriteria().andIdIn(roleIds);
        return systemRoleDao.selectByExample(example);
    }

}

