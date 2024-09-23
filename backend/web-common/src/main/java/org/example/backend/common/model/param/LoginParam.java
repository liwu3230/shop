package org.example.backend.common.model.param;

import lombok.Data;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/9/28 19:49
 */
@Data
public class LoginParam {

    public String userName;
    public String password;
    public String oldPassword;
    public Boolean remember;
}
