package org.example.backend.common.service;

import org.example.backend.common.model.dto.SysDeptDto;
import org.example.backend.common.model.param.SysDeptParam;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/2 12:31
 */
public interface SysDeptService {

    List<SysDeptDto> listTree(SysDeptParam param);

    List<SysDeptDto> findAll();

    void addOrEdit(SysDeptParam param);

    void deleteById(Integer id);
}
