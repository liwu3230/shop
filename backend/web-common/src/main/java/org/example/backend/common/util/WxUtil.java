package org.example.backend.common.util;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.JSONObject;
import org.apache.commons.codec.binary.Base64;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/14 13:06
 */
public class WxUtil {

    private static final String WATERMARK = "watermark";
    private static final String APPID = "appid";

    /**
     * 解密数据
     *
     * @return
     * @throws Exception
     */
    public static String decrypt(String appId, String encryptedData, String sessionKey, String iv) {
        String result = "";
        try {
            WxAESUtil aes = new WxAESUtil();
            byte[] resultByte = aes.decrypt(Base64.decodeBase64(encryptedData), Base64.decodeBase64(sessionKey), Base64.decodeBase64(iv));
            if (null != resultByte && resultByte.length > 0) {
                result = new String(WxPKCS7Encoder.decode(resultByte));
                JSONObject jsonObject = JSONObject.parseObject(result);
                String decryptAppid = jsonObject.getJSONObject(WATERMARK).getString(APPID);
                if (!appId.equals(decryptAppid)) {
                    result = "";
                }
            }
        } catch (Exception e) {
            result = "";
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 检测结构请求返回的数据
     */
    public static JSONObject checkResult(JSONObject result) {
        if (ObjectUtil.isNull(result)) {
            throw new RuntimeException("微信平台接口异常，没任何数据返回！");
        }
        if (result.containsKey("errcode") && "0".equals(result.getString("errcode"))) {
            return result;
        }
        if (result.containsKey("errmsg")) {
            throw new RuntimeException("微信接口调用失败：" + result.getString("errcode") + result.getString("errmsg"));
        }
        return result;
    }
}
