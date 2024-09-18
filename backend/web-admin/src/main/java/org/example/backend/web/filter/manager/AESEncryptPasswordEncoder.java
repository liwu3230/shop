package org.example.backend.web.filter.manager;

import org.example.backend.common.utils.AESUtil;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/9/18 16:34
 */
public class AESEncryptPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        } else {
            return AESUtil.encrypt(rawPassword.toString());
        }
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        if (rawPassword == null) {
            throw new IllegalArgumentException("rawPassword cannot be null");
        } else if (encodedPassword != null && encodedPassword.length() != 0) {
            return Objects.equals(AESUtil.encrypt(rawPassword.toString()), encodedPassword);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        System.out.println(AESUtil.encrypt("123456"));
    }

}