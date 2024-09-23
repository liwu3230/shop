package org.example.backend.common.model.dto;

import lombok.Data;
import org.example.backend.common.primary.entity.SysUser;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/2 19:53
 */
@Data
public class SysUserDto extends SysUser {

    private String deptName;
    private String deptFullName;
}
