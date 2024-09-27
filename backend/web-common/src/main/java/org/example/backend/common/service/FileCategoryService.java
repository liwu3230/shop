package org.example.backend.common.service;

import org.example.backend.common.model.dto.SysAttCategoryTreeDto;
import org.example.backend.common.model.param.SysAttachmentCategoryParam;

import java.util.List;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 15:29
 */
public interface FileCategoryService {

    List<SysAttCategoryTreeDto> listTree();

    void saveOrUpdate(SysAttachmentCategoryParam req);

    void deleteById(Integer id);

}
