# microservicecloud-api（公共子模块Module）
## 1、新建microservicecloud-api
创建完成后请回到父工程查看pom文件变化
## 2、修改POM
```xml
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
  xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <modelVersion>4.0.0</modelVersion>
 
  <parent><!-- 子类里面显示声明才能有明确的继承表现，无意外就是父类的默认版本否则自己定义 -->
   <groupId>com.atguigu.springcloud</groupId>
   <artifactId>microservicecloud</artifactId>
   <version>0.0.1-SNAPSHOT</version>
  </parent>
 
  <artifactId>microservicecloud-api</artifactId><!-- 当前Module我自己叫什么名字 -->
 
  <dependencies><!-- 当前Module需要用到的jar包，按自己需求添加，如果父类已经包含了，可以不用写版本号 -->
   <dependency>
     <groupId>org.projectlombok</groupId>
     <artifactId>lombok</artifactId>
   </dependency>
  </dependencies>
</project>
```
## 3、新建部门Entity且配合lombok使用
```java
 
package com.wsh.springcloud.entities;
 
import java.io.Serializable;
 
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
 
@SuppressWarnings("serial")
@NoArgsConstructor
@Data
@Accessors(chain=true)
public class Dept implements Serializable //必须序列化
{
  private Long  deptno;   //主键
  private String  dname;   //部门名称
  private String  db_source;//来自那个数据库，因为微服务架构可以一个服务对应一个数据库，同一个信息被存储到不同数据库
  
  public Dept(String dname)
  {
   super();
   this.dname = dname;
  }
}
```
## 4、mvn clean install后给其它模块引用，达到通用目的。
也即需要用到部门实体的话，不用每个工程都定义一份，直接引用本模块即可。