package org.example.backend.common.model.dto;

import lombok.Data;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/3 19:57
 */
@Data
public class SysSimpleUserDto {

    private Integer userId;
    private String userName;
    private String nickName;
    private String labelName;

}
