package com.hua.iotdevice.mi;

import com.alibaba.fastjson.JSONObject;
import com.hua.iotdevice.mi.service.BaseService;
import org.springframework.stereotype.Service;

/**
 * @ClassName BaseServiceImpl
 * @Description TODO
 * @Auther hua
 * @Date 2019/8/10 20:08
 * @Version 1.0
 */
@Service
public class BaseServiceImpl implements BaseService {

    @Override
    public JSONObject getDevices(String compact) {
        return null;
    }

}
