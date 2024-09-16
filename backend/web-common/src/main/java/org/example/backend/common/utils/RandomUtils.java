package org.example.backend.common.utils;

import java.util.Random;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/6/15 16:06
 */
public class RandomUtils {

    private final static char[] codes = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x',
            'y', 'z'};

    private RandomUtils() {
    }

    public static String randomStr(int len) {
        StringBuilder result = new StringBuilder(len);
        Random random = new Random();
        for (int i = 0; i < len; i++) {
            result.append(codes[random.nextInt(codes.length)]);
        }
        return result.toString();
    }
}
