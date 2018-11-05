package Exceptions;

import java.io.IOException;

/**
 * Created by bpodlesn on 11/5/18.
 */
public class FileException extends IOException{
    public FileException() { super(); }
    public FileException(String message) { super(message); }
    public FileException(String message, Throwable cause) { super(message, cause); }
    public FileException(Throwable cause) { super(cause); }
}
