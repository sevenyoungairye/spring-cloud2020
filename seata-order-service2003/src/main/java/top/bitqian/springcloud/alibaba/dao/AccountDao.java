package top.bitqian.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * 账户dao
 * @author echo lovely
 * @date 2020/12/20 19:27
 */

@Mapper
public interface AccountDao {

    void decreaseAccount(@Param("userId") Long userId, @Param("money") BigDecimal money);


}
