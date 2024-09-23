package org.example.backend.common.service.impl;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.config.DbConstant;
import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysDeptDto;
import org.example.backend.common.model.dto.SysUserDto;
import org.example.backend.common.model.enums.CommonStatus;
import org.example.backend.common.model.enums.MenuType;
import org.example.backend.common.model.param.SysUserParam;
import org.example.backend.common.primary.base.dao.SysDeptDao;
import org.example.backend.common.primary.base.dao.SysRoleDao;
import org.example.backend.common.primary.base.dao.SysUserDao;
import org.example.backend.common.primary.base.dao.SysUserRoleDao;
import org.example.backend.common.primary.dao.ISysMenuDao;
import org.example.backend.common.primary.entity.*;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysDeptService;
import org.example.backend.common.service.SysMenuService;
import org.example.backend.common.service.SysUserService;
import org.example.backend.common.util.*;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/26 18:25
 */
@Slf4j
@Service
public class SysUserServiceImpl implements SysUserService {

    @Resource
    private SysUserDao sysUserDao;
    @Resource
    private SysUserRoleDao sysUserRoleDao;
    @Resource
    private SysDeptDao sysDeptDao;
    @Resource
    private SysDeptService sysDeptService;
    @Resource
    private SysRoleDao sysRoleDao;
    @Resource
    private SysMenuService sysMenuService;
    @Resource
    private ISysMenuDao iSysMenuDao;

    @Override
    public Page<SysUserDto> pageList(SysUserParam param) {
        SysUserExample example = getExample(param);
        long count = sysUserDao.countByExample(example);
        example.setLimit(param.getLimit());
        example.setOffset(param.getOffset());
        example.setOrderByClause(" create_time desc");
        List<SysUser> list = sysUserDao.selectByExample(example);

        Map<Integer, SysDeptDto> deptMap = sysDeptService.findAll().stream()
                .collect(Collectors.toMap(SysDeptDto::getId, Function.identity(), (key1, key2) -> key2));
        List<SysUserDto> results = list.stream().map(e -> {
            SysUserDto dto = new SysUserDto();
            BeanUtils.copyProperties(e, dto);
            if (T.GT(dto.getDeptId(), 0)) {
                SysDeptDto deptDto = deptMap.get(e.getDeptId());
                if (T.nonNull(deptDto)) {
                    dto.setDeptName(deptDto.getName());
                    dto.setDeptFullName(deptDto.getFullName());
                }
            }
            return dto;
        }).collect(Collectors.toList());

        return new Page<>(results, param.getPage(), param.getLimit(), count);
    }

