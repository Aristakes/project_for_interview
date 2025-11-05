package org.as.mrutik.project_for_interview.controller;

import org.as.mrutik.project_for_interview.beans.CustomWeatherResponse;
import org.as.mrutik.project_for_interview.service.WeatherService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/weather")
public class WeatherController {


    private final WeatherService weatherService;

    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }


    @GetMapping("/city")
    public Mono<ResponseEntity<CustomWeatherResponse>> getWeatherByCity(
          @RequestParam("city") String city
    )
    {
        return weatherService.getWeatherByCity(city)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());

    }

}
