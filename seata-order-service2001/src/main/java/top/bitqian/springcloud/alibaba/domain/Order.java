package top.bitqian.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * 订单实体
 * @author echo lovely
 * @date 2020/12/20 11:45
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private Long id;
    private Long userId;
    private Long productId; // 商品id
    private Integer count; // 商品数量
    private BigDecimal money;
    private Integer status; // 0 创建中 1 已完结

}
