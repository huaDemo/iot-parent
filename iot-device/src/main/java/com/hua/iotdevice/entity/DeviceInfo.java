package com.hua.iotdevice.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import entity.CommonDO;

/**
 * @ClassName DeviceInfo
 * @Description TODO
 * @Auther hua
 * @Date 2019/8/6 21:13
 * @Version 1.0
 */
@TableName(value = "iot_device_info")
public class DeviceInfo extends CommonDO {

    @TableId
    private Long id;

    private String deviceTitle;

    private String deviceName;

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDeviceTitle() {
        return deviceTitle;
    }

    public void setDeviceTitle(String deviceTitle) {
        this.deviceTitle = deviceTitle;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

}
