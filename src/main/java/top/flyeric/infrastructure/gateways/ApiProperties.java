package top.flyeric.infrastructure.gateways;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class ApiProperties {

    private String host;
    private long connectTimeout = 5000;
    private long readTimeout = 5000;
}
