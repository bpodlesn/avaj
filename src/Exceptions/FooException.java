package Exceptions;

/**
 * Created by bpodlesn on 11/5/18.
 */
public class FooException extends Exception {
    public FooException() { super(); }
    public FooException(String message) { super(message); }
    public FooException(String message, Throwable cause) { super(message, cause); }
    public FooException(Throwable cause) { super(cause); }
}
