package top.flyeric.presentation.vo;

import com.google.common.collect.ImmutableList;
import com.querydsl.core.types.Predicate;

import java.util.List;
import java.util.Optional;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;
import top.flyeric.base.jpa.QueryFilter;

@Getter
@Setter
@ApiModel("查询Product列表")
public class QueryProductRequest implements QueryFilter {

    @ApiModelProperty(value = "商品名称")
    private String name;

    // TODO: need refactor
    @Override
    public List<Optional<Predicate>> predicates() {
        return ImmutableList.of();
        // return ImmutableList.<Optional<Predicate>>builder()
        // .add(Optional.ofNullable(name).map(QProductPo.productPo.name::containsIgnoreCase))
        // .build();
    }
}
