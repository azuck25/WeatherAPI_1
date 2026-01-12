package com.example;

import java.util.Date;

public class CurrentWeather {
    private String location;
    private Date currDate;
    private Date sunRise;
    private Date sunSet;
    private double temperature;
    private double temp_min;
    private double temp_max;
    private double feelsLike;
    private Long pressure;
    private Long humidity;
    private String condition;
    private Long visibility;
    private Double windSpeed;
    private Long windDir;

    public CurrentWeather(String location,
            Date currDate,
            Date sunRise,
            Date sunSet,
            double temperature,
            double temp_max,
            double temp_min,
            double feelsLike,
            Long pressure,
            Long humidity,
            String condition,
            Long visibility,
            Double windSpeed,
            Long windDir) {

        this.location = location;
        this.currDate = currDate;
        this.sunRise = sunRise;
        this.sunSet = sunSet;
        this.temperature = temperature;
        this.temp_max = temp_max;
        this.temp_min = temp_min;
        this.feelsLike = feelsLike;
        this.pressure = pressure;
        this.humidity = humidity;
        this.condition = condition;
        this.visibility = visibility;
        this.windSpeed = windSpeed;
        this.windDir = windDir;
    }

    public String getLocation() {
        return location;
    }

    public Date getCurrDate() {
        return currDate;
    }

    public Double convertTemp(double t) {
        double absolute = 273.15;
        double adjustment = (5 / 9);
        double fahrenheitConst = 32.00;
        double temp = (t - absolute) * adjustment + fahrenheitConst;
        return temp;
    }

    public Double getTempMax() {
        return convertTemp(temp_max);
    }

    public Double getTempMin() {
        return convertTemp(temp_min);
    }

    public Date getsunRise() {
        return sunRise;
    }

    public Date getsunSet() {
        return sunSet;
    }

    public Double getTemperature() {
        return convertTemp(temperature);
    }

    public Long getHumidity() {
        return humidity;
    }

    public String getCondition() {
        return condition;
    }

    public double getFeelsLike() {
        return feelsLike;
    }

    public Long getPressure() {
        return pressure;
    }

    public Long getVisibility() {
        return visibility;
    }

    public Double getWindSpeed() {
        return windSpeed;
    }

    public Long getWindDir() {
        return windDir;
    }

    @Override
    public String toString() {
        return "CurrentWeather{" +
                "location='" + location + '\'' +
                ", temperature=" + temperature +
                ", humidity=" + humidity +
                ", condition='" + condition + '\'' +
                '}';
    }
}