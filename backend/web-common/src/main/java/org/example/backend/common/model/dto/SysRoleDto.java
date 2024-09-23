package org.example.backend.common.model.dto;

import lombok.Data;
import org.example.backend.common.primary.entity.SysRole;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/10/1 19:42
 */
@Data
public class SysRoleDto extends SysRole {

    private Integer roleId;

}
