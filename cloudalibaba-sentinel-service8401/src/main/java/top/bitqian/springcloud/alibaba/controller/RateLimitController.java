package top.bitqian.springcloud.alibaba.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.entity.CommonResult;

/**
 * resourceSentinel 限流测试
 * @author echo lovely
 * @date 2020/12/18 16:36
 */

@RestController
public class RateLimitController {

    @GetMapping("/limitBySourceValue")
    @SentinelResource(value = "limitBySourceValue", blockHandler = "testLimitByValueHandler")
    public CommonResult<String> testLimitBySourceValue() {


        return new CommonResult<>(200, "ok", "by sentinel resource");
    }

    // 根据资源名称限流, 超过一定的流量后, 使用自定义的提示相应给客户端。
    public CommonResult<String> testLimitByValueHandler(BlockException ex)
    {
        return new CommonResult<>(444, "bad",
                "sourceValue limit by define handler..." + ex.getClass().getCanonicalName());
    }

    // 根据url限流 并使用默认的提示
    @GetMapping("/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult<String> testLimitByUrl() {

        return new CommonResult<>(200, "ok", "flow limit by url");
    }

}
