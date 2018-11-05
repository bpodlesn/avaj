package Flyables;

import Tower.WeatherTower;

import java.io.IOException;

/**
 * Created by bpodlesn on 10/30/18.
 */
public interface Flyable {
    public void updateConditions() throws IOException;
    public void registerTower(WeatherTower weatherTower);
}
