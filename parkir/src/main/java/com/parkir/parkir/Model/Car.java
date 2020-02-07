package com.parkir.parkir.Model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Car
 */
public class Car {

    private String color;
    private CarType type;
    private String regNumber;

    @JsonProperty("color")
    public String getColor() {
        return color;
    }
    
    @JsonProperty("type")
    public CarType getType() {
        return type;
    }

    @JsonProperty("regNumber")
    public String getRegNumber() {
        return regNumber;
    }

    public Car(String color, CarType type, String regNumber) {
        this.color = color;
        this.type = type;
        this.regNumber = regNumber;
    }
}