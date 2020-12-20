package top.bitqian.springcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.bitqian.springcloud.alibaba.dao.OrderDao;
import top.bitqian.springcloud.alibaba.domain.Order;
import top.bitqian.springcloud.alibaba.service.AccountService;
import top.bitqian.springcloud.alibaba.service.OrderService;
import top.bitqian.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

/**
 * @author echo lovely
 * @date 2020/12/20 15:02
 */

@Slf4j
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    @Resource
    private StorageService storageService;

    @Resource
    private AccountService accountService;

    // 订单创建的流程: 订单生成---> 调用库存服务扣减库存 ---> 调用账户服务扣减账户余额 ---> 修改订单状态
    @Override
    public void create(Order order) {

        log.info("-------> 开始创建订单");
        // 1. 创建订单
        orderDao.create(order);

        // 2. 减库存
        log.info("-------> 订单微服务调用库存, 减少库存开始~");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------> 订单微服务调用库存完成, 库存已减少~");

        // 3， 扣钱
        log.info("-------> 订单微服务开始调用账户, 做扣减开始~");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------> 订单微服务完成调用账户, 扣减完成~");

        // 4. 修改订单状态, 下单完成
        log.info("-------> 订单微服务改变状态, 此账户已经下单");
        orderDao.update(order.getUserId(), 0);
        log.info("-------> 已经完成下单~");

    }


}
