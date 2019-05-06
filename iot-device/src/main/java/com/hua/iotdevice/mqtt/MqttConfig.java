package com.hua.iotdevice.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName mqttconfig
 * @Description TODO
 * @Auther hua
 * @Date 2019/5/5 18:12
 * @Version 1.0
 */
@Configuration
@ConfigurationProperties(prefix = "mqtt")
public class MqttConfig {

    private String host;
    private String username;
    private String password;
    private String clientId;
    private int qos;
    private int connectionTimeout;
    private int keepAliveInterval;

    @Bean
    public MqttClient mqttClient() throws Exception {
        
        MqttClient mqttClient = new MqttClient(host, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        options.setCleanSession(false);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(connectionTimeout);
        // 设置会话心跳时间
        options.setKeepAliveInterval(keepAliveInterval);
        mqttClient.setCallback(new PushCallback());
        mqttClient.connect(options);
        mqttClient.subscribe("/server", qos);
        return mqttClient;
    }

}
