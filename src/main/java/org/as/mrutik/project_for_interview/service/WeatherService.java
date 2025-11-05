package org.as.mrutik.project_for_interview.service;

import org.as.mrutik.project_for_interview.beans.CustomWeatherResponse;
import org.as.mrutik.project_for_interview.beans.Weather;
import org.as.mrutik.project_for_interview.beans.WeatherResponse;
import org.as.mrutik.project_for_interview.config.WeatherConfig;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class WeatherService {

    private final WebClient webClient;
    private final WeatherConfig weatherConfig;

    public WeatherService(WebClient.Builder webClientBuilder, WeatherConfig weatherConfig) {
        this.webClient = webClientBuilder.baseUrl(weatherConfig.getApiUrl()).build();
        this.weatherConfig = weatherConfig;
    }

    public Mono<CustomWeatherResponse> getWeatherByCity(String city) {
        String url = UriComponentsBuilder.fromHttpUrl(weatherConfig.getApiUrl())
                .queryParam("q", city)
                .queryParam("appid", weatherConfig.getApiKey())
                .queryParam("units", "metric")
                .toUriString();

        return webClient.get()
                .uri(url)
                .retrieve()
                .bodyToMono(WeatherResponse.class)
                .map(this::convertToCustomResponse);
    }



    private CustomWeatherResponse convertToCustomResponse(WeatherResponse response) {
        CustomWeatherResponse customResponse = new CustomWeatherResponse();

        if (response.getWeather() != null && !response.getWeather().isEmpty()) {
            customResponse.setWeather(response.getWeather().get(0));
        }

        customResponse.setTemperature(response.getTemperature());
        customResponse.setVisibility(response.getVisibility());
        customResponse.setWind(response.getWind());
        customResponse.setDatetime(response.getDatetime());
        customResponse.setSys(response.getSys());
        customResponse.setTimezone(response.getTimezone());
        customResponse.setName(response.getName());

        return customResponse;
    }


}
