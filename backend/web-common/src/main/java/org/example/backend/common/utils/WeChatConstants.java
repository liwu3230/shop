package org.example.backend.common.utils;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/14 11:44
 */
public class WeChatConstants {

    /** 小程序登录凭证校验的url */
    public static final String WECHAT_MINI_SNS_AUTH_CODE2SESSION_URL = "https://api.weixin.qq.com/sns/jscode2session?appid={}&secret={}&js_code={}&grant_type=authorization_code";
    /** 小程序生成小程序码的url */
    public static final String WECHAT_MINI_QRCODE_UNLIMITED_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token={}";
    /** 小程序发送订阅消息的url */
    public static final String WECHAT_MINI_SEND_SUBSCRIBE_URL = "https://api.weixin.qq.com/cgi-bin/message/subscribe/send?access_token={}";
    /** 小程序获取订阅列表（自己的） */
    public static final String WECHAT_MINI_GET_ALL_PRIVATE_TEMPLATE_URL = "https://api.weixin.qq.com/wxaapi/newtmpl/gettemplate?access_token={}";
    /** 小程序删除模板（自己的） */
    public static final String WECHAT_MINI_DEL_PRIVATE_TEMPLATE_URL = "https://api.weixin.qq.com/wxaapi/newtmpl/deltemplate?access_token={}";
    /** 小程序获取订阅模板（小程序的） */
    public static final String WECHAT_MINI_GET_TEMPLATE_URL = "https://api.weixin.qq.com/wxaapi/newtmpl/getpubtemplatekeywords?access_token={}&tid={}";


}
