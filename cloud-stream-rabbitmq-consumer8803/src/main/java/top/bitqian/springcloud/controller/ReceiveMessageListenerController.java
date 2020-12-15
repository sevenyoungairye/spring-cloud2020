package top.bitqian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;

/**
 * 8803 get msg from rabbit..
 * @author echo lovely
 * @date 2020/12/15 16:19
 */

@EnableBinding(Sink.class)
public class ReceiveMessageListenerController {

    @Value("${server.port}")
    private String serverPort;

    @StreamListener(Sink.INPUT)
    public void getMessage(Message<String> message) {

        String msg = message.getPayload();

        System.out.println("consumer get msg from rabbitmq... port: " + serverPort + "\t" + msg);
    }

}
