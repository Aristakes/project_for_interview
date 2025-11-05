package org.as.mrutik.project_for_interview.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Temperature {

    @JsonProperty("temp")
    private Double temp;

    @JsonProperty("feels_like")
    private Double feelsLike;

    public Double getTemp() {
        return temp;
    }

    public void setTemp(Double temp) {
        this.temp = temp;
    }

    public Double getFeelsLike() {
        return feelsLike;
    }

    public void setFeelsLike(Double feelsLike) {
        this.feelsLike = feelsLike;
    }
}
