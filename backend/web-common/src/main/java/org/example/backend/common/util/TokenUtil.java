package org.example.backend.common.util;

import lombok.extern.slf4j.Slf4j;

import jakarta.servlet.http.HttpServletRequest;
import java.util.Enumeration;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2022/7/26 9:46
 */
@Slf4j
public class TokenUtil {

    public static String BEARER_TYPE = "Bearer";
    public static String ACCESS_TOKEN = "accessToken";
    public static final String AUTHORIZATION_KEY = "Authori-zation";

    public static String extractToken(HttpServletRequest request) {
        String token = request.getHeader(AUTHORIZATION_KEY);
        if (T.isNotBlank(token)) {
            return token;
        }

        token = extractHeaderToken(request);
        // bearer type allows a request parameter as well
        if (token == null) {
            log.debug("Token not found in headers. Trying request parameters.");
            token = request.getParameter(ACCESS_TOKEN);
            if (token == null) {
                log.debug("Token not found in request parameters.  Not an OAuth2 request.");
            }
        }
        return token;
    }

    /**
     * Extract the OAuth bearer token from a header.
     *
     * @param request The request.
     * @return The token, or null if no OAuth authorization header was supplied.
     */
    private static String extractHeaderToken(HttpServletRequest request) {
        Enumeration<String> tokenHeaders = request.getHeaders(ACCESS_TOKEN);
        while (tokenHeaders.hasMoreElements()) {
            String authHeaderValue = tokenHeaders.nextElement().trim();
            int commaIndex = authHeaderValue.indexOf(',');
            if (commaIndex > 0) {
                authHeaderValue = authHeaderValue.substring(0, commaIndex);
            }
            return authHeaderValue;
        }

        Enumeration<String> headers = request.getHeaders("Authorization");
        while (headers.hasMoreElements()) {
            // typically there is only one (most servers enforce that)
            String value = headers.nextElement();
            if ((value.toLowerCase().startsWith(BEARER_TYPE.toLowerCase()))) {
                String authHeaderValue = value.substring(BEARER_TYPE.length()).trim();
                int commaIndex = authHeaderValue.indexOf(',');
                if (commaIndex > 0) {
                    authHeaderValue = authHeaderValue.substring(0, commaIndex);
                }
                return authHeaderValue;
            }
        }

        return null;
    }

}
