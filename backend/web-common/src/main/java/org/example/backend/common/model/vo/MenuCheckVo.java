package org.example.backend.common.model.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 菜单待选中Vo对象
 */
@Data
public class MenuCheckVo {

    @ApiModelProperty(name = "菜单ID")
    private Integer id;

    @ApiModelProperty(value = "父级ID")
    private Integer pid;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "icon")
    private String icon;

    @ApiModelProperty(value = "是否选中")
    private Boolean checked;

    @ApiModelProperty(value = "排序")
    private Integer sort;

    @ApiModelProperty(value = "子对象列表")
    private List<MenuCheckVo> childList;
}
