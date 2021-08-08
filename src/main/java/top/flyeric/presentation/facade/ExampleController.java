package top.flyeric.presentation.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

import io.swagger.annotations.ApiOperation;
import top.flyeric.application.service.ProductAppService;
import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.presentation.vo.ProductResponse;
import top.flyeric.presentation.vo.QueryProductRequest;

import javax.validation.Valid;

import static top.flyeric.presentation.assembler.ProductVoMapper.MAPPER;

@RestController
@RequestMapping()
public class ExampleController {

    private final ProductAppService productAppService;

    public ExampleController(ProductAppService productAppService) {
        this.productAppService = productAppService;
    }

    @ApiOperation("测试Swagger API文档")
    @GetMapping("/say-hello")
    public String sayHello() {
        return "hello " + LocalDateTime.now();
    }

    @GetMapping("/test")
    public Page<ProductResponse> testApm(@SortDefault(sort = "updateTime", direction = Sort.Direction.DESC) Pageable pageable,
                                         @Valid QueryProductRequest request) {
        Page<Product> pagedProducts = productAppService.getPagedProducts(request.toPredicates(), pageable);



        return pagedProducts.map(MAPPER::toResponse);
    }
}
