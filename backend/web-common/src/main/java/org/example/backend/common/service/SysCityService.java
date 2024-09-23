package org.example.backend.common.service;

import org.example.backend.common.model.dto.SysCityTreeDto;
import org.example.backend.common.primary.entity.SysCity;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/9 23:09
 */
public interface SysCityService {

    List<SysCityTreeDto> listTree(boolean useCache);

    SysCity queryByPidAndName(Integer cityId, String name);
    SysCity queryByCityId(Integer cityId);
    SysCity queryByMergerName(String mergerName);

}
