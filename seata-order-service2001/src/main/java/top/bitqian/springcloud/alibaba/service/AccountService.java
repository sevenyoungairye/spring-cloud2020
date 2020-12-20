package top.bitqian.springcloud.alibaba.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.bitqian.springcloud.alibaba.domain.CommonResult;

import java.math.BigDecimal;

/**
 * 账号扣钱
 * @author echo lovely
 * @date 2020/12/20 15:14
 */

@FeignClient(value = "seata-account-service")
public interface AccountService {


    @PostMapping("/account/decrease")
    CommonResult decrease(@RequestParam("userId") Long userId, @RequestParam("money")BigDecimal money);

}
