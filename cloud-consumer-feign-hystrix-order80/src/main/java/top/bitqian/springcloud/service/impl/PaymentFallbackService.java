package top.bitqian.springcloud.service.impl;

import org.springframework.stereotype.Component;
import top.bitqian.springcloud.service.PaymentHystrixService;

/**
 * 解决代码耦合, 服务down机
 * @author echo lovely
 * @date 2020/12/11 17:45
 */

@Component
public class PaymentFallbackService implements PaymentHystrixService {

    @Override
    public String payment_ok(Integer id) {
        return "嘤嘤嘤，服务器宕机了.. client调用payment_ok方法";
    }

    @Override
    public String payment_timeout(Integer id) {

        return "服务器挂了... client调用payment_timeout";
    }

}
