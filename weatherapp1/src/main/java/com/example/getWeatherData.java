package com.example;

import java.util.*;
import java.net.*;
import java.nio.charset.StandardCharsets;

import org.json.simple.parser.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class getWeatherData {

    private static String APIKey1 = "38da3800bb2c7aa2137b87590e81e874";

    public static Coordinates returnCoords(String cityName, String stateCode, String countryCode) {

        Coordinates coords = new Coordinates(cityName, 0, 0);
        // Here we grab the geo-coded lattitude and longitude of the City so we can pass
        // the lon/lat into the next function
        // to return the current weather
        try {
            // We must encode the cityName to accomidate for whitespace
            String cityNameUrlEncoded = URLEncoder.encode(cityName, StandardCharsets.UTF_8.toString());
            String url = "http://api.openweathermap.org/geo/1.0/direct?q=" + cityNameUrlEncoded + "," + stateCode + ","
                    + countryCode + "&limit=1&appid=" + APIKey1;
            // Using the URL lib we connect to the API to capture its returned JSON data
            URL openWeather = new URI(url).toURL();
            HttpURLConnection conn = (HttpURLConnection) openWeather.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("incorrect response code : " + responseCode);
            } else {
                String inline = "";
                Scanner scansJsonOutput = new Scanner(openWeather.openStream());
                // We open a input stream from the URL/scan/parse the data line by line storing
                // it as text data in JSON format
                while (scansJsonOutput.hasNext()) {
                    inline += scansJsonOutput.nextLine();
                    // System.out.println(inline);
                }
                scansJsonOutput.close();
                // JSON parser then takes the text data in json format and parses it into a
                // JSONObj for us to select lon/lat coords
                JSONParser parse = new JSONParser();
                JSONArray d_obj = (JSONArray) parse.parse(inline);
                // since the parser returns an array object we must select an index within the
                // array to cast the array object to a JSONObject
                // We use position 0 as a catch all to grab the entire JSONArray
                JSONObject j_obj = (JSONObject) d_obj.get(0);
                double lattitude = (double) j_obj.get("lat");
                double longitude = (double) j_obj.get("lon");
                // System.out.println(j_obj);
                // System.out.println(cityName + " : (" + lattitude + ", " + longitude + ")");
                coords.lat = lattitude;
                coords.lon = longitude;

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());

        }

        return coords;
    }

    public static CurrentWeather returnCurrentWeather(Double lat, Double lon, String cityName) {

        String urlWeatherCall = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat.toString() + "&lon="
                + lon.toString() + "&appid="
                + APIKey1;
        System.out.println(urlWeatherCall);

        try {
            URL openWeather = new URI(urlWeatherCall).toURL();
            HttpURLConnection conn = (HttpURLConnection) openWeather.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            int responseCode = conn.getResponseCode();
            if (responseCode != 200) {
                System.out.println("incorrect response code : " + responseCode);
            } else {
                String inline = "";
                Scanner scansJsonOutput = new Scanner(openWeather.openStream());

                while (scansJsonOutput.hasNext()) {
                    inline += scansJsonOutput.nextLine();
                    // System.out.println(inline);
                }
                scansJsonOutput.close();

                JSONParser parse = new JSONParser();
                JSONObject d_obj = (JSONObject) parse.parse(inline);
                JSONObject main_obj = (JSONObject) d_obj.get("main");
                JSONObject wind_obj = (JSONObject) d_obj.get("wind");
                JSONObject sys_obj = (JSONObject) d_obj.get("sys");
                JSONArray weather_obj = (JSONArray) d_obj.get("weather");
                JSONObject weather_obj2 = (JSONObject) weather_obj.get(0);
                // After parsing the JSON text data we select the current weather headers to
                // store them into
                // the CurrentWeather datastructure
                double temp_obj = (double) main_obj.get("temp");
                double feelsLike = (double) main_obj.get("feels_like");
                double tempMin = (double) main_obj.get("temp_min");
                double tempMax = (double) main_obj.get("temp_max");
                double windSpeed;
                try {
                    windSpeed = (double) wind_obj.get("speed");
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    windSpeed = 0.0;
                }

                Long windDir = (Long) wind_obj.get("deg");
                Long currTime = (Long) d_obj.get("dt");
                // System.out.println(main_obj);
                Long sunrise = (Long) sys_obj.get("sunrise");
                Long sunset = (Long) sys_obj.get("sunset");
                Long pressure = (Long) main_obj.get("pressure");
                Long humidity = (Long) main_obj.get("humidity");
                Long visibility = (Long) d_obj.get("visibility");
                String description = (String) weather_obj2.get("description");
                // System.out.println(feelsLike);
                // System.out.println(sunrise);

                Date currentTime = new Date(currTime);
                Date sunRise = new Date(sunrise);
                Date sunSet = new Date(sunset);
                CurrentWeather currWeatherObj = new CurrentWeather(cityName, currentTime, sunRise, sunSet, temp_obj,
                        tempMax, tempMin, feelsLike, pressure, humidity, description, visibility, windSpeed, windDir);

                return currWeatherObj;

            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        CurrentWeather nullObj = new CurrentWeather(cityName, null, null, null, 0, 0, 0, 0, null, null, urlWeatherCall,
                null, null, null);

        return nullObj;
    }

    static class Coordinates {
        // We create a simple datastructure to store the coordinates and cityname
        String cityName;
        double lat;
        double lon;

        public Coordinates(String cityName, double lat, double lon) {
            this.cityName = cityName;
            this.lat = lat;
            this.lon = lon;
        }
    }

}
