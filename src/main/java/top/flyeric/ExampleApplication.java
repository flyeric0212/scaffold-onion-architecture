package top.flyeric;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class ExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleApplication.class, args);
    }

    // @Scheduled(fixedRate = 5000L)
    // public void sayHelloLog() {
    // log.info("hello, {}", LocalDateTime.now());
    // }
    //
    // @Scheduled(fixedRate = 10000L)
    // public void throwExceptionLog() {
    // throw notFoundException(String.format("not found exception, %s", LocalDateTime.now())).get();
    // }

}
