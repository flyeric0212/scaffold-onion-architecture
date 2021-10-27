# 洋葱架构脚手架项目

- [洋葱架构脚手架项目](#洋葱架构脚手架项目)
  - [技术栈](#技术栈)
  - [架构说明](#架构说明)
  - [分层结构说明](#分层结构说明)
  - [本地构建](#本地构建)
    - [启动依赖](#启动依赖)
    - [编译](#编译)
    - [运行](#运行)
    - [修复代码格式](#修复代码格式)
  - [其他](#其他)
    - [CI流水线](#CI流水线)
    - [Swagger访问地址](#Swagger访问地址)

## 技术栈

- JDK 11
- Gradle 7.2
- Spring Boot 2.5.6
- Database Access - Spring Data JPA
- Database Migration - Flyway
- Integration Test - Docker Compose

## 架构说明
本项目代码结构参考 Onion Architecture，参考以下介绍:
* [The Onion Architecture : part 1](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)
* [The Onion Architecture : part 2](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-2/)
* [The Onion Architecture : part 3](https://jeffreypalermo.com/2008/08/the-onion-architecture-part-3/)
* [The Onion Architecture : part 4](https://jeffreypalermo.com/2013/08/onion-architecture-part-4-after-four-years/)

* [ArchUnit Onion Architecture](https://www.archunit.org/userguide/html/000_Index.html#_architectures)

## 分层结构说明

![image-20211013181013502](https://pic-bed-1256249917.cos.ap-chengdu.myqcloud.com/uPic/image-20211013181013502.png)

package分层调用关系如下：
```
Architectures.LayeredArchitecture layeredArchitectureDelegate = layeredArchitecture()
        .layer(DOMAIN_MODEL_LAYER).definedBy(domainModelPackageIdentifiers)
        .layer(DOMAIN_SERVICE_LAYER).definedBy(domainServicePackageIdentifiers)
        .layer(APPLICATION_SERVICE_LAYER).definedBy(applicationPackageIdentifiers)
        .layer(ADAPTER_LAYER).definedBy(concatenateAll(adapterPackageIdentifiers.values()))
        .whereLayer(DOMAIN_MODEL_LAYER).mayOnlyBeAccessedByLayers(DOMAIN_SERVICE_LAYER, APPLICATION_SERVICE_LAYER, ADAPTER_LAYER)
        .whereLayer(DOMAIN_SERVICE_LAYER).mayOnlyBeAccessedByLayers(APPLICATION_SERVICE_LAYER, ADAPTER_LAYER)
        .whereLayer(APPLICATION_SERVICE_LAYER).mayOnlyBeAccessedByLayers(ADAPTER_LAYER)
        .withOptionalLayers(optionalLayers);    
```
主要是为了隔离代码的传播，实现高内聚低耦合。

测试策略和结构参考:
* [Testing Strategies in a Microservices Architecture](https://martinfowler.com/articles/microservice-testing)
* [Unit and Integration Tests for RestControllers in Spring Boot](https://thepracticaldeveloper.com/2017/07/31/guide-spring-boot-controller-tests)

## 本地构建

### 启动依赖
```
docker-compose up -d
```
也可以使用命令：
```
./gradlew composeUp
./gradlew composeDown 
```

### 编译
```
./gradlew clean build 

或者

./gradlew clean composeUp build composeDown
```

### 运行
```
./gradlew bootRun
```

### 修复代码格式
```
./gradlew spotlessApply
```

## 其他

### CI流水线
参考.github/workflows下的ci.yaml文件

### Swagger访问地址
本地启动后，访问如下地址：
http://localhost:8080/swagger-ui/