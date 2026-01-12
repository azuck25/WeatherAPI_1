package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.getWeatherData.Coordinates;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello world!");
        Coordinates coords_1;
        boolean controlLoop = false;
        CurrentWeather weather_obj;
        List<CurrentWeather> weatherList = new ArrayList<CurrentWeather>();
        FavoriteCities favCities = new FavoriteCities(weatherList);
        while (!controlLoop) {
            Scanner scnner = new Scanner(System.in);
            String cityName, stateCode, countryCode;

            System.out.println("\n===== Weather Application Menu =====");
            System.out.println("1. Add a city to favorites");
            System.out.println("2. Remove a city from favorites");
            System.out.println("3. Display favorite city weather");
            System.out.println("4. Display weather for any city");
            System.out.println("5. Exit");
            System.out.print("Select an option (1-5): ");
            int option = scnner.nextInt();

            scnner.nextLine();

            switch (option) {
                // Add to the list
                case 1:
                    System.out.println(
                            "To add a city to your favorites fill out the following fields -> (City Name, State Code, Country Code)");
                    System.out.print("City Name : ");
                    cityName = scnner.nextLine();
                    System.out.print("State Code : ");
                    stateCode = scnner.nextLine();
                    System.out.print("Country Code : ");
                    countryCode = scnner.nextLine();
                    coords_1 = getWeatherData.returnCoords(cityName, stateCode, countryCode);
                    weather_obj = getWeatherData.returnCurrentWeather(coords_1.lat, coords_1.lon, cityName);
                    favCities.addWeatherData(weather_obj);
                    break;
                // Remove from the list
                case 2:
                    favCities.removeWeatherData();
                    break;
                // Display city weather data of a favorite
                case 3:
                    favCities.displayWeatherData();
                    break;
                // Display city weather data of any city
                case 4:
                    System.out.println(
                            "To display a city's weather data to your favorites fill out the following fields -> (City Name, State Code, Country Code)");
                    System.out.print("City Name : ");
                    cityName = scnner.nextLine();
                    System.out.print("State Code : ");
                    stateCode = scnner.nextLine();
                    System.out.print("Country Code : ");
                    countryCode = scnner.nextLine();
                    coords_1 = getWeatherData.returnCoords(cityName, stateCode, countryCode);
                    weather_obj = getWeatherData.returnCurrentWeather(coords_1.lat, coords_1.lon, cityName);
                    System.out.println("Current Weather Conditions");
                    System.out.println("Location : " + weather_obj.getLocation());
                    System.out.println("Conditions : " + weather_obj.getCondition());
                    System.out.println("Temperature : " + weather_obj.getTemperature());
                    System.out.println("Feels Like : " + weather_obj.getFeelsLike());
                    System.out.println("Max Temp : " + weather_obj.getTempMax());
                    System.out.println("Min Temp : " + weather_obj.getTempMin());
                    System.out.println("Atmospheric Pressure : " + weather_obj.getPressure());
                    System.out.println("Humidity : " + weather_obj.getHumidity());
                    System.out.println("Visibility : " + weather_obj.getVisibility());
                    System.out.println("Wind Speed : " + weather_obj.getWindSpeed());
                    System.out.println("Wind Direction (Degrees) : " + weather_obj.getWindDir());
                    break;
                case 5:
                    controlLoop = true;
                    scnner.close();
                    break;
                default:
                    System.out.println("Incorrect Option try again.");
                    break;
            }
        }

    }
}