/**
 * @author echo lovely
 * @date 2020/12/17 14:58
 */

public class Demo {

    public static void main(String[] args) {

        // 流控模式 1. 直接 2. 关联 3. 链路

        // 流控效果 1. 直接失败 2. warm up 预热 3. 排队等待

        // warm up ---> 阈值t = 单机阈值/3, 在预热时常内, 阈值为t, 超过预热时常, 阈值到达设定的单机阈值。
        // 场景：秒杀, 一大波流量过来, 使用设置warm up, 让系统能够得到缓冲.

        // 排队等待qps ---> 每隔多少秒才能下一个请求 可以设置1s一个请求, 不管多少个请求, 1s只处理一个请求。


    }

}
