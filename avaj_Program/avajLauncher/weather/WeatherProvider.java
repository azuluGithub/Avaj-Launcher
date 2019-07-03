package avajLauncher.weather;

import avajLauncher.aircraft.Coordinates;

import java.util.Random;

public class WeatherProvider {

    private static WeatherProvider weatherProvider = null;
    private String[] weather = {"RAIN", "FOG", "SUN", "SNOW"};

    private WeatherProvider() {}

    public static WeatherProvider getProvider() {
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates) {
        int longitude = coordinates.getLongitude();
        int latitude = coordinates.getLatitude();
        int height = coordinates.getHeight();
        int lon, lat, hgt;
        Random rand = new Random();
        int n = 1 + rand.nextInt(60);

        if (longitude >= n) {
            lon = 1;
        } else {
            lon = 0;
        }
        if (latitude >= n) {
            lat = 1;
        } else {
            lat = 0;
        }
        if (height >= n) {
            hgt = 1;
        } else {
            hgt = 0;
        }
        return weather[lon + lat + hgt];
    }

}


