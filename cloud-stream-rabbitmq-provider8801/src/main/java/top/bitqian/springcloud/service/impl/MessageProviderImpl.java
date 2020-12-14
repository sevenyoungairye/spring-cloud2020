package top.bitqian.springcloud.service.impl;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import top.bitqian.springcloud.service.IMessageProvider;

import javax.annotation.Resource;
import java.util.UUID;

/**
 * 使用绑定器发送消息实现
 * @author echo lovely
 * @date 2020/12/14 19:35
 */

@EnableBinding(value = Source.class) // output 定义消息的推送管道
public class MessageProviderImpl implements IMessageProvider {

    @Resource
    private MessageChannel output; // 消息发送管道

    @Override
    public String sendMessage() {

        // uuid
        String uuId = UUID.randomUUID().toString();

        // send message..
        output.send(MessageBuilder.withPayload(uuId).build());

        System.out.println("===================>" + uuId);

        return null;
    }

}
