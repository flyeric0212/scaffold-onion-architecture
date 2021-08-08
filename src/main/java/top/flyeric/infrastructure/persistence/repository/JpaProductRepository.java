package top.flyeric.infrastructure.persistence.repository;

import com.querydsl.core.types.Predicate;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import top.flyeric.base.jpa.JpaAndQueryDslExecutor;
import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.domain.model.product.repository.ProductRepository;
import top.flyeric.infrastructure.persistence.entity.ProductPo;

import static top.flyeric.infrastructure.persistence.assembler.ProductDataMapper.MAPPER;

public interface JpaProductRepository extends ProductRepository, JpaAndQueryDslExecutor<ProductPo, String> {

    @Override
    default Page<Product> findPagedProducts(Predicate condition, Pageable pageable) {
        return this.findAll(condition, pageable).map(MAPPER::toDo);
    }


}
