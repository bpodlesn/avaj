package Tower;

import Exceptions.Fails;
import Exceptions.FileException;
import Exceptions.FooException;
import Flyables.AircraftFactory;
import Flyables.Flyable;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static int _numOfSimulations;

    public static void main(String[] args) throws IOException {
        ArrayList<Flyable> fl = new ArrayList<>();
        Scanner sc = new Scanner(new File(args[0]));
        WeatherTower wt = new WeatherTower();
        try {
            try {
                _numOfSimulations = sc.nextInt();
            } catch (Exception e){
                System.out.println(e.getMessage());
                System.exit(1);
            }
            if (_numOfSimulations < 1)
                throw new Fails("SHOULD BE POSITIVE LIKE ME!)");
        }
        catch (Fails e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
        Reader.readFile(fl, sc);
        Writer wr = new Writer();
        for (Flyable flyable : fl) {
                flyable.registerTower(wt);
        }
        for (int i = 0; i < _numOfSimulations; i++) {
            System.out.println(i);
            wt.changeWeather();
        }
        Writer.writer.flush();
        Writer.writer.close();
    }

    public static class Writer {

        File file = new File("./simulations.txt");
        public static FileWriter writer;

        public Writer() throws IOException{
            try {
                writer = new FileWriter(this.file);
            } catch (FileException e) {
                e.printStackTrace();
            }
        }

    }

}

