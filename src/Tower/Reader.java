package Tower;

import Exceptions.Fails;
import Flyables.AircraftFactory;
import Flyables.Flyable;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by bpodlesn on 11/5/18.
 */
public class Reader {

    public static void readFile(ArrayList<Flyable> flayables, Scanner sc) {
        while (sc.hasNext()){
            sc.useDelimiter("\n");
            if (sc.hasNext("\\s*(Baloon|Helicopter|JetPlane)\\s+\\w+\\s+\\d+\\s+\\d+\\s+\\d+\\s*\\n?")){
                String[] arr = sc.next().split("\\s+");
                try{
                    flayables.add(AircraftFactory.newAircraft(arr[0], arr[1], Integer.valueOf(arr[2]), Integer.valueOf(arr[3]), Integer.valueOf(arr[4])));
                } catch (Fails e){
                    System.out.println("Unfortunately scenario file is incorrect");
                    System.exit(1);
                }
            } else {
                System.out.println("Unfortunately scenario file is incorrect");
                System.exit(1);
            }
        }
    }
}