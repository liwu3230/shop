package org.example.backend.common.model.param;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.example.backend.common.model.BaseParam;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/23 15:32
 */
@Data
public class SysAttachmentCategoryParam {

    private Integer id;

    @NotNull(message = "pid不能为空", groups = {BaseParam.edit.class})
    private Integer pid;

    @NotBlank(message = "名称不能为空", groups = {BaseParam.add.class, BaseParam.edit.class})
    private String name;

    private String enname;
}
