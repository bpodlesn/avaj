package Flyables;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class AircraftFactory {

    public static Flyable newAircraft(String type, String name, int longtitude, int latitude, int height){
        Coordinates _coordinates = new Coordinates(longtitude, latitude, height);
        Helicopter _helicopter;
        Baloon _ballon;
        JetPlane _jetPlane;


        if (type.equals("Helicopter")){
            return (_helicopter = new Helicopter(name, _coordinates));
        } else if (type.equals("JetPlane")){
            return (_jetPlane = new JetPlane(name, _coordinates));
        } else if (type.equals("Baloon")){
            return (_ballon = new Baloon(name, _coordinates));
        }
        return (null);
    }
}
