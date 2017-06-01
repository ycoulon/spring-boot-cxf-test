package io.github.ycoulon.springbootcxftest.endpoint;

import de.codecentric.namespace.weatherservice.WeatherException;
import de.codecentric.namespace.weatherservice.WeatherService;
import de.codecentric.namespace.weatherservice.general.ForecastRequest;
import de.codecentric.namespace.weatherservice.general.ForecastReturn;
import de.codecentric.namespace.weatherservice.general.WeatherInformationReturn;
import de.codecentric.namespace.weatherservice.general.WeatherReturn;

/**
 * Created by ycoulon on 01/06/2017.
 */
public class WeatherServiceEndpoint implements WeatherService {
    @Override
    public WeatherInformationReturn getWeatherInformation(String zip) throws WeatherException {
        return null;
    }

    @Override
    public ForecastReturn getCityForecastByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return null;
    }

    @Override
    public WeatherReturn getCityWeatherByZIP(ForecastRequest forecastRequest) throws WeatherException {
        return null;
    }
}
