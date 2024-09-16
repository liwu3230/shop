package org.example.backend.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.*;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/7/25 17:55
 */
@Slf4j
@SuppressWarnings("all")
public class RequestParamsUtil {

    public static MultiValueMap<String, String> encodeQueryParams(MultiValueMap<String, String> params) {
        MultiValueMap<String, String> result = new LinkedMultiValueMap<>(params.size());
        for (Map.Entry<String, List<String>> entry : params.entrySet()) {
            for (String value : entry.getValue()) {
                String key = entry.getKey();
                try {
                    key = URLEncoder.encode(key, "UTF-8");
                } catch (Exception var10) {
                }

                try {
                    value = URLEncoder.encode(value, "UTF-8");
                } catch (Exception var9) {
                }
                result.add(key, value);
            }
        }
        return result;
    }

    public static Map<String, List<String>> parseQueryParams(String queryStr) {
        Map<String, List<String>> qp = new LinkedHashMap();
        if (queryStr == null) {
            return qp;
        } else {
            StringTokenizer st = new StringTokenizer(queryStr, "&");
            while (true) {
                while (st.hasMoreTokens()) {
                    String s = st.nextToken();
                    int i = s.indexOf("=");
                    String name;
                    String value;
                    List valueList;
                    if (i > 0 && s.length() >= i + 1) {
                        name = s.substring(0, i);
                        value = s.substring(i + 1);

                        try {
                            name = URLDecoder.decode(name, "UTF-8");
                        } catch (Exception var10) {
                        }

                        try {
                            value = URLDecoder.decode(value, "UTF-8");
                        } catch (Exception var9) {
                        }

                        valueList = qp.get(name);
                        if (valueList == null) {
                            valueList = new LinkedList();
                            qp.put(name, valueList);
                        }

                        valueList.add(value);
                    } else if (i == -1) {
                        name = s;
                        value = "";

                        try {
                            name = URLDecoder.decode(name, "UTF-8");
                        } catch (Exception var11) {
                        }

                        valueList = qp.get(name);
                        if (valueList == null) {
                            valueList = new LinkedList();
                            qp.put(name, valueList);
                        }

                        valueList.add(value);
                    }
                }
                return qp;
            }
        }
    }

}
