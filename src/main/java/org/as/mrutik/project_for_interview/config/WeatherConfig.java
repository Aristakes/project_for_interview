package org.as.mrutik.project_for_interview.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WeatherConfig {

    @Value("${openweather.api.key}")
    private String apiKey;

    @Value("${openweather.api.url:https://api.openweathermap.org/data/2.5/weather}")
    private String apiUrl;

    public String getApiKey() {
        return apiKey;
    }

    public String getApiUrl() {
        return apiUrl;
    }
}
