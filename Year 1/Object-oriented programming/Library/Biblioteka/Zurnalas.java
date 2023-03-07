package Biblioteka;
import java.time.LocalDate;

public class Zurnalas extends Leidinys{
    // Additional field
    private int issueYear;

    public Zurnalas(){}
    public Zurnalas(String name, String author, int issueYear){
        super(name, author);
        this.issueYear = issueYear;
    }
    // *Polymorphism
    public final void println(){
        super.println(getClass().getName(), issueYear);

    }
    // *toString override
    public String toString(){
        return "Žurnalas: " + getName() + " Leidėjas: " + getAuthor() + " Leidimo metai: " + issueYear;
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
            setReturnDate(LocalDate.now().plusDays(MAX_JOURNAL_ISSUED_DAYS));
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
