package top.bitqian.springcloud.alibaba.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.bitqian.springcloud.alibaba.domain.CommonResult;
import top.bitqian.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

/**
 * 暴露降存库接口~
 * @author echo lovely
 * @date 2020/12/20 17:20
 */

@RestController
public class StorageController {

    @Resource
    private StorageService storageService;

    @RequestMapping("/storage/decrease")
    public CommonResult decrease(Long productId, Integer count) {

        storageService.decreaseStorage(productId, count);

        return new CommonResult<>(200, "storageController 完成库存操作~");
    }

}
