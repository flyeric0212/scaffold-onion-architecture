package top.flyeric.infrastructure.gateways.weather.adapter;

import static top.flyeric.common.exception.WeatherExceptionCode.WEATHER_API_CALL_FAILED;

import org.springframework.stereotype.Service;

import top.flyeric.common.exception.WeatherException;
import top.flyeric.domain.model.weather.adapter.WeatherAdapter;
import top.flyeric.domain.model.weather.entity.Weather;
import top.flyeric.infrastructure.gateways.weather.WeatherClient;
import top.flyeric.infrastructure.gateways.weather.model.CityWeatherResponse;

@Service
public class WeatherAdapterImpl implements WeatherAdapter {

    private final WeatherClient weatherClient;

    public WeatherAdapterImpl(WeatherClient weatherClient) {
        this.weatherClient = weatherClient;
    }

    @Override
    public Weather getTodayWeather() {
        CityWeatherResponse response;
        try {
            response = weatherClient.getTodayCityWeather();
        } catch (Exception e) {
            throw new WeatherException(WEATHER_API_CALL_FAILED, "weather api call failed");
        }
        validateWeatherResponse(response);

        CityWeatherResponse.CityWeatherData data = response.getData();

        return Weather.builder()
                .temperature(data.getTemperature())
                .humidity(data.getHumidity())
                .pm25(data.getPm25())
                .quality(data.getQuality())
                .aqi(data.getForecast().get(0).getAqi())
                .build();
    }

    private void validateWeatherResponse(CityWeatherResponse response) {
        if (!response.isSuccess()) {
            throw new WeatherException(WEATHER_API_CALL_FAILED, "weather api status code is not 200");
        }
    }
}
