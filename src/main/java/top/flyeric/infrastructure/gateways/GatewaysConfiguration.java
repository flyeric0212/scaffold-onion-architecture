package top.flyeric.infrastructure.gateways;


import com.fasterxml.jackson.databind.ObjectMapper;

import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

import feign.Feign;
import feign.Logger;
import feign.Request;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import top.flyeric.base.feign.FeignLogger;
import top.flyeric.base.feign.IntegrationLogger;
import top.flyeric.infrastructure.gateways.weather.WeatherApiProperties;
import top.flyeric.infrastructure.gateways.weather.WeatherClient;

@Data
@Slf4j
@Configuration
public class GatewaysConfiguration {

    private final ObjectMapper objectMapper;

    @Bean
    @ConditionalOnMissingBean(name = "weatherClient")
    public WeatherClient weatherClient(WeatherApiProperties apiProperties) {
        return buildFeignClient(WeatherClient.class, apiProperties, Logger.Level.BASIC, false);
    }

    private <T> T buildFeignClient(Class<T> clazz,
                                   ApiProperties apiProperties,
                                   Logger.Level logLevel,
                                   Boolean isIntgLogger) {
        Logger logger = Boolean.TRUE.equals(isIntgLogger) ? new IntegrationLogger(LoggerFactory.getLogger(clazz))
                : new FeignLogger(LoggerFactory.getLogger(clazz));

        return Feign.builder()
                .encoder(new JacksonEncoder(objectMapper))
                .decoder(new JacksonDecoder(objectMapper))
                .logger(logger)
                .logLevel(logLevel)
                .contract(new SpringMvcContract())
                .options(new Request.Options(
                        apiProperties.getConnectTimeout(), TimeUnit.MILLISECONDS,
                        apiProperties.getReadTimeout(), TimeUnit.MILLISECONDS,
                        true))
                .target(clazz, apiProperties.getHost());
    }
}
