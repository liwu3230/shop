package org.example.backend.common.service.impl;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.compress.utils.Lists;
import org.apache.commons.lang3.StringUtils;
import org.example.backend.common.config.DbConstant;
import org.example.backend.common.model.dto.BreadcrumbDto;
import org.example.backend.common.model.dto.SysMenuDto;
import org.example.backend.common.model.enums.MenuType;
import org.example.backend.common.model.enums.RoleType;
import org.example.backend.common.model.param.SysMenuParam;
import org.example.backend.common.primary.base.dao.SysRoleMenuDao;
import org.example.backend.common.primary.dao.ISysMenuDao;
import org.example.backend.common.primary.entity.SysMenu;
import org.example.backend.common.primary.entity.SysMenuExample;
import org.example.backend.common.primary.entity.SysRoleMenuExample;
import org.example.backend.common.primary.entity.SysRoleMenuKey;
import org.example.backend.common.security.utils.AuthenticationUtil;
import org.example.backend.common.service.SysMenuService;
import org.example.backend.common.util.Delimiters;
import org.example.backend.common.util.T;
import org.example.backend.common.util.TreeBuildFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import jakarta.annotation.Resource;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:06
 */
@Slf4j
@Service
public class SysMenuServiceImpl implements SysMenuService {

    @Resource
    private ISysMenuDao iSysMenuDao;
    @Resource
    private SysRoleMenuDao sysRoleMenuDao;

    @Override
    public List<SysMenuDto> listTree(SysMenuParam param) {
        SysMenuExample example = new SysMenuExample();
        SysMenuExample.Criteria criteria = example.createCriteria();
        if (T.isNotBlank(param.getName())) {
            criteria.andNameLike("%" + param.getName() + "%");
        }
        if (T.nonNull(param.getTypeIsNot())) {
            criteria.andTypeNotEqualTo(param.getTypeIsNot());
        }
        if (T.nonNull(param.getType())) {
            criteria.andTypeEqualTo(param.getType());
        }
        example.setOrderByClause(" sort asc");
        List<SysMenuDto> sysMenuList = iSysMenuDao.selectByExample(example)
                .stream().map(entity -> {
                    SysMenuDto dto = new SysMenuDto();
                    BeanUtils.copyProperties(entity, dto);
                    return dto;
                }).collect(Collectors.toList());
        return TreeBuildFactory.transToTree(sysMenuList, Comparator.nullsLast(Comparator.comparing(SysMenuDto::getSort, Comparator.nullsLast(Integer::compareTo))));
    }

    @Override
    public List<SysMenu> findAll() {
        return iSysMenuDao.selectByExample(null);
    }

    @Override
    public List<SysRoleMenuKey> findRoleMenuList() {
        return sysRoleMenuDao.selectByExample(null);
    }

    @Override
    public List<String> findButtonPermsByUser(Integer userId) {
        List<SysMenu> menuList;
        if (AuthenticationUtil.isSuperAdmin()) {
            SysMenuExample example = new SysMenuExample();
            example.createCriteria().andTypeEqualTo(MenuType.BUTTON.getValue());
            menuList = iSysMenuDao.selectByExample(example);
        } else {
            menuList = iSysMenuDao.findMenuListByUserId(Collections.singletonList(MenuType.BUTTON.getValue()), userId);
        }
        List<String> perms = Lists.newArrayList();

        menuList.forEach(e -> {
            if (T.isNotEmpty(e.getPerms())) {
                perms.add(e.getPerms());
            }
        });
        return perms.stream().distinct().collect(Collectors.toList());
    }

    @Override
    public List<SysMenu> findByTypeIsNot(Integer type) {
        SysMenuExample example = new SysMenuExample();
        example.createCriteria().andTypeNotEqualTo(type);
        return iSysMenuDao.selectByExample(example);
    }

