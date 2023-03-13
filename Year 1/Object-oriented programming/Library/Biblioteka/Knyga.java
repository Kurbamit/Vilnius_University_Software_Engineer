package Biblioteka;
import java.time.LocalDate;

public class Knyga extends Leidinys implements IsduotiKnyga{
    // Additional fields
    private String author;
    private static int bookCount = 0;
//    private final int MAX_BOOK_ISSUED_DAYS = 30;

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
    public boolean isduoti(){
        if(getIssued())
            return false;
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_BOOK_ISSUED_DAYS));
            return true;
        }
    }
    // Additional method
    public final boolean pratestiKnyga(int days){
        if(!getIssued()) {
            return false;
        }else {
            setReturnDate(LocalDate.now().plusDays(days));
            return true;
        }
    }
    public final boolean pratestiKnyga(){
        if(!getIssued()) {
            return false;
        }
        setReturnDate(LocalDate.now().plusWeeks(1));
        return true;
    }

    public String getAuthor(){return author;}
    public void setAuthor(String author){this.author = author;}

}
