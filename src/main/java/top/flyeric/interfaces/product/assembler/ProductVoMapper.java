package top.flyeric.interfaces.product.assembler;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import top.flyeric.domain.model.product.entity.Product;
import top.flyeric.interfaces.product.vo.ProductResponse;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductVoMapper {

    ProductVoMapper MAPPER = Mappers.getMapper(ProductVoMapper.class);

    ProductResponse toResponse(Product product);
}
