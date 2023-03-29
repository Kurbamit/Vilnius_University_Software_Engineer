package Biblioteka;

public class NegativeDaysException extends PublicationIssuedException{
    public NegativeDaysException(){}
    public NegativeDaysException(String message){
        super(message);
    }
    public NegativeDaysException(Throwable cause){
        super(cause);
    }
    public NegativeDaysException(String message, Throwable cause){
        super(message, cause);
    }
}
