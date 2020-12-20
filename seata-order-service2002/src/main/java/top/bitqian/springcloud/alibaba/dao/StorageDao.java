package top.bitqian.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author echo lovely
 * @date 2020/12/20 17:00
 */
@Mapper
public interface StorageDao {

    // 减库存操作
    void decreaseStorage(@Param("productId") Long productId, @Param("count") Integer count);

}
