package top.bitqian.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * @author echo lovely
 * @date 2020/12/17 11:12
 */

@RestController
public class FlowLimitController {

    @GetMapping("/test/a")
    public String getA() {

        return "A \t" + new Date(System.currentTimeMillis());
    }

    @GetMapping("/test/b")
    public String getB() {

        return "B \t" + new Date(System.currentTimeMillis());
    }

}
