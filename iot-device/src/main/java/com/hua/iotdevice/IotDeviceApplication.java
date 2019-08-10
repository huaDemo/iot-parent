package com.hua.iotdevice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class IotDeviceApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(IotDeviceApplication.class, args);
    }

}
