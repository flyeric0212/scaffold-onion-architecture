package top.flyeric.userinterface.vo;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private String id;

    private String name;

    private String desc;

    private BigDecimal price;

}
