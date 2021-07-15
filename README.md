## 初始化

```
gradle init

gradle wrapper --gradle-version 7.1.1

```

## 技术栈

- JDK 11
- Gradle 7.1.1
- Spring Boot 2.5.2
- Database Access - Spring Data JPA
- Database Migration - Flyway


## 架构和代码结构
本项目代码结构参考 Onion Architecture，参考以下介绍
* [The Onion Architecture : part 1](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)
* [The Onion Architecture : part 2](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-2/)
* [The Onion Architecture : part 3](https://jeffreypalermo.com/2008/08/the-onion-architecture-part-3/)
* [The Onion Architecture : part 4](https://jeffreypalermo.com/2013/08/onion-architecture-part-4-after-four-years/)

测试策略和结构参考
* [Testing Strategies in a Microservices Architecture](https://martinfowler.com/articles/microservice-testing)
* [Unit and Integration Tests for RestControllers in Spring Boot](https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests)


## 本地构建

### 启动依赖
```
docker-compose up -d
```

### 本地
```
./gradlew clean build 
```

### 本地运行
```
./gradlew bootRun
```

## 分层结构

![image-20210715233358840](https://pic-bed-1256249917.cos.ap-chengdu.myqcloud.com/uPic/image-20210715233358840.png)



调用关系如下：

Presentation --> Application --> Domain

Common可以被任意package调用

Infrastructure可以调用任何package

主要是为了隔离代码的传播，实现高内聚低耦合。
