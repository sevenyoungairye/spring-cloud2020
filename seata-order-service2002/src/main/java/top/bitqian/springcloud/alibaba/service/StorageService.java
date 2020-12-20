package top.bitqian.springcloud.alibaba.service;

/**
 * @author echo lovely
 * @date 2020/12/20 17:17
 */

public interface StorageService {

    void decreaseStorage(Long productId, Integer count);

}
