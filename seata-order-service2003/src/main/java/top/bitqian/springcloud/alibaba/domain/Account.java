package top.bitqian.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @author echo lovely
 * @date 2020/12/20 19:25
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    private Integer id;

    private Long userId;

    // 已用额度
    private BigDecimal used;

    // 剩余额度
    private BigDecimal residue;

}
