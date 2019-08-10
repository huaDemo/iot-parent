package com.hua.iotdevice.config;

import com.hua.iotdevice.mqtt.PushCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;


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
    private String topic;

    @Bean
    public MqttClient mqttClient() throws Exception {
        MqttClient mqttClient = new MqttClient(host, clientId, new MemoryPersistence());
        MqttConnectOptions options = new MqttConnectOptions();
        /*把配置里的 cleanSession 设为false，客户端掉线后 服务器端不会清除session，当重连后可以接收之前订阅主题的消息。
        当客户端上线后会接受到它离线的这段时间的消息*/
        options.setCleanSession(false);
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        // 设置超时时间
        options.setConnectionTimeout(connectionTimeout);
        // 设置会话心跳时间
        options.setKeepAliveInterval(keepAliveInterval);
        // 设置断开连接后尝试重新连接
        options.setAutomaticReconnect(true);
        mqttClient.setCallback(new PushCallback(mqttClient, this));
        mqttClient.connect(options);
        mqttClient.subscribe("/" + topic, qos);
        return mqttClient;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public int getQos() {
        return qos;
    }

    public void setQos(int qos) {
        this.qos = qos;
    }

    public int getConnectionTimeout() {
        return connectionTimeout;
    }

    public void setConnectionTimeout(int connectionTimeout) {
        this.connectionTimeout = connectionTimeout;
    }

    public int getKeepAliveInterval() {
        return keepAliveInterval;
    }

    public void setKeepAliveInterval(int keepAliveInterval) {
        this.keepAliveInterval = keepAliveInterval;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

}
