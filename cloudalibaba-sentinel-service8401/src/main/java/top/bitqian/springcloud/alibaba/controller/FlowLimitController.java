package top.bitqian.springcloud.alibaba.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author echo lovely
 * @date 2020/12/17 11:12
 */

@RestController
@Slf4j
public class FlowLimitController {

    @GetMapping("/test/a")
    public String getA() {

        // 流控: 睡0.8s 测试线程数 1s 一个线程
        /*try {
            TimeUnit.MILLISECONDS.sleep(800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/

        return "A \t" + new Date(System.currentTimeMillis());
    }

    @GetMapping("/test/b")
    public String getB() {


        log.info("============> come b ...");

        return "B \t" + new Date(System.currentTimeMillis());
    }

}
