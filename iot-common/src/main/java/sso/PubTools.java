package sso;

import cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName PubTools
 * @Description TODO
 * @Auther hua
 * @Date 2019/7/17 16:41
 * @Version 1.0
 */
@Component
public class PubTools {

    @Autowired
    private Cache cache;

    /**
     * 获取token和密码
     *
     * @param username
     * @return 用户
     */
    public Map<String, String> getTokenAndPwd(String username) {
        String str = cache.get("inco:token:" + username);
        String deviceId = cache.get("inco:si:" + username);
        if (str != null && deviceId != null) {
            Map<String, String> map = new HashMap<String, String>();
            String[] strings = str.split(":");
            if (strings.length > 0) {
                map.put("token", strings[0]);
                map.put("pwd", strings[1]);
                map.put("deviceid", deviceId);
                return map;
            }
        }
        return null;
    }

}
