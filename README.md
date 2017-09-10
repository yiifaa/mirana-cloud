mirana-cloud
------------
> 基于spring-cloud进行分布式微服务开发

## 1. 启动过程
必须首先启动服务管理器（Eureka Server）,请参见mirana-eureka项目
```bash
#  首先进入mirana-eureka项目
cd mirana-eureka
# windows
mvnw spring-boot:run
# linux and mac
./mvnw spring-boot:run
```
访问http://localhost:8761，可进入微服务管理页面。

再依次启动其他微服务模块。
