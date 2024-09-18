package org.example.backend.common.service;

import com.fasterxml.jackson.core.type.TypeReference;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.primary.dao.ISystemMenusDao;
import org.example.backend.common.primary.entity.SystemMenus;
import org.example.backend.common.primary.entity.SystemMenusExample;
import org.example.backend.common.cache.CommonCacheService;
import org.example.backend.common.utils.T;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

import static org.example.backend.common.cache.CommonCacheService.CACHE_LIST_KEY;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 12:58
 */
@Slf4j
@Service
public class SystemMenuService {

    @Resource
    ISystemMenusDao iSystemMenusDao;
    @Resource
    CommonCacheService commonCacheService;

    public List<SystemMenus> getCacheList() {
        List<SystemMenus> val = commonCacheService.getCacheByKey(CACHE_LIST_KEY, new TypeReference<List<SystemMenus>>() {
        });
        if (T.nonNull(val)) {
            return val;
        }
        SystemMenusExample example = new SystemMenusExample();
        example.createCriteria().andIsDelEqualTo(0)
                .andIsShowEqualTo(1).andAuthTypeNotEqualTo(2);
        List<SystemMenus> menus = iSystemMenusDao.selectByExample(example);
        commonCacheService.putCache(CACHE_LIST_KEY, menus);
        return menus;
    }

    public List<SystemMenus> getAllPermissions() {
        SystemMenusExample example = new SystemMenusExample();
        example.createCriteria().andIsDelEqualTo(0).andAuthTypeNotEqualTo(2);
        return iSystemMenusDao.selectByExample(example);
    }

    public List<SystemMenus> findPermissionByUserId(Integer userId) {
        return iSystemMenusDao.findPermissionByUserId(userId);
    }

    /**
     * 获取所有菜单
     */
    public List<SystemMenus> findAllCatalogue() {
        SystemMenusExample example = new SystemMenusExample();
        example.createCriteria().andIsDelEqualTo(0)
                .andIsShowEqualTo(1).andAuthTypeNotEqualTo(2);
        return iSystemMenusDao.selectByExample(example);
    }

    /**
     * 获取用户路由
     */

    public List<SystemMenus> getMenusByUserId(Integer userId) {
        return iSystemMenusDao.getMenusByUserId(userId);
    }
}
