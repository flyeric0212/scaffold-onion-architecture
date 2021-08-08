package top.flyeric.common.exception;

import top.flyeric.base.exception.AppException;
import top.flyeric.base.exception.common.IExceptionCode;

public class WeatherException extends AppException {
    public WeatherException(IExceptionCode code, String message) {
        super(code, message);
    }
}
