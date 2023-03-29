package Biblioteka;

public class PublicationIssuedException extends Exception{
    public PublicationIssuedException(){}
    public PublicationIssuedException(String message){
        super(message);
    }
    public PublicationIssuedException(Throwable cause){
        super(cause);
    }
    public PublicationIssuedException(String message, Throwable cause){
        super(message, cause);
    }
}
