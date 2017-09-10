mirana-asset
-----------
> 提供资产管理服务

## 1. 用途
承担Eureka的客户端角色，向Eureka服务器发现注册与发现服务。

## 2. 发现服务
通过com.netflix.discovery.EurekaClient来从

## 3. 说明
1. 必须要首先启动Euraka服务器，即mirana-eureka项目；
2. 代码修改后会自动更新，无需自动启动服务；
3. 每个项目都可以有多个实例，但需要它们的端口不一致，否则启动受阻；