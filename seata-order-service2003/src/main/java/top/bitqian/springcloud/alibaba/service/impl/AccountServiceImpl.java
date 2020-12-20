package top.bitqian.springcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.bitqian.springcloud.alibaba.dao.AccountDao;
import top.bitqian.springcloud.alibaba.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

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

        log.info("===========> seata-account-service 扣钱start");
        accountDao.decreaseAccount(userId, money);
        log.info("===========> seata-account-service 扣钱end");

    }

}
