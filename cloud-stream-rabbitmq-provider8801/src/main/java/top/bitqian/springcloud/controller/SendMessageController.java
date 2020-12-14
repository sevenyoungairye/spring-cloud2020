package top.bitqian.springcloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.service.IMessageProvider;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2020/12/14 19:51
 */

@RestController
public class SendMessageController {

    @Resource
    private IMessageProvider messageProvider;

    @GetMapping("/sendMessage")
    private String sendMessage() {

        return messageProvider.sendMessage();
    }

}
