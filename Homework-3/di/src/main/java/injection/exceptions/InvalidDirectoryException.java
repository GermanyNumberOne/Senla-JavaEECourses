package injection.exceptions;

public class InvalidDirectoryException extends RuntimeException{

    public InvalidDirectoryException(String message){
        super(message);
    }

    public InvalidDirectoryException(String message, Throwable cause){
        super(message,cause);
    }
}
