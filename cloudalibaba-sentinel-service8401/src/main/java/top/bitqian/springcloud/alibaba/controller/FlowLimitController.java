package top.bitqian.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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


    @GetMapping("/test/d")
    public String getD() {

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("============> come d ...");

        return "D \t" + "";
    }

    @GetMapping("/test/e")
    public String getE() {

        // System.out.println(1/0); // 测试用, 注释了

        return "E 测试异常比例";
    }

    @GetMapping("/test/f")
    public String getF() {

        // System.out.println(1/0); // 注释了

        return "F 测试异常数, 按分钟统计";
    }


    /**
     * 热点配置，比如关键商品的搜索, 需要进行流量控制。
     * @param p1 p1 not necessary
     * @param p2 p2 not necessary
     * @return success msg
     */
    @SentinelResource(value = "test_hotkey", blockHandler = "testHotKeyHandler")
    @GetMapping("/test_hotkey")
    public String testHotKey(@RequestParam(value = "p1", required = false) String p1,
                             @RequestParam(value = "p2", required = false) String p2)
    {
        log.info("parameter: " + p1 + "\t" + p2);
        return "hot key flow limit test...";
    }

    /**
     * 兜底方法
     * @param p1 p1
     * @param p2 p2
     * @param ex ex
     * @return flow limit info
     */
    public String testHotKeyHandler(String p1, String p2, BlockException ex) {

        log.info("" + p1 + "\t" + p2 + "\t" + ex.getMessage());

        return "sth error... /(ㄒoㄒ)/~~";
    }

}
