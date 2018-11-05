package avaj;

import Flyables.Coordinates;

import java.util.Random;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class WeatherProvider {
    private static WeatherProvider weatherProvider;
    private String[] weather = {"SUN", "SNOW", "RAIN", "FOG"};

    private WeatherProvider(){}

    public static WeatherProvider getWeatherProvider(){
        if (weatherProvider == null) {
            weatherProvider = new WeatherProvider();
        }
        return weatherProvider;
    }

    public String getCurrentWeather(Coordinates coordinates){
        return (weather[(coordinates.getHeight() + coordinates.getLatitude() + coordinates.getLongtitude()) % 4]);
    }
}
