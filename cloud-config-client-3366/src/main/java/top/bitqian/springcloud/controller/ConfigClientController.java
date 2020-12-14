package top.bitqian.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author echo lovely
 * @date 2020/12/14 14:56
 */

@RefreshScope // refresh msg
@RestController
public class ConfigClientController {

    @Value("config.info")
    private String configInfo;

    @Value("server.port")
    private String port;

    @GetMapping("/configInfo")
    public String getConfigInfo() {

        return "configInfo: " + configInfo + "\nserver.port: " + port;
    }

}
