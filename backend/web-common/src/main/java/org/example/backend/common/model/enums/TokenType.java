package org.example.backend.common.model.enums;

import lombok.Getter;

import java.util.Objects;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/15 10:58
 */
@Getter
public enum TokenType {


    WEB(0, "web"),
    APP(1, "app"),
    ;

    private final int value;
    private final String label;

    TokenType(int value, String label) {
        this.value = value;
        this.label = label;
    }

    public static TokenType getValue(int value) {
        for (TokenType type : TokenType.values()) {
            if (type.value == value) {
                return type;
            }
        }
        return null;
    }

    public static TokenType getLabel(String label) {
        for (TokenType type : TokenType.values()) {
            if (Objects.equals(type.label, label)) {
                return type;
            }
        }
        return null;
    }

}
