package top.flyeric.domain.service;

import com.querydsl.core.types.Predicate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.domain.model.product.repository.ProductRepository;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<Product> getPagedProducts(Predicate condition, Pageable pageable) {
        return repository.findPagedProducts(condition, pageable);
    }
}