    @Override
    public List<SysMenuDto> findMenuByUser(Integer userId) {
        if (AuthenticationUtil.isSuperAdmin()) {
            //超级管理员返回全部菜单
            SysMenuParam query = new SysMenuParam();
            query.setTypeIsNot(MenuType.BUTTON.getValue());
            return listTree(query);
        }
        List<SysMenu> menuList = iSysMenuDao.findMenuListByUserId(
                Arrays.asList(MenuType.CATALOG.getValue(), MenuType.MENU.getValue()), userId);
        if (CollectionUtils.isEmpty(menuList)) {
            return Collections.emptyList();
        }

        List<SysMenu> result = Lists.newArrayList();
        Map<Integer, SysMenu> parentIdSet = Maps.newHashMap();
        Map<Integer, SysMenu> menuMap = Optional.ofNullable(this.findByTypeIsNot(MenuType.BUTTON.getValue())).orElseGet(ArrayList::new).stream()
                .filter(Objects::nonNull).collect(Collectors.toMap(SysMenu::getId, Function.identity(), (key1, key2) -> key2));
        for (SysMenu sysMenu : menuList) {
            result.add(sysMenu);
            while (sysMenu.getParentId() != null && sysMenu.getParentId() > 0) {
                SysMenu sysMenuEntity = menuMap.get(sysMenu.getParentId());
                if (sysMenuEntity == null) {
                    break;
                }
                parentIdSet.put(sysMenuEntity.getId(), sysMenuEntity);
                sysMenu = sysMenuEntity;
            }
        }
        result.addAll(parentIdSet.values());

        List<SysMenuDto> converterList = result.stream().map(entity -> {
            SysMenuDto dto = new SysMenuDto();
            BeanUtils.copyProperties(entity, dto);
            return dto;
        }).collect(Collectors.toList());

        return TreeBuildFactory.transToTree(converterList, Comparator.nullsLast(Comparator.comparing(SysMenuDto::getSort, Comparator.nullsLast(Integer::compareTo))));

    }

    @Override
    public Map<String, List<BreadcrumbDto>> findBreadcrumbByUser(Integer userId) {
        Map<String, List<BreadcrumbDto>> resMap = new LinkedHashMap<>();

        List<SysMenu> menuList = this.findAll();
        Map<String, SysMenu> menuMap = Optional.ofNullable(menuList).orElseGet(ArrayList::new).stream()
                .filter(Objects::nonNull).collect(Collectors.toMap(e -> String.valueOf(e.getId()), Function.identity(), (key1, key2) -> key2));

        Optional.ofNullable(menuList).orElseGet(ArrayList::new).stream().filter(Objects::nonNull)
                .filter(e -> T.isNotBlank(e.getRouter())
                        && T.EQ(e.getIsBreadCrumb(), 1)
                        && T.isNotBlank(e.getPath()))
                .forEach(e -> {
                    String[] level = e.getPath().split("\\" + Delimiters.DOT);
                    if (level.length <= 1) {
                        return;
                    }
                    List<BreadcrumbDto> items = Lists.newArrayList();
                    for (String s : level) {
                        SysMenu sysMenu = menuMap.get(s);
                        if (T.isNull(sysMenu)) {
                            continue;
                        }
                        BreadcrumbDto breadcrumb = new BreadcrumbDto();
                        breadcrumb.setName(sysMenu.getName());
                        breadcrumb.setRouter(sysMenu.getRouter());
                        items.add(breadcrumb);
                    }
                    if (T.isNotEmpty(items)) {
                        items.add(BreadcrumbDto.builder().name(e.getName()).build());
                        resMap.put(e.getRouter(), items);
                    }
                });
        return resMap;
    }

