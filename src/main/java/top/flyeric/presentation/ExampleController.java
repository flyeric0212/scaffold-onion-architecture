package top.flyeric.presentation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping()
public class ExampleController {

    @ApiOperation("测试Swagger API文档")
    @GetMapping("/say-hello")
    public String sayHello() {
        return "hello " + LocalDateTime.now();
    }
}
