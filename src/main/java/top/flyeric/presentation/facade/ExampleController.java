package top.flyeric.presentation.facade;



import static top.flyeric.presentation.assembler.ProductVoMapper.MAPPER;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

import javax.validation.Valid;

import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import top.flyeric.application.service.ProductAppService;
import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.domain.model.weather.adapter.WeatherAdapter;
import top.flyeric.domain.model.weather.entity.Weather;
import top.flyeric.presentation.vo.ProductResponse;
import top.flyeric.presentation.vo.QueryProductRequest;

@Slf4j
@RestController
@RequestMapping()
public class ExampleController {

    private final ProductAppService productAppService;
    private final StringRedisTemplate stringRedisTemplate;
    private final ObjectMapper objectMapper;
    private final WeatherAdapter weatherAdapter;

    public ExampleController(ProductAppService productAppService,
                             StringRedisTemplate stringRedisTemplate,
                             ObjectMapper objectMapper,
                             WeatherAdapter weatherAdapter) {
        this.productAppService = productAppService;
        this.stringRedisTemplate = stringRedisTemplate;
        this.objectMapper = objectMapper;
        this.weatherAdapter = weatherAdapter;
    }


    @ApiOperation("测试Swagger API文档")
    @GetMapping("/say-hello")
    public String sayHello() {
        return "hello " + LocalDateTime.now();
    }

    @GetMapping("/test")
    public Page<ProductResponse> testApm(@SortDefault(
            sort = "updateTime", direction = Sort.Direction.DESC) Pageable pageable,
                                         @Valid QueryProductRequest request) throws JsonProcessingException {
        // test db
        Page<Product> pagedProducts = productAppService.getPagedProducts(request.toPredicates(),
                pageable);

        // test redis
        stringRedisTemplate.opsForValue().set("products",
                objectMapper.writeValueAsString(pagedProducts.getContent()), 1, TimeUnit.DAYS);

        // test third gateway
        Weather todayWeather = weatherAdapter.getTodayWeather();
        log.info("today weather: {}", todayWeather);

        return pagedProducts.map(MAPPER::toResponse);
    }
}
