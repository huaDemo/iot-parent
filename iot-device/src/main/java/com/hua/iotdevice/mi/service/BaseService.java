package com.hua.iotdevice.mi.service;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName BaseService
 * @Description TODO
 * @Auther hua
 * @Date 2019/8/8 21:31
 * @Version 1.0
 */
public interface BaseService {

    /**
     * 获取设备列表
     *
     * @param compact
     * @return
     */
    JSONObject getDevices(String compact);




}
