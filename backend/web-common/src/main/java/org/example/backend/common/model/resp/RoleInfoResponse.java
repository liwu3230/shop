package org.example.backend.common.model.resp;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.example.backend.common.model.vo.MenuCheckVo;

import java.util.Date;
import java.util.List;

/**
 * 角色详情响应对象
 */
@Data
public class RoleInfoResponse {

    @ApiModelProperty(value = "角色id")
    private Integer id;

    @ApiModelProperty(value = "角色名称")
    private String roleName;

    @ApiModelProperty(value = "状态：0-关闭，1-正常")
    private Boolean status;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "修改时间")
    private Date updateTime;

    @ApiModelProperty(value = "修改时间")
    private List<MenuCheckVo> menuList;

}
