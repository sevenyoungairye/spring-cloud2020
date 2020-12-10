package top.bitqian.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author echo lovely
 * @date 2020/12/10 20:21
 */

@Service
public class PaymentService {

    public String payment_ok(Integer id) {

        return "线程池: " + Thread.currentThread().getName() + "ok O(∩_∩)O哈哈~ "
                + "id: " + id;
    }

    public String payment_timeout(Integer id) {

        Integer timeout =  3;

        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池: " + Thread.currentThread().getName() +
                "timeout 呜呜呜~" + "id: " + id + "超时(s) " + timeout;
    }

}
