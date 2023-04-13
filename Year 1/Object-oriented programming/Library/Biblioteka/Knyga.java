package Biblioteka;
import java.time.LocalDate;

public class Knyga extends Leidinys implements Pratesimas{
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

    // *toString override
    public String toString(){
        return "\nAutorius: " + author + super.toString();
    }

    // *Override
    public void isduoti() throws PublicationIssuedException{
        if(getIssued())
            throw new PublicationIssuedException("Book is already issued.");
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_BOOK_ISSUED_DAYS));
        }
    }

    public void grazinti() throws PublicationIssuedException{
        if(!getIssued())
        {
            throw new PublicationIssuedException("Book is not issued.");
        }else{
            setIssued(false);
            setReturnDate(null);
            setIssueDate(null);
        }
    }
    // Additional method
    public final void pratesti(int days) throws PublicationIssuedException {
        if(!getIssued()) {
            throw new PublicationIssuedException("Book is not issued.");
        }else if(days <= 0){
            throw new NegativeDaysException("Negative days parameter.");
        }else{
            setReturnDate(LocalDate.now().plusDays(days));
        }
    }
    public final void pratesti() throws PublicationIssuedException{
        if(!getIssued()) {
            throw new PublicationIssuedException("Book is not issued.");
        }
        setReturnDate(LocalDate.now().plusWeeks(1));
    }

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}

}
