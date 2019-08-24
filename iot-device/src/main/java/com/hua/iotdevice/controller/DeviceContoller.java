package com.hua.iotdevice.controller;

import com.hua.iotdevice.entity.DeviceInfo;
import com.hua.iotdevice.mapper.IotDeviceInfoMapper;
import entity.BaseResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @ClassName DeviceContoller
 * @Description TODO
 * @Auther hua
 * @Date 2019/8/15 20:55
 * @Version 1.0
 */
@RestController
@RequestMapping("/device")
public class DeviceContoller {

    @Autowired
    private IotDeviceInfoMapper iotDeviceInfoMapper;

    @RequestMapping(value = "test/{groupid}", method = RequestMethod.GET)
    public BaseResp<DeviceInfo> test(@PathVariable("groupid") Long groupid) throws Exception {
        BaseResp<DeviceInfo> baseResp = new BaseResp<DeviceInfo>();
        baseResp.setResult((DeviceInfo) iotDeviceInfoMapper.selectById(groupid));
        return baseResp;
    }

}
