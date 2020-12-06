/**
 * <p>
 *     开启我的小总结
 *     1. eureka zookeeper consul 三种服务注册中心的对比
 *     2. 对应的分布式cap理论
 * </p>
 * @author echo lovely
 * @date 2020/12/6 15:02
 */

public class Demo {

    /**
     * 1. cap理论:
     * c: 数据一致性(强一致性) consistency
     * a: 可用性availability
     * p: 分区容错 partition tolerance
     *
     * 2. eureka 与consul zk
     * eureka ap ap架构数据可能错，但是系统稳定
     * zk/consul cp cp架构，数据错，系统炸
     *
     * 3. 对比
     * 组件       语言      cap     服务健康检查      对外暴露接口      spring_cloud集成
     * eureka     java      ap      可配支持        http            y
     * zk         java      cp      支持           客户端           y
     * consul     go        cp       支持          http/dns        y
     *
     *
     */

}
