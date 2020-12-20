package top.bitqian.springcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.bitqian.springcloud.alibaba.dao.AccountDao;
import top.bitqian.springcloud.alibaba.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.concurrent.TimeUnit;

/**
 * 对用户的账户操作,
 * @author echo lovely
 * @date 2020/12/20 19:46
 */

@Slf4j
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decreaseAccount(Long userId, BigDecimal money) {

        try {
            // 模拟某个业务超时, 先睡个20秒钟。
            TimeUnit.SECONDS.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        log.info("===========> seata-account-service 扣钱start");
        accountDao.decreaseAccount(userId, money);
        log.info("===========> seata-account-service 扣钱end");

    }

}
