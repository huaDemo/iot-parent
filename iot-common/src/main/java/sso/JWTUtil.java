package sso;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sso.properties.SystemProperties;
import util.SpringContextUtils;

import java.util.Date;

/**
 * @author MrBird
 */
public class JWTUtil {

    private static Logger log = LoggerFactory.getLogger(JWTUtil.class);

    private static final long EXPIRE_TIME = SpringContextUtils.getBean(SystemProperties.class).getJwtTimeOut() * 1000;

    /**
     * 校验 token是否正确
     *
     * @param token    密钥
     * @param secret   用户的密码
     * @param deviceid 设备id
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String deviceid, String secret) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim("username", username)
                    .withClaim("deviceid", deviceid)
                    .build();
            verifier.verify(token);
            log.info("token is valid");
            return true;
        } catch (Exception e) {
            log.info("token is invalid{}", e.getMessage());
            return false;
        }
    }

    /**
     * 从 token中获取用户名
     *
     * @return token中包含的用户名
     */
    public static String getUsername(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("username").asString();
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    public static String getDeviceid(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("deviceid").asString();
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 获取token过期时间
     *
     * @param token
     * @return
     */
    public static Date getExpireAt(String token) {
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getExpiresAt();
        } catch (Exception e) {
            log.error("error：{}", e.getMessage());
            return null;
        }
    }

    /**
     * 生成 token
     *
     * @param username 用户名
     * @param secret   用户的密码
     * @return token
     */
    public static String sign(String username, String deviceid, String secret) {
        try {
            username = StringUtils.lowerCase(username);
            Date date = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.create()
                    .withClaim("username", username)
                    .withClaim("deviceid", deviceid)
                    .withExpiresAt(date)
                    .sign(algorithm);
        } catch (Exception e) {
            log.error("error：{}", e);
            return null;
        }
    }

}