    @Transactional(transactionManager = DbConstant.primaryTransactionManager, rollbackFor = Exception.class)
    @Override
    public void addOrEdit(SysMenuParam param) {
        boolean isUpdate = param.getId() != null && param.getId() > 0;
        if (!Objects.equals(MenuType.BUTTON.getValue(), param.getType())) {
            //非按钮级别才需要校验名称的唯一性
            SysMenuExample checkExp = new SysMenuExample();
            SysMenuExample.Criteria criteria = checkExp.createCriteria();
            criteria.andNameEqualTo(param.getName());
            if (isUpdate) {
                criteria.andIdNotEqualTo(param.getId());
            }
            if (iSysMenuDao.countByExample(checkExp) > 0) {
                throw new IllegalArgumentException("该名称已存在！");
            }
        } else if (Objects.equals(MenuType.BUTTON.getValue(), param.getType()) &&
                T.isNotBlank(param.getPerms())) {
            //按钮且设置了按钮权限标识，需要校验唯一性
            SysMenuExample example = new SysMenuExample();
            SysMenuExample.Criteria criteria = example.createCriteria();
            criteria.andTypeEqualTo(MenuType.BUTTON.getValue()).andPermsEqualTo(param.getPerms());
            if (isUpdate) {
                criteria.andIdNotEqualTo(param.getId());
            }
            if (iSysMenuDao.countByExample(example) > 0) {
                throw new IllegalArgumentException("该按钮权限标识已存在！");
            }
        }

        if (T.isNotNull(param.getParentId()) && param.getParentId() > 0) {
            SysMenu parentMenu = iSysMenuDao.selectByPrimaryKey(param.getParentId());
            if (T.isNull(parentMenu)) {
                throw new IllegalArgumentException("父级不存在！");
            }
            if (Objects.equals(MenuType.BUTTON.getValue(), param.getType()) &&
                    !Objects.equals(MenuType.MENU.getValue(), parentMenu.getType())) {
                throw new IllegalArgumentException("按钮只能选择菜单作为父级！");
            }
            if (Objects.equals(MenuType.MENU.getValue(), param.getType()) &&
                    !Objects.equals(MenuType.CATALOG.getValue(), parentMenu.getType())) {
                throw new IllegalArgumentException("菜单只能选择目录作为父级！");
            }
            if (Objects.equals(MenuType.CATALOG.getValue(), param.getType()) &&
                    !Objects.equals(MenuType.CATALOG.getValue(), parentMenu.getType())) {
                throw new IllegalArgumentException("目录只能选择目录作为父级！");
            }
        }

        SysMenu newEntity = new SysMenu();
        BeanUtils.copyProperties(param, newEntity);
        newEntity.setPath(getPathByPid(newEntity.getParentId()));
        newEntity.setVisible(Objects.equals(param.getVisible(), true) ? 1 : 0);
        newEntity.setIsBreadCrumb(Objects.equals(param.getIsBreadCrumb(), true) ? 1 : 0);
        if (isUpdate) {
            SysMenu old = iSysMenuDao.selectByPrimaryKey(param.getId());
            if (T.isNull(old)) {
                throw new IllegalArgumentException("该记录不存在！");
            }
            newEntity.setIsInit(old.getIsInit());
            newEntity.setUpdater(AuthenticationUtil.getUserName());
            newEntity.setUpdateTime(new Date());
            newEntity.setCreator(old.getCreator());
            newEntity.setCreateTime(old.getCreateTime());
            iSysMenuDao.updateByPrimaryKey(newEntity);

            if (!Objects.equals(old.getParentId(), newEntity.getParentId())) {
                //更新其他以当前菜单为父菜单的path
                SysMenuExample example = new SysMenuExample();
                example.createCriteria().andIdNotEqualTo(newEntity.getId()).andPathLike(old.getPath() + Delimiters.DOT + old.getId() + "%");
                List<SysMenu> sysMenus = iSysMenuDao.selectByExample(example).stream()
                        .sorted(Comparator.comparing(e -> {
                            if (T.isBlank(e.getPath())) {
                                return 0;
                            }
                            String[] level = e.getPath().split("\\" + Delimiters.DOT);
                            return level.length;
                        })).collect(Collectors.toList());
                for (SysMenu sysMenu : sysMenus) {
                    updatePathById(sysMenu.getId());
                }
            }
        } else {
            newEntity.setIsInit(0);
            newEntity.setCreator(AuthenticationUtil.getUserName());
            newEntity.setCreateTime(new Date());
            int id = iSysMenuDao.insert(newEntity);
            newEntity.setId(id);
        }
    }

    @Override
    public void deleteById(Integer id) {
        SysMenu sysMenu = iSysMenuDao.selectByPrimaryKey(id);
        if (T.isNull(sysMenu)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        //判断是否存在子节点,存在不允许删除
        boolean containMenu = false;
        List<SysMenu> childList = iSysMenuDao.selectByExample(null).stream().filter(Objects::nonNull)
                .filter(sysMenuDto -> Objects.equals(sysMenuDto.getParentId(), id)).collect(Collectors.toList());
        if (!CollectionUtils.isEmpty(childList)) {
            containMenu = true;
        }
        Preconditions.checkState(!containMenu, "该目录下存在子目录,不能删除,请先删除子目录!");

        iSysMenuDao.deleteByPrimaryKey(id);
        //根据菜单id删除角色菜单关联表
        SysRoleMenuExample exp = new SysRoleMenuExample();
        exp.createCriteria().andMenuIdEqualTo(id);
        sysRoleMenuDao.deleteByExample(exp);
    }

    private void updatePathById(Integer id) {
        SysMenu sysMenu = iSysMenuDao.selectByPrimaryKey(id);
        if (T.isNull(sysMenu)) {
            throw new IllegalArgumentException("该记录不存在！");
        }
        sysMenu.setPath(getPathByPid(sysMenu.getParentId()));
        iSysMenuDao.updateByPrimaryKey(sysMenu);
    }

    private String getPathByPid(Integer parentId) {
        String path = "0";
        if (Objects.nonNull(parentId) && parentId > 0) {
            SysMenu parent = iSysMenuDao.selectByPrimaryKey(parentId);
            if (T.isNull(parent)) {
                throw new IllegalArgumentException("找不到父菜单！");
            }
            String parentPath = parent.getPath();
            StringJoiner joiner = new StringJoiner(Delimiters.DOT);
            if (StringUtils.isNotBlank(parentPath)) {
                joiner.add(parentPath);
                String[] level = parentPath.split("\\" + Delimiters.DOT);
                Preconditions.checkState(level.length < 4, "最多只允许创建4层！");
            }
            joiner.add(String.valueOf(parent.getId()));
            path = joiner.toString();
        }
        return path;
    }

}
