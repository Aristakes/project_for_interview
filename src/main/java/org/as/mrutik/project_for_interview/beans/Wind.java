package org.as.mrutik.project_for_interview.beans;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Wind {

    @JsonProperty("speed")
    private Double speed;


    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }
}
