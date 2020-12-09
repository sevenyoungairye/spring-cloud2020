package top.bitqian.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;
import top.bitqian.springcloud.entity.CommonResult;
import top.bitqian.springcloud.entity.Payment;
import top.bitqian.springcloud.service.PaymentService;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 支付接口
 * @author echo lovely
 * @date 2020/11/30 16:43
 */

@RestController
@Slf4j // lombok 日志打印记录
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    // 对外提供接口, 暴露当前的所有服务名, 和具体的服务实例.
    @Resource
    private DiscoveryClient discoveryClient;

    //  当前支付模块服务端口
    @Value("${server.port}")
    private String port;

    // @RequestBody 接收请求体中的数据~
    @PostMapping("/payment/create")
    public CommonResult createPayment(@RequestBody Payment payment) {

        System.out.println("===========>" + payment);

        int res = paymentService.createPayment(payment);
        log.info("==========================>完成新增");
        if (res > 0) {
            log.info("================================> 新增成功");
            return new CommonResult<>(200, "create success, serverPort" + port, res);
        } else {

            return new CommonResult<>(400, "create failure ~", res);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id) {

        Payment payment = paymentService.getPaymentById(id);

        if (payment != null) {
            log.info("查询成功=====>" + payment);
            return new CommonResult<>(200, "find it!, serverPort" + port, payment);
        }

        log.info("nothing..");

        return new CommonResult<>(444, "nothing..");

    }

    @RequestMapping("/payment/discovery")
    public Object getDiscovery() {

        // 获取注册到服务中心的所有服务
        List<String> services = discoveryClient.getServices();

        services.forEach(service-> log.info("service in register------->" +  service));

        // 获取服务支付服务下的 服务实例
        List<ServiceInstance> paymentInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

        paymentInstances.forEach(paymentService -> {
            log.info("host----------->" + paymentService.getHost());
            log.info("port----------->" + paymentService.getPort());
            log.info("instance id----------->" + paymentService.getInstanceId());
            log.info("service id----------->" + paymentService.getServiceId());
            log.info("uri----------->" + paymentService.getUri());
        });

        return this.discoveryClient;
    }

    // 手写 轮询测试~
    @GetMapping("/payment/lb")
    public String getByLb() {

        return "" + port;
    }

    // 测试feign的超时控制~
    @GetMapping("/payment/feign/timeout")
    public String paymentFeignTimeout() {

        try {
            // moni某个业务进行，需要3秒
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return this.port;
    }

}
