package top.flyeric.domain.model.product.entity;

import lombok.Getter;
import lombok.Setter;
import top.flyeric.domain.shared.Entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class Product implements Entity<Product> {

    private String id;

    private String name;

    private String desc;

    private BigDecimal price;

    private LocalDateTime createTime;

    private LocalDateTime updateTime;

}
