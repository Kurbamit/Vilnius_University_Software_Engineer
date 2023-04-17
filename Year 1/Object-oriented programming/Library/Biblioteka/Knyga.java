package Biblioteka;
import java.time.LocalDate;

public class Knyga extends Leidinys implements Pratesimas, Cloneable{
    // Additional fields
    private String author;
    private static int bookCount = 0;
    private final int MAX_BOOK_ISSUED_DAYS = 30;

    public Knyga(){}
    public Knyga(String name, String author, int issueYear){
        super(name, issueYear);
        this.author = author;
        ++bookCount;
    }

    public static int isVisoKnygu(){
        return bookCount;
    }

    @Override
    public String toString(){
        return "\nAutorius: " + author + super.toString();
    }

    @Override
    public void isduoti() throws LibraryException{
        if(getIssued())
            throw new LibraryException("Book is already issued.");
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_BOOK_ISSUED_DAYS));
        }
    }
    @Override
    public void grazinti() throws LibraryException{
        if(!getIssued())
        {
            throw new LibraryException("Book is not issued.");
        }else{
            setIssued(false);
            setReturnDate(null);
            setIssueDate(null);
        }
    }
    // Additional method
    public final void pratesti(int days) throws LibraryException {
        if(!getIssued()) {
            throw new LibraryException("Book is not issued.");
        }else if(days <= 0){
            throw new NegativeDaysException("Negative days parameter.", days);
        }else{
            setReturnDate(LocalDate.now().plusDays(days));
        }
    }
    public final void pratesti() throws LibraryException{
        if(!getIssued()) {
            throw new LibraryException("Book is not issued.");
        }
        setReturnDate(LocalDate.now().plusWeeks(1));
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}
}
