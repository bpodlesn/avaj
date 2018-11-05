package Exceptions;

import java.io.IOException;

/**
 * Created by bpodlesn on 11/2/18.
 */
public class Fails extends IllegalArgumentException{
    public Fails(String ex){
        super(ex);
    }
}
