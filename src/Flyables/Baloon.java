package Flyables;

import Exceptions.Fails;
import Tower.Main;
import Tower.WeatherTower;

import java.io.IOException;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class Baloon extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Baloon(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude() + 2, coordinates.getLatitude(), coordinates.getHeight() + 4);
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Tupo Sun, ti krutoi pacan!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 5);
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Na ulice rain, na dushe pain!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 3);
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Seychas Fog, na polu Frog\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 15);
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Zdes' tupo John Snow right now!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.coordinates.getHeight() < 1){
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Ya pal!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                this.weatherTower.unregister(this);
                Main.Writer.writer.write("Tower says: " + getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " unregistered from weather tower.\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void registerTower(WeatherTower weatherTower){
        try {
            if (this.coordinates.getHeight() < 1) {
                throw new Fails("Tower says: " + getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " cant be registered to weather tower.\n");
            }
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            Main.Writer.writer.write("Tower says: " + getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
        } catch (Fails ex) {
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
