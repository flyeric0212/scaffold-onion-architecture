# scaffold-clean-architecture

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
本项目代码结构参考 Onion Architecture，参考以下介绍:
* [The Onion Architecture : part 1](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-1/)
* [The Onion Architecture : part 2](https://jeffreypalermo.com/2008/07/the-onion-architecture-part-2/)
* [The Onion Architecture : part 3](https://jeffreypalermo.com/2008/08/the-onion-architecture-part-3/)
* [The Onion Architecture : part 4](https://jeffreypalermo.com/2013/08/onion-architecture-part-4-after-four-years/)

* [ArchUnit Onion Architecture](https://www.archunit.org/userguide/html/000_Index.html#_architectures)

Onion Architecture 架构图：

<img src="https://pic-bed-1256249917.cos.ap-chengdu.myqcloud.com/uPic/4436217-kolka-20210722231755720-20210723125016960.png" alt="img" style="zoom: 80%;" />

### 分层结构

![Clean Architecture](https://pic-bed-1256249917.cos.ap-chengdu.myqcloud.com/uPic/Clean%20Architecture.png)


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

### 本地
```
./gradlew clean build 

或者

./gradlew clean composeUp build composeDown
```

### 本地运行
```
./gradlew bootRun
```

### 修复代码格式
```
./gradlew spotlessApply
```

