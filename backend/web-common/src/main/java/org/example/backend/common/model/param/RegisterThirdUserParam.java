package org.example.backend.common.model.param;

import lombok.Data;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/14 11:14
 */
@Data
public class RegisterThirdUserParam {

    private String nickName;

    private String sex;

    private String province;

    private String city;

    private String country;

    private String avatar;

    //微信公众号用户头像
    private String headimgurl;

    private Integer spreadPid;

    private String type;

    private String openId;
    private String unionId;
    private String phone;


}
