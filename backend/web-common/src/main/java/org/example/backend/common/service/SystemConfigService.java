package org.example.backend.common.service;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;
import org.example.backend.common.primary.base.dao.SystemConfigDao;
import org.example.backend.common.primary.entity.SystemConfig;
import org.example.backend.common.primary.entity.SystemConfigExample;
import org.example.backend.common.utils.T;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/17 12:58
 */
@Slf4j
@Service
public class SystemConfigService {

    @Resource
    SystemConfigDao systemConfigDao;

    public String getValueByKey(String name) {
        return get(name);
    }

    public String getValueByKeyException(String name) {
        String value = get(name);
        if (null == value) {
            throw new RuntimeException("没有找到"+ name +"数据");
        }
        return value;
    }

    private String get(String name) {
        SystemConfigExample example = new SystemConfigExample();
        example.createCriteria().andStatusNotEqualTo(1)
                .andMenuNameEqualTo(name);
        SystemConfig systemConfig = T.findFirst(systemConfigDao.selectByExample(example));

        if (ObjectUtil.isNull(systemConfig) || StrUtil.isBlank(systemConfig.getValue())) {
            return "";
        }
        return systemConfig.getValue();
    }
}
