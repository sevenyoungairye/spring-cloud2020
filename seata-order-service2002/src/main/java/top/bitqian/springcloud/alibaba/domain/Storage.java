package top.bitqian.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author echo lovely
 * @date 2020/12/20 16:57
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Storage {

    private Long id;
    private Long productId;
    // 总库存
    private Integer total;
    // 已用库存
    private Integer used;
    // 剩余库存
    private Integer residue;

}
