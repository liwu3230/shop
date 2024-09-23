package org.example.backend.common.model.dto;

import com.alibaba.fastjson2.JSON;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.example.backend.common.primary.entity.SysDict;
import org.example.backend.common.util.T;
import org.springframework.beans.BeanUtils;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/29 10:39
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysDictDto extends SysDict {

    private List<SysDictValue> dataList;

    public static SysDictDto entity2Dto(SysDict dict) {
        SysDictDto dto = new SysDictDto();
        BeanUtils.copyProperties(dict, dto);
        if (T.isNotBlank(dict.getData())) {
            List<SysDictValue> dictData = JSON.parseArray(dict.getData(), SysDictValue.class);
            if (T.isNotEmpty(dictData)) {
                dictData = dictData.stream().sorted(Comparator.comparing(SysDictValue::getSort)).collect(Collectors.toList());
            }
            dto.setDataList(dictData);
        }
        return dto;
    }
}
