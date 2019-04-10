# 服务监控hystrixDashboard
## 概述
除了隔离依赖服务的调用以外，Hystrix还提供了准实时的调用监控（Hystrix Dashboard），Hystrix会持续地记录所有通过Hystrix发起的请求的执行信息，并以统计报表和图形的形式展示给用户，包括每秒执行多少请求多少成功，多少失败等。Netflix通过hystrix-metrics-event-stream项目实现了对以上指标的监控。Spring Cloud也提供了Hystrix Dashboard的整合，对监控内容转化成可视化界面。

## 步骤
### 1、新建工程microservicecloud-consumer-hystrix-dashboard
### 2、POM
```xml
   <!-- hystrix和 hystrix-dashboard相关-->
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-hystrix</artifactId>
   </dependency>
   <dependency>
       <groupId>org.springframework.cloud</groupId>
       <artifactId>spring-cloud-starter-hystrix-dashboard</artifactId>
   </dependency> 
```
### 3、YML
```yaml
server:
  port: 9001
```
### 4、主启动类改名+新注解@EnableHystrixDashboard
```java
package com.wsh.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard //开启服务监控
public class DeptConsumer_DashBoard_App {

    public static void main(String[] args) {
        SpringApplication.run(DeptConsumer_DashBoard_App.class, args);
    }
}

```
### 5、所有Provider微服务提供类(8001/8002/8003)都需要监控依赖配置
```xml
   <!-- actuator监控信息完善 -->
   <dependency>
     <groupId>org.springframework.boot</groupId>
     <artifactId>spring-boot-starter-actuator</artifactId>
   </dependency>
```
### 6、启动microservicecloud-consumer-hystrix-dashboard该微服务监控消费端
访问 http://localhost:9001/hystrix
### 7、启动3个eureka集群
### 8、启动的相关微服务工程
启动microservicecloud-provider-dept-hystrix-8001
测试请求访问：http://localhost:8001/dept/get/1
http://localhost:8001/hystrix.stream

### 9、监控测试
- 多次刷新http://localhost:8001/dept/get/1
- 观察监控窗口

1、 填写监控地址
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190410230415181.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1c2g5Mw==,size_16,color_FFFFFF,t_70)

1）Delay：该参数用来控制服务器上轮询监控信息的延迟时间，默认为2000毫秒，可以通过配置该属性来降低客户端的网络和CPU消耗。
 
2）Title：该参数对应了头部标题Hystrix Stream之后的内容，默认会使用具体监控实例的URL，可以通过配置该信息来展示更合适的标题。

2、监控结果
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190410230750157.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1c2g5Mw==,size_16,color_FFFFFF,t_70)

3、如何看
- 7色
- 1圈
实心圆：共有两种含义。它通过颜色的变化代表了实例的健康程度，它的健康度从绿色<黄色<橙色<红色递减。
该实心圆除了颜色的变化之外，它的大小也会根据实例的请求流量发生变化，流量越大该实心圆就越大。所以通过该实心圆的展示，就可以在大量的实例中快速的发现故障实例和高压力实例。
- 1线
曲线：用来记录2分钟内流量的相对变化，可以通过它来观察到流量的上升和下降趋势。
- 整图说明
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190410231041577.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1c2g5Mw==,size_16,color_FFFFFF,t_70)
- 复杂图
![在这里插入图片描述](https://img-blog.csdnimg.cn/20190410231152835.jpg?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3d1c2g5Mw==,size_16,color_FFFFFF,t_70)


