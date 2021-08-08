package top.flyeric.infrastructure.gateways.weather.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CityWeatherResponse {

    private static final int SUCCESS_CODE = 200;

    @JsonProperty("status")
    private int status;

    @JsonProperty("data")
    private CityWeatherData data;

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class CityWeatherData {

        @JsonProperty("shidu")
        private String humidity;

        @JsonProperty("wendu")
        private String temperature;

        @JsonProperty("quality")
        private String quality;

        private Double pm25;

        @JsonProperty("forecast")
        private List<CityWeatherForecast> forecast;
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Getter
    @Setter
    public static class CityWeatherForecast {

        @JsonProperty("aqi")
        private int aqi;
    }

    public boolean isSuccess() {
        return this.status == SUCCESS_CODE;
    }
}
