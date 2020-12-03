/**
 * zookeeper 使用相关。
 * @author echo lovely
 * @date 2020/12/3 22:51
 */

public class Demo {

    /**


     zookeeper启动
     1. ./zkServer.sh start
     2. ./zkCli.sh   # 连接服务~

     ls / # 查看结点

     get /zookeeper

     ls /zookeeper # 查看当前服务的结点

     ls /services # 查看服务

     ls /services/cloud-provider-payment # 查看当前服务的流水号~

     get /services/cloud-provider-payment/fiururr-jgtr009-jngg9 # 查看具体某个服务的服务信息

     {
     "name": "cloud-provider-payment",
     "id": "0301d874-94d8-4115-b04d-b3e107cad26a",
     "address": "192.168.0.167",
     "port": 8004,
     "sslPort": null,
     "payload": {
     "@class": "org.springframework.cloud.zookeeper.discovery.ZookeeperInstance",
     "id": "application-1",
     "name": "cloud-provider-payment",
     "metadata": {}
     },
     "registrationTimeUTC": 1607004949029,
     "serviceType": "DYNAMIC",
     "uriSpec": {
     "parts": [
     {
     "value": "scheme",
     "variable": true
     },
     {
     "value": "://",
     "variable": false
     },
     {
     "value": "address",
     "variable": true
     },
     {
     "value": ":",
     "variable": false
     },
     {
     "value": "port",
     "variable": true
     }
     ]
     }
     }

     */

}
