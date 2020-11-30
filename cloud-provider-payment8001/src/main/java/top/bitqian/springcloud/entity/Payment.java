package top.bitqian.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 支付信息实体类~
 * @author echo lovely
 * @date 2020/11/30 16:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment implements Serializable {

    private Long id;
    /**
     * 支付流水号
     */
    private String serial;

}
