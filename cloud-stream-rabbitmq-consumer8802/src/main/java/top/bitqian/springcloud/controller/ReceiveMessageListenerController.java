package top.bitqian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * @author echo lovely
 * @date 2020/12/15 15:36
 */

@EnableBinding(Sink.class) // 用于接收消息
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    // get msg from rabbitMQ
    @StreamListener(Sink.INPUT) // get input
    public void getMessage(Message<String> message) {

        String msg = message.getPayload();

        System.out.println("consumer get msg from rabbitmq... port: " + serverPort + "\t" + msg);
    }

}
