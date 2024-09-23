package org.example.backend.common.util;

import lombok.Getter;

/**
 * @Description: 认证相关的异常
 * @Author: liwu3
 * @Date: 2021/7/21 10:48
 */
@Getter
public class AuthException extends RuntimeException {

    private final String errorMessage;

    public AuthException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

}