    private SysUserExample getExample(SysUserParam param) {
        SysUserExample example = new SysUserExample();
        SysUserExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(param.getUserName())) {
            criteria.andUserNameLike("%" + param.getUserName() + "%");
        }
        if (T.isNotBlank(param.getNickName())) {
            criteria.andNickNameLike("%" + param.getNickName() + "%");
        }
        if (T.nonNull(param.getStatus())) {
            criteria.andStatusEqualTo(param.getStatus());
        }
        if (T.GT(param.getDeptId(), 0)) {
            SysDept dept = sysDeptDao.selectByPrimaryKey(param.getDeptId());
            if (dept != null) {
                SysDeptExample deptExp = new SysDeptExample();
                deptExp.createCriteria().andPathLike(dept.getPath() + Delimiters.DOT + dept.getId() + "%");
                Set<Integer> deptIds = sysDeptDao.selectByExample(deptExp).stream().map(SysDept::getId).collect(Collectors.toSet());
                deptIds.add(dept.getId());
                criteria.andDeptIdIn(new ArrayList<>(deptIds));
            }
        }
        return example;
    }

    @Override
    public SysUser findByUserName(String userName) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        return T.findFirst(sysUserDao.selectByExample(example));
    }

    @Override
    public List<String> queryPermsByUserName(String userName) {
        List<String> perms = Lists.newArrayList();
        SysUserExample exp = new SysUserExample();
        exp.createCriteria().andUserNameEqualTo(userName);
        SysUser sysUser = T.findFirst(sysUserDao.selectByExample(exp));
        if (T.isNull(sysUser)) {
            return perms;
        }

        List<SysMenu> menuList;
        if (Objects.equals(sysUser.getIsAdmin(), 1)) {
            menuList = iSysMenuDao.selectByExample(null);
        } else {
            menuList = iSysMenuDao.findMenuByUserId(sysUser.getId());
        }

        menuList.forEach(e -> {
            if (T.isNotEmpty(e.getPerms())) {
                perms.add(e.getPerms());
            }
        });
        return perms.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<Integer> findNormalRoleIdsByUserId(Integer userId) {
        SysUserRoleExample example = new SysUserRoleExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<Integer> ids = sysUserRoleDao.selectByExample(example).stream().map(SysUserRoleKey::getRoleId).collect(Collectors.toList());

        SysRoleExample exp = new SysRoleExample();
        exp.createCriteria().andStatusNotEqualTo(CommonStatus.ENABLE.getValue());
        List<Integer> unNormalIds = sysRoleDao.selectByExample(exp).stream().map(SysRole::getId).toList();
        ids.removeAll(unNormalIds);
        return ids;
    }

    @Override
    public Map<String, Set<Integer>> loadUrlPermissions() {
        Map<String, Set<Integer>> urlRolesMap = Maps.newHashMap();
        List<SysMenu> menuList = sysMenuService.findAll();
        if (T.isNotEmpty(menuList)) {
            menuList.forEach(m -> {
                if (StringUtils.isNotBlank(m.getPermissionPath())) {
                    urlRolesMap.put(m.getPermissionPath(), Sets.newHashSet());
                }
            });
        }
        Map<Integer, SysMenu> sysMenuMap = menuList.stream().collect(Collectors.toMap(SysMenu::getId, Function.identity(), (key1, key2) -> key2));
        //模型页面拥有权限的roleIds
        List<SysRoleMenuKey> roleMenuList = sysMenuService.findRoleMenuList();
        roleMenuList.forEach(e -> {
            SysMenu sysMenu = sysMenuMap.get(e.getMenuId());
            if (sysMenu == null) {
                return;
            }
            String url = sysMenu.getPermissionPath();
            if (StringUtils.isNotBlank(url)) {
                //支持逗号分割
                Set<String> urls = CommaSplitUtils.toSet(url);
                urls.stream().filter(T::isNotBlank).forEach(u -> urlRolesMap.computeIfAbsent(u.trim(), key -> Sets.newHashSet()).add(e.getRoleId()));
            }
        });
        return urlRolesMap;
    }

    @Override
    public SysUser findById(Integer userId) {
        return sysUserDao.selectByPrimaryKey(userId);
    }

    @Override
    public List<SysUser> findAllList() {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andStatusNotEqualTo(CommonStatus.DELETED.getValue());
        return sysUserDao.selectByExample(example);
    }

    @Override
    public List<SysUser> findByIds(List<Integer> userIds) {
        SysUserExample example = new SysUserExample();
        example.createCriteria().andIdIn(userIds);
        return sysUserDao.selectByExample(example);
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void addOrEdit(SysUserParam param) {
        boolean isUpdate = param.getId() != null && param.getId() > 0;
        SysUserExample checkExp = new SysUserExample();
        SysUserExample.Criteria criteria = checkExp.createCriteria();
        criteria.andUserNameEqualTo(param.getUserName());
        if (isUpdate) {
            criteria.andIdNotEqualTo(param.getId());
        }
        if (sysUserDao.countByExample(checkExp) > 0) {
            throw new IllegalArgumentException("该账号已存在！");
        }

        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(param, sysUser);
        if (T.isNotBlank(param.getExpireTime())) {
            sysUser.setExpireTime(DateUtil.parse(param.getExpireTime()));
        }
        if (T.isNull(sysUser.getGender())) {
            sysUser.setGender(0);
        }
        sysUser.setIsAdmin(0);
        if (isUpdate) {
            SysUser old = sysUserDao.selectByPrimaryKey(param.getId());
            if (T.isNull(old)) {
                throw new IllegalArgumentException("该记录不存在！");
            }
            sysUser.setIsAdmin(old.getIsAdmin());
            sysUser.setUserName(old.getUserName());
            sysUser.setPassword(old.getPassword());
            sysUser.setCreateTime(old.getCreateTime());
            sysUser.setCreator(old.getCreator());
            sysUser.setUpdater(AuthenticationUtil.getUserName());
            sysUser.setUpdateTime(new Date());
            sysUserDao.updateByPrimaryKey(sysUser);
        } else {
            sysUser.setPassword(AESUtil.encrypt("123456"));
            sysUser.setCreator(AuthenticationUtil.getUserName());
            sysUser.setCreateTime(new Date());
            int id = sysUserDao.insert(sysUser);
            sysUser.setId(id);
        }
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void deleteById(Integer id) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(id);
        if (T.isNull(sysUser)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        sysUser.setStatus(CommonStatus.DELETED.getValue());
        sysUser.setUpdater(AuthenticationUtil.getUserName());
        sysUser.setUpdateTime(new Date());
        sysUserDao.updateByPrimaryKey(sysUser);
    }

    @Override
    public String resetPassword(Integer id) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(id);
        if (T.isNull(sysUser)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        String randomPassword = RandomStringUtils.random(8, true, true);
        sysUser.setUpdater(AuthenticationUtil.getUserName());
        sysUser.setUpdateTime(new Date());
        sysUser.setPassword(AESUtil.encrypt(randomPassword));
        sysUserDao.updateByPrimaryKey(sysUser);
        return randomPassword;
    }

    @Override
    public void updatePassword(Integer id, String password) {
        SysUser sysUser = sysUserDao.selectByPrimaryKey(id);
        if (T.isNull(sysUser)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        sysUser.setUpdater(AuthenticationUtil.getUserName());
        sysUser.setUpdateTime(new Date());
        sysUser.setPassword(AESUtil.encrypt(password));
        sysUserDao.updateByPrimaryKey(sysUser);
    }

}
