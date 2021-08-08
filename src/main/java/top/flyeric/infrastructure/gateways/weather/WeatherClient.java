package top.flyeric.infrastructure.gateways.weather;

import org.springframework.web.bind.annotation.GetMapping;

import top.flyeric.infrastructure.gateways.weather.model.CityWeatherResponse;

public interface WeatherClient {

    @GetMapping
    CityWeatherResponse getTodayCityWeather();

}
