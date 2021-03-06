package Flyables;

import Exceptions.Fails;
import Tower.Main;
import Tower.WeatherTower;

import java.io.IOException;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class Helicopter extends Aircraft implements Flyable {
    private WeatherTower weatherTower;

    Helicopter(String name, Coordinates coordinates){
        super(name, coordinates);
    }

    public void updateConditions(){
        String weather = weatherTower.getWeather(coordinates);
        if (weather.equals("SUN")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude() + 10, coordinates.getLatitude(), coordinates.getHeight() + 2);
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Solnce tupo slepit HELIKOPTERA\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (weather.equals("RAIN")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude() + 5, coordinates.getLatitude(), coordinates.getHeight());
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Helicopter i rain, letit Queen Of Pain!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (weather.equals("FOG")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude() + 1, coordinates.getLatitude() + 1, coordinates.getHeight());
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": V golove moey tumani-mani!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (weather.equals("SNOW")) {
            this.coordinates = new Coordinates(coordinates.getLongtitude(), coordinates.getLatitude(), coordinates.getHeight() - 12);
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Tupo Frozen Throne kakoi-to!\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (this.coordinates.getHeight() < 1){
            try {
                Main.Writer.writer.write(getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + ": Stoyanochka!\n");
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
                throw new Fails("Tower says: " + getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " cant be registered to weather tower.");
            }
            this.weatherTower = weatherTower;
            this.weatherTower.register(this);
            Main.Writer.writer.write("Tower says: " + getClass().getSimpleName() + "#" + this.name + "(" + this.id + ")" + " registered to weather tower.\n");
        } catch (Fails ex){
            System.out.println(ex.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
