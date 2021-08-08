package top.flyeric.domain.model.weather.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import top.flyeric.domain.shared.ValueObject;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Weather implements ValueObject<Weather> {

    private String temperature;

    private String humidity;

    private Double pm25;

    private int aqi;

    private String quality;

}
