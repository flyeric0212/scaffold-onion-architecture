package top.flyeric.infrastructure.persistence.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.infrastructure.persistence.entity.ProductPo;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductDataMapper {

    ProductDataMapper MAPPER = Mappers.getMapper(ProductDataMapper.class);

    Product toDo(ProductPo productPo);

    ProductPo toPo(Product product);

}
