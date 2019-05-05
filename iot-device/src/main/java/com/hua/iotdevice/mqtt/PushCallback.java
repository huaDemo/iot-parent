package com.hua.iotdevice.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 发布消息的回调类
 * <p>
 * 必须实现MqttCallback的接口并实现对应的相关接口方法CallBack 类将实现 MqttCallBack。
 * 每个客户机标识都需要一个回调实例。在此示例中，构造函数传递客户机标识以另存为实例数据。
 * 在回调中，将它用来标识已经启动了该回调的哪个实例。
 * 必须在回调类中实现三个方法：
 * <p>
 * public void messageArrived(MqttTopic topic, MqttMessage message)接收已经预订的发布。
 * <p>
 * public void connectionLost(Throwable cause)在断开连接时调用。
 * <p>
 * public void deliveryComplete(MqttDeliveryToken token))
 * 接收到已经发布的 QoS 1 或 QoS 2 消息的传递令牌时调用。
 * 由 MqttClient.connect 激活此回调。
 */
public class PushCallback implements MqttCallback {

    private static final Logger logger = LoggerFactory.getLogger(PushCallback.class);

    private volatile boolean connected = false;

    private MqttClient mqttClient;

    @Override
    public void connectionLost(Throwable throwable) {
        if (throwable != null) {
            logger.warn("[客户端断开连接]", throwable);
        }
        //尝试从新连接
        try {
            mqttClient.connect();
            logger.info("[emqx] 客户端已经稳定连接");
        } catch (Exception e) {
            logger.error("重新连接失败", e);
            connected = false;
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (!connected) {
                        try {
                            Thread.sleep(10000);
                            mqttClient.connect();
                            logger.info("[emqx] 客户端已经稳定连接");
                            connected = true;
                        } catch (Exception e1) {
                            logger.error("重新连接失败", e);
                        }
                    }
                }
            }).start();
        }
    }

    @Override
    public void messageArrived(String s, MqttMessage mqttMessage) throws Exception {

    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken iMqttDeliveryToken) {

    }

}
