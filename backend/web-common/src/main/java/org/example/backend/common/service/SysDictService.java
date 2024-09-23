package org.example.backend.common.service;

import org.example.backend.common.model.Page;
import org.example.backend.common.model.dto.SysDictDto;
import org.example.backend.common.model.param.SysDictParam;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/27 17:09
 */
public interface SysDictService {

    List<SysDictDto> findByCode(String code);

    Page<SysDictDto> pageList(SysDictParam param);

    void addOrEdit(SysDictParam param);

    void deleteById(Integer id);

}
