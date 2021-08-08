package top.flyeric.infrastructure.gateways.weather.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WeatherModel {

    private String temperature;

    private String humidity;

    private Double pm25;

}
