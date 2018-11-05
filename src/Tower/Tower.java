package Tower;

import Flyables.AircraftFactory;
import Flyables.Flyable;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class Tower {
    private CopyOnWriteArrayList<Flyable> observers = new CopyOnWriteArrayList<>();

    public void register(Flyable flyable){
        observers.add(flyable);
    }

    public void unregister(Flyable flyable){
        observers.remove(flyable);
    }

    protected void conditionsChanged(){
        for (Flyable observer : observers) {
            try {
                observer.updateConditions();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
