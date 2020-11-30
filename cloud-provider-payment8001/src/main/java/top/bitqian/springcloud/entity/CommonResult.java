package top.bitqian.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 返回数据泛型类~
 * @author echo lovely
 * @date 2020/11/30 16:31
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResult<T> {

    /**
     * 状态码
     */
    private Integer code;
    /**
     * 消息
     */
    private String message;
    /**
     * data
     */
    private T  data;

    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
