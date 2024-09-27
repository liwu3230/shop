package org.example.backend.common.model.dto;

import lombok.Data;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/26 18:13
 */
@Data
public class SysNoticeDto {

    private Integer type;
    private String icon;
    private String title;
    private String desc;
    private String url;


}
