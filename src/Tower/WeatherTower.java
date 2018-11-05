package Tower;

import Flyables.Coordinates;
import avaj.WeatherProvider;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class WeatherTower extends Tower {

    public String getWeather(Coordinates coordinates){
        //algo for weather
        return (WeatherProvider.getWeatherProvider().getCurrentWeather(coordinates));
    }

    void changeWeather(){
        conditionsChanged();
    }
}
