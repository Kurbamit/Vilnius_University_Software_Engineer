package Biblioteka;

public class NegativeDaysException extends LibraryException{
    public int days;
    public NegativeDaysException(String message, int days){super(message); this.days = days;}
}
