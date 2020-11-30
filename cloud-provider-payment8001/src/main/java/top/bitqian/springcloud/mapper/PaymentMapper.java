package top.bitqian.springcloud.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import top.bitqian.springcloud.entity.Payment;

/**
 * mapper interface ~
 * @author echo lovely
 * @date 2020/11/30 16:35
 */

@Mapper
@Repository
public interface PaymentMapper {

    int createPayment(Payment payment);

    Payment getPaymentById(Long id);
}
