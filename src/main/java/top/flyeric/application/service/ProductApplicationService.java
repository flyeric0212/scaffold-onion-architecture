package top.flyeric.application.service;

import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.domain.service.ProductService;

@Service
public class ProductApplicationService {

    private final ProductService productService;

    public ProductApplicationService(ProductService productService) {
        this.productService = productService;
    }

    public Page<Product> getPagedProducts(Predicate predicate, Pageable pageable) {
        return productService.getPagedProducts(predicate, pageable);
    }
}
