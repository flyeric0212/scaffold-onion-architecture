package top.flyeric.domain.model.product.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.flyeric.domain.model.product.entity.Product;

public interface ProductRepository {

    Page<Product> findPagedProducts(Predicate condition, Pageable pageable);

}
