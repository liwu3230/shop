package org.example.backend.common.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.server.ServletServerHttpRequest;

import jakarta.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2024/4/16 16:40
 */
public class RequestUtil {

    private RequestUtil() {
    }

    public static Map<String, Object> getBodyMap(HttpServletRequest request, List<HttpMessageConverter<?>> httpMessageConverters) throws IOException {
        Object body = readRequestBody(request, httpMessageConverters);
        if (body instanceof Map) {
            return (Map<String, Object>) body;
        }
        return null;
    }

    public static Object readRequestBody(HttpServletRequest request, List<HttpMessageConverter<?>> httpMessageConverters) throws IOException {
        if (httpMessageConverters != null && request.getContentType() != null) {
            MediaType mediaType = MediaType.valueOf(request.getContentType());
            Class clazz = Object.class;
            try {
                for (HttpMessageConverter<?> converter : httpMessageConverters) {
                    if (converter.canRead(clazz, mediaType)) {
                        return converter.read(clazz, new ServletServerHttpRequest(request));
                    }
                }
            } catch (HttpMessageNotReadableException ignored) {
                return null;
            }
        }
        return null;
    }

    public static Map<String, Object> buildSessionParams(HttpServletRequest request) {
        Enumeration<String> keys = request.getSession().getAttributeNames();
        Map<String, Object> result = new HashMap<>();
        while (keys.hasMoreElements()) {
            String key = keys.nextElement();
            result.put(key, request.getSession().getAttribute(key));
        }
        return result;
    }

    public static Map<String, String> buildHeaderParams(HttpServletRequest request) throws UnsupportedEncodingException {
        Enumeration<String> headerKeys = request.getHeaderNames();
        Map<String, String> result = new HashMap<>();
        while (headerKeys.hasMoreElements()) {
            String key = headerKeys.nextElement();
            String value = request.getHeader(key);
            result.put(key, URLDecoder.decode(value, "utf-8"));
        }
        return result;
    }

    public static String getUri(HttpServletRequest request){
        String uri = request.getRequestURI();
        List<String> list = CommaSplitUtils.toList(uri, "/");
        list.removeIf(StringUtils::isNumeric); //去掉url中的数字参数
        list.removeIf(c -> c.contains(","));// 去掉url中的逗号分隔参数
        return StringUtils.join(list, "/");
    }

}
