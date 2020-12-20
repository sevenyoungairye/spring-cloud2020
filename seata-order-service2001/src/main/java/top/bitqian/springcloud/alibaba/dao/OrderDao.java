package top.bitqian.springcloud.alibaba.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import top.bitqian.springcloud.alibaba.domain.Order;

/**
 * order crud
 * @author echo lovely
 * @date 2020/12/20 11:48
 */

@Mapper
public interface OrderDao {

    void create(Order order);


    // 根据用户id修改对应的订单状态
    void update(@Param(("userId")) Long userId, @Param("status") Integer status);

}
