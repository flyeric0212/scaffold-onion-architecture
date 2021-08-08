package top.flyeric.presentation.vo;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class ProductResponse {

    private String id;

    private String name;

    private String desc;

    private BigDecimal price;

}
