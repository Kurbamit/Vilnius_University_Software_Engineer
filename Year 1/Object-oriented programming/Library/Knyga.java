package Biblioteka;
import java.time.LocalDate;

public class Knyga extends Leidinys{
    // Additional field
    private int issueYear;

    public Knyga(){}
    public Knyga(String name, String author, int issueYear){
        super(name, author);
        this.issueYear = issueYear;
    }
    // *Polymorphism
    public final void println(){
        super.println(getClass().getName(), issueYear);
    }
    // *toString override
    public String toString(){
        return "Knyga: " + getName() + " Autorius: " + getAuthor() + " Leidimo metai: " + issueYear;
    }

    // *Override
    public boolean isduoti(int days){
        if(getIssued())
            return false;
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(days));
            return true;
        }
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
    public boolean grazinti(){
        if(getIssued())
        {
            setIssued(false);
            setIssueDate(null);
            setReturnDate(null);
            return true;
        }else{
            return false;
        }
    }

    public void setIssueYear(int issueYear){this.issueYear = issueYear;}
    public int getIssueYear(){return this.issueYear;}
}
