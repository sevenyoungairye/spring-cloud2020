package top.bitqian.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.alibaba.domain.CommonResult;
import top.bitqian.springcloud.alibaba.domain.Order;
import top.bitqian.springcloud.alibaba.service.OrderService;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2020/12/20 15:56
 */

@RestController
public class OrderController {


    @Resource
    private OrderService orderService;

    // 暴露rest接口
    @GetMapping("/order/create")
    public CommonResult create(Order order) {

        orderService.create(order);

        return new CommonResult(200, "ok 订单创建成功");
    }

}
