package org.example.backend.common.service.impl;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.model.dto.SysCityTreeDto;
import org.example.backend.common.primary.base.dao.SysCityDao;
import org.example.backend.common.primary.entity.SysCity;
import org.example.backend.common.primary.entity.SysCityExample;
import org.example.backend.common.service.SysCityService;
import org.example.backend.common.util.T;
import org.example.backend.common.util.TreeBuildFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/9 23:09
 */
@Slf4j
@Service
public class SysCityServiceImpl implements SysCityService, InitializingBean {

    @Resource
    SysCityDao sysCityDao;

    private static final String CITY = "city";
    private static final Cache<String, List<SysCityTreeDto>> CITY_CACHE = CacheBuilder.newBuilder()
            .expireAfterWrite(12, TimeUnit.HOURS).build();

    @Override
    public void afterPropertiesSet() throws Exception {
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryBuilder().setDaemon(true).setNameFormat("refreshUserCacheScheduledThread_-%d").build());
        executor.scheduleWithFixedDelay(() -> {
            listTree(false);
        }, 5, 5 * 60 * 60, TimeUnit.SECONDS);
    }

    @Override
    public List<SysCityTreeDto> listTree(boolean useCache) {
        if (useCache) {
            List<SysCityTreeDto> cacheLists = CITY_CACHE.getIfPresent(CITY);
            if (T.isNotEmpty(cacheLists)) {
                return cacheLists;
            }
        }
        SysCityExample example = new SysCityExample();
        SysCityExample.Criteria criteria = example.createCriteria();
        criteria.andIsShowEqualTo(1);
        List<SysCityTreeDto> sysMenuList = sysCityDao.selectByExample(example).stream().map(e -> {
            SysCityTreeDto dto = new SysCityTreeDto();
            BeanUtils.copyProperties(e, dto);
            return dto;
        }).collect(Collectors.toList());
        if (T.isEmpty(sysMenuList)) {
            return Collections.emptyList();
        }
        List<SysCityTreeDto> list = TreeBuildFactory.transToTree(sysMenuList,
                Comparator.nullsLast(Comparator.comparing(SysCityTreeDto::getCityId, Comparator.nullsLast(Integer::compareTo))));
        CITY_CACHE.put(CITY, list);
        return list;
    }

    @Override
    public SysCity queryByPidAndName(Integer cityId, String name) {
        SysCityExample example = new SysCityExample();
        SysCityExample.Criteria criteria = example.createCriteria();
        criteria.andParentIdEqualTo(cityId).andNameEqualTo(name);
        return T.findFirst(sysCityDao.selectByExample(example));
    }

    @Override
    public SysCity queryByCityId(Integer cityId) {
        SysCityExample example = new SysCityExample();
        SysCityExample.Criteria criteria = example.createCriteria();
        criteria.andCityIdEqualTo(cityId);
        return T.findFirst(sysCityDao.selectByExample(example));
    }

    @Override
    public SysCity queryByMergerName(String mergerName) {
        SysCityExample example = new SysCityExample();
        SysCityExample.Criteria criteria = example.createCriteria();
        criteria.andMergerNameEqualTo(mergerName);
        return T.findFirst(sysCityDao.selectByExample(example));
    }
}
