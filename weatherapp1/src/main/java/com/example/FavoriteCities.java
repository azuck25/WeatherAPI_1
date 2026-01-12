package com.example;

import java.util.ArrayList;
import java.beans.Visibility;
import java.util.*;

public class FavoriteCities {
    private static final Integer listLimit = 3;

    private List<CurrentWeather> weatherList = new ArrayList<CurrentWeather>(listLimit);

    public FavoriteCities(List<CurrentWeather> weatherList) {
        this.weatherList = weatherList;
    }

    public void addWeatherData(CurrentWeather weatherData) {
        if (weatherList.size() != listLimit) {
            weatherList.add(weatherData);
            System.out.println("added" + " size " + weatherList.size());
        } else {
            System.out.println("Exceeds favorite list size.");
        }
    }

    public void removeWeatherData() {
        System.out.println("Choose index to remove.");
        System.out.println("Listing options...");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < weatherList.size(); i++) {
            CurrentWeather w = weatherList.get(i);
            System.out.println("Index : " + i + " : location : " + w.getLocation());
        }

        int index = scn.nextInt();
        if (weatherList.size() >= 0) {
            weatherList.remove(index);
        } else {
            System.out.println("List is empty...");
        }
        scn.close();
    }

    public void displayWeatherData() {
        System.out.println("Listing options to display...");
        Scanner scn = new Scanner(System.in);
        for (int i = 0; i < weatherList.size(); i++) {
            CurrentWeather w = weatherList.get(i);
            System.out.println("Index : " + i + " : location : " + w.getLocation());
        }
        System.out.print("Select index to display : ");
        int index = scn.nextInt();
        // scn.close();
        CurrentWeather choosenCity = weatherList.get(index);
        System.out.println("Current Weather Conditions");
        System.out.println("Location : " + choosenCity.getLocation());
        System.out.println("Conditions : " + choosenCity.getCondition());
        System.out.println("Temperature : " + choosenCity.getTemperature());
        System.out.println("Feels Like : " + choosenCity.getFeelsLike());
        System.out.println("Max Temp : " + choosenCity.getTempMax());
        System.out.println("Min Temp : " + choosenCity.getTempMin());
        System.out.println("Atmospheric Pressure : " + choosenCity.getPressure());
        System.out.println("Humidity : " + choosenCity.getHumidity());
        System.out.println("Visibility : " + choosenCity.getVisibility());
        System.out.println("Wind Speed : " + choosenCity.getWindSpeed());
        System.out.println("Wind Direction (Degrees) : " + choosenCity.getWindDir());

    }

}