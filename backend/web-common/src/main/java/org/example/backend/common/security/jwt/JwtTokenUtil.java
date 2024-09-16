package org.example.backend.common.security.jwt;

import io.jsonwebtoken.*;
import org.example.backend.common.model.enums.TokenType;
import org.example.backend.common.security.exception.AuthException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description:
 * @Author: liwu3
 * @Date: 2021/7/21 11:45
 */
public class JwtTokenUtil {

    /**
     * 默认jwt密钥
     */
    private static final String tokenSignKey = "_@#$!%_encrypt";

    /**
     * 默认token过期时间（单位：秒）
     */
    private static final int tokenExpireSeconds = 24 * 60 * 60;

    public static final String TYPE = "type";
    public static final String USERID = "userId";
    public static final String USERNAME = "userName";
    public static final String NICKNAME = "nickName";

    public static String generateNotExpiredToken(TokenType tokenType, Integer userId, String userName, String nickName) {
        Map<String, Object> map = new HashMap<>();
        map.put(TYPE, tokenType.getLabel());
        map.put(USERID, userId);
        map.put(USERNAME, userName);
        map.put(NICKNAME, nickName);
        return Jwts.builder()
                .setClaims(map)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compact();
    }

    /**
     * 生成token,可自定义信息
     *
     * @return
     */
    public static String generateToken(TokenType tokenType, Integer userId, String userName, String nickName) {
        return generateToken(tokenType, userId, userName, nickName, tokenExpireSeconds);
    }

    public static String generateToken(TokenType tokenType, Integer userId, String userName, String nickName, long expireSeconds) {
        if (expireSeconds <= 0) {
            return generateNotExpiredToken(tokenType, userId, userName, nickName);
        }
        Map<String, Object> map = new HashMap<>();
        map.put(TYPE, tokenType.getLabel());
        map.put(USERID, userId);
        map.put(USERNAME, userName);
        map.put(NICKNAME, nickName);
        return Jwts.builder()
                .setClaims(map)
                .setSubject(userName)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expireSeconds * 1000))
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)
                .compact();
    }

    /**
     * 根据token获取Claims
     *
     * @param token
     * @return
     */
    private static Claims getClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(tokenSignKey)
                .parseClaimsJws(token)
                .getBody();
    }

    public static String getUserNameByToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return (String) claims.get(USERNAME);
    }

    public static Integer getUserIdByToken(String token) {
        Claims claims = getClaimsFromToken(token);
        return (Integer) claims.get(USERID);
    }

    public static TokenType getTokenTypeByToken(String token) {
        Claims claims = getClaimsFromToken(token);
        String type = (String) claims.get(TYPE);
        return TokenType.getLabel(type);
    }

    /**
     * 校验token是否正确
     *
     * @param token
     * @return
     */
    public static boolean checkToken(String token) {
        try {
            getClaimsFromToken(token);
            return true;
        } catch (JwtException jwtException) {
            return false;
        }
    }

    /**
     * 校验token是否失效
     *
     * @param token
     * @return
     */
    public static boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            final Date expiration = claims.getExpiration();
            if (expiration == null) {
                return false;
            }
            return expiration.before(new Date());
        } catch (ExpiredJwtException expiredJwtException) {
            return true;
        }
    }

    /**
     * 校验token是否正确
     *
     * @param token
     */
    public static void validateToken(String token) {
        boolean tokenCorrect = JwtTokenUtil.checkToken(token);
        if (!tokenCorrect) {
            throw new AuthException("请求token错误");
        }
        boolean tokenExpired = JwtTokenUtil.isTokenExpired(token);
        if (tokenExpired) {
            throw new AuthException("请求token已过期");
        }
    }

}
