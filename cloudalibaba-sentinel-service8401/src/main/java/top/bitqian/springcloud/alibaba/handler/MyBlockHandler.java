package top.bitqian.springcloud.alibaba.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import top.bitqian.springcloud.entity.CommonResult;

/**
 * 抽取 降级处理类
 * @author echo lovely
 * @date 2020/12/18 17:12
 */

public class MyBlockHandler {

    // BlockException 别忘了
    public static CommonResult<String> blockExceptionHandler1(BlockException ex) {

        return new CommonResult(444, "处理方法1 MyBlockHandler ---> blockExceptionHandler1", null);
    }

    public static CommonResult<String> blockExceptionHandler2(BlockException ex) {

        return new CommonResult(444, "处理方法2 MyBlockHandler ---> blockExceptionHandler2", null);
    }

}
