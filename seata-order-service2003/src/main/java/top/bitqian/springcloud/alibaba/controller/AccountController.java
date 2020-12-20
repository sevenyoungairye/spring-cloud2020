package top.bitqian.springcloud.alibaba.controller;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.alibaba.domain.CommonResult;
import top.bitqian.springcloud.alibaba.service.AccountService;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author echo lovely
 * @date 2020/12/20 19:47
 */

@RestController
public class AccountController {

    @Resource
    private AccountService accountService;

    @RequestMapping("/account/decrease")
    public CommonResult decrease(@Param("userId") Long userId, @Param("money") BigDecimal money) {

        accountService.decreaseAccount(userId, money);

        return new CommonResult(200, "accountController 完成库存操作~");
    }

}
