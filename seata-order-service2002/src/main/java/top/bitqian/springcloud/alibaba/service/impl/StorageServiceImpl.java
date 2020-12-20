package top.bitqian.springcloud.alibaba.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import top.bitqian.springcloud.alibaba.dao.StorageDao;
import top.bitqian.springcloud.alibaba.service.StorageService;

import javax.annotation.Resource;

/**
 * 降库存操作
 * @author echo lovely
 * @date 2020/12/20 17:18
 */

@Slf4j
@Service
public class StorageServiceImpl implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Override
    public void decreaseStorage(Long productId, Integer count) {

        log.info("============> seata-storage-service 去库存start");
        storageDao.decreaseStorage(productId, count);
        log.info("============> seata-storage-service 去库存end");

    }
}
