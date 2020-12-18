package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;

import java.util.HashMap;

/**
 * @author echo lovely
 * @date 2020/12/18 20:49
 */

@Slf4j
@RestController
public class PaymentController {


    @Value("${server.port}")
    private String serverPort;

    // dataInfo
    public static HashMap<Long, Payment> hashMap = new HashMap<>();

    // init data
    static {
        hashMap.put(1L,new Payment(1L,"28a8c1e3bc2742d8848569891fb42181"));
        hashMap.put(2L,new Payment(2L,"bba8c1e3bc2742d8848569891ac32182"));
        hashMap.put(3L,new Payment(3L,"6ua8c1e3bc2742d8848569891xt92183"));
    }

    @GetMapping("/payment/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = hashMap.get(id);

        log.info("payment----->" + payment + "\tport----->" + serverPort);

        return new CommonResult<>(200, "ok", payment);
    }


}
