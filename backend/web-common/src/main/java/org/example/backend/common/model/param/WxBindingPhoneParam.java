package org.example.backend.common.model.param;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/14 12:58
 */
@Data
public class WxBindingPhoneParam {

    @ApiModelProperty(value = "手机号", required = true)
    @Pattern(regexp = "^1\\d{10}$", message = "请输入正确的手机号")
    private String phone;

    @ApiModelProperty(value = "验证码", required = true)
    @Pattern(regexp = "^\\d{6}$", message = "请输入6位验证码")
    private String captcha;

    @ApiModelProperty(value = "类型:public-公众号，routine-小程序,iosWx-苹果微信，androidWx-安卓微信, ios-ios登录")
    @NotBlank(message = "类型不能为空")
    private String type;

    @ApiModelProperty(value = "新用户登录时返回的key")
    @NotBlank(message = "key不能为空")
    private String key;

    @ApiModelProperty(value = "小程序获取手机号加密数据")
    private String encryptedData;

    @ApiModelProperty(value = "加密算法的初始向量")
    private String iv;

    @ApiModelProperty(value = "小程序code")
    private String code;

}
