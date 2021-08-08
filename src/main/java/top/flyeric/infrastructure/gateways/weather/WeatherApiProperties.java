package top.flyeric.infrastructure.gateways.weather;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;
import top.flyeric.infrastructure.gateways.ApiProperties;

@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "gateways.weather")
public class WeatherApiProperties extends ApiProperties {
}
