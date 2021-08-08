package top.flyeric.common.exception;

import lombok.Getter;
import top.flyeric.base.exception.common.IExceptionCode;

@Getter
public enum WeatherExceptionCode implements IExceptionCode {
    WEATHER_API_CALL_FAILED("天气接口调用失败", "weather api call failed");

    String zhMsg;
    String enMsg;

    WeatherExceptionCode(String zhMsg, String enMsg) {
        this.zhMsg = zhMsg;
        this.enMsg = enMsg;
    }

    @Override
    public String getValue() {
        return this.name();
    }


}
