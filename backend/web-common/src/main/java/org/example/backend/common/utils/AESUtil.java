package org.example.backend.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/4/24 18:36
 */
public class AESUtil {

    /**
     * 此处使用AES-128-ECB加密模式，key需要为16位。
     */
    private static final String sKey = "_@#$!%_encrypt0e";

    /**
     * 加密
     */
    public static String encrypt(String sSrc) {
        if (T.isBlank(sKey) || sKey.length() != 16) {
            return null;
        }
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            //算法/模式/补码方式
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));
            return new BASE64Encoder().encode(encrypted);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     */
    public static String decrypt(String sSrc) {
        if (T.isBlank(sKey) || sKey.length() != 16) {
            return null;
        }
        try {
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = new BASE64Decoder().decodeBuffer(sSrc);
            byte[] original = cipher.doFinal(encrypted1);
            String originalString = new String(original, "utf-8");
            return originalString;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) throws Exception {
        System.out.println("加密后的字串是：" + encrypt("123456"));
        System.out.println("解密后的字串是：" + decrypt("zlvo9oJQ49Ro/MEZnTVBhQ=="));
    }

}
