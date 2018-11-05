package Flyables;

/**
 * Created by bpodlesn on 10/30/18.
 */
public class Coordinates {
    private int longtitude;
    private int latitude;
    private int height;

    Coordinates(int longtitude, int latitude, int height){
        this.longtitude = longtitude;
        this.latitude = latitude;
        this.height = height < 100 ? height : 100;
        this.height = height < 0 ? 0 : height;
    }

    public int getLongtitude(){
        return (this.longtitude);
    }

    public int getLatitude(){
        return (this.latitude);
    }

    public int getHeight(){
        return (this.height);
    }

}
