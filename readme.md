cloud-common-api: 公共代码

### eureka
cloud-eureka-server-7001: 注册中心 
cloud-eureka-server-7002: 注册中心
注册中心在集群环境要相互注册

hosts文件中：（因为两个注册中心都在本机，加上下面的映射加以区分）
127.0.0.1 eureka7001.com
127.0.0.1 eureka7002.com

cloud-consumer-order-80: 服务消费者，基于RestTemplate；注册到eureka

cloud-provider-payment-8001: 服务提供者，注册到eureka
cloud-provider-payment-8002: 服务提供者，注册到eureka

### ribbon
引入eureka就引入了ribbon
ribbon结合RestTemplate使用


### zookeeper
zk使用的是临时节点
zk-consumer-order-80: 服务消费者，基于RestTemplate；注册到zk
cloud-provider-payment-8004: 服务提供者；注册到zk
cloud-provider-payment-8005: 服务提供者；注册到zk


### consul go语言开发
    需要单独下载
    # consul.exe agent -dev 启动
    localhost:8500
consul-consumer-order-80: 服务消费者，基于RestTemplate；注册到consul
cloud-provider-payment-8006: 服务提供者；注册到consul
cloud-provider-payment-8007: 服务提供者；注册到consul


### openFeign
openfeign-80: OpenFeign 调用8001和8002