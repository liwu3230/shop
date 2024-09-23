package org.example.backend.common.model.dto;

import lombok.*;
import lombok.experimental.FieldNameConstants;

import java.io.Serializable;

/**
 * @Description: 字典值
 * @Author: liwu3
 * @Date: 2021/7/15 17:36
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@FieldNameConstants
@EqualsAndHashCode
public class SysDictValue implements Serializable {

    /**
     * 显示名称
     */
    private String name;

    /**
     * 值
     */
    private String value;

    /**
     * 排序
     */
    private Integer sort;

}
