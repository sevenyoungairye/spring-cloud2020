package top.bitqian.springcloud.alibaba.service;

import java.math.BigDecimal;

/**
 * @author echo lovely
 * @date 2020/12/20 19:45
 */

public interface AccountService {

    void decreaseAccount(Long userId, BigDecimal money);

}
