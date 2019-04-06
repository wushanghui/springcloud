# 微服务与微服务架构简介
## 微服务
马丁.福勒（Martin Fowler） 描述微服务的论文网址：           
https://martinfowler.com/articles/microservices.html

微服务强调的是服务的大小，它关注的是某一个点，是具体解决某一个问题/提供落地对应服务的一个服务应用。

## 微服务架构
微服务架构是⼀种架构模式，它提倡将单⼀应⽤程序划分成⼀组⼩的服务，服务之间互相协调、互相配合，为⽤户提供最终价值。每个服务运⾏在其独⽴的进程中，服务与服务间采⽤轻量级的通信机制互相协作（通常是基于HTTP协议的RESTful API）。每个服务都围绕着具体业务进⾏构建，并且能够被独⽴的部署到⽣产环境、类⽣产环境等。另外，应当尽量避免统⼀的、集中式的服务管理机制，对具体的⼀个服务⽽⾔，应根据业务上下⽂，选择合适的语⾔、⼯具对其进⾏构建。

理解：微服务化的核心就是将传统的一站式应用，根据业务拆分成一个一个的服务，彻底
   地去耦合,每一个微服务提供单个业务功能的服务，一个服务做一件事，
   从技术角度看就是一种小而独立的处理过程，类似进程概念，能够自行单独启动
   或销毁，拥有自己独立的数据库。
   
# 微服务技术栈
|微服务条目	|落地技术	|备注|
|---|---|---|
|服务开发|	Springboot、Spring、SpringMVC||	
|服务配置与管理	|Netflix公司的Archaius、阿里的Diamond ....	||	
|服务注册与发现	|Eureka、Consul、Zookeeper ....	||	
|服务调用	|Rest、RPC、gRPC	||	
|服务熔断器	|Hystrix、Envoy ....	||	
|负载均衡	|Ribbon、Nginx ....	||	
|服务接口调用(客户端调用服务的简化工具)	|Feign ....	||	
|消息队列	|Kafka、RabbitMQ、ActiveMQ ....	||	
|服务配置中心管理	|SpringCloudConfig、Chef ....|	
|服务路由（API网关）	|Zuul ....	||
|服务监控	|Zabbix、Nagios、Metrics、Spectator ....	||	
|全链路追踪|	Zipkin，Brave、Dapper ....	||	
|服务部署|	Docker、OpenStack、Kubernetes ....	||	
|数据流操作开发包	|SpringCloud Stream（封装与Redis,Rabbit、Kafka ....发送接收消息）||	
|事件消息总线|	Spring Cloud Bus||	
|......|||		

# spring cloud

SpringCloud，基于SpringBoot提供了一套微服务解决方案，包括服务注册与发现，配置中心，全链路监控，服务网关，负载均衡，熔断器等组件，除了基于NetFlix的开源组件做高度抽象封装之外，还有一些选型中立的开源组件。
 
SpringCloud利用SpringBoot的开发便利性巧妙地简化了分布式系统基础设施的开发，SpringCloud为开发人员提供了快速构建分布式系统的一些工具，包括配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等,它们都可以用SpringBoot的开发风格做到一键启动和部署。
 
SpringBoot并没有重复制造轮子，它只是将目前各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包

SpringCloud=分布式微服务架构下的一站式解决方案，
是各个微服务架构落地技术的集合体，俗称微服务全家桶

注意：SpringCloud和SpringBoot是什么关系？

1、SpringBoot专注于快速方便的开发单个个体微服务。

2、SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，
为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务
 
3、SpringBoot可以离开SpringCloud独立使用开发项目，但是SpringCloud离不开SpringBoot，属于依赖的关系.
 
4、SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。

官网：http://projects.spring.io/spring-cloud/

参考书：https://springcloud.cc/spring-cloud-netflix.html

此版本开发API说明：http://cloud.spring.io/spring-cloud-static/Dalston.SR1/
 https://springcloud.cc/spring-cloud-dalston.html

springcloud中国社区：http://springcloud.cn/

springcloud中文网：https://springcloud.cc/

 
 
 
 
 
 

