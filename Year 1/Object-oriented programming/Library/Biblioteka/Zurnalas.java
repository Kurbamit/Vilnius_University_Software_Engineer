package Biblioteka;
import java.time.LocalDate;

public class Zurnalas extends Leidinys implements IsduotiZurnala{
    // Additional field
    private String redactor;
    private static int journalCount = 0;


    public Zurnalas(){}
    public Zurnalas(String name, String redactor, int issueYear){
        super(name, issueYear);
        this.redactor = redactor;
        ++journalCount;
    }
    public static int isVisoZurnalu(){
        return journalCount;
    }


    @Override
    public String toString(){
        return "\nRedaktorius: " + redactor + super.toString();
    }

    @Override
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


    public String getRedactor(){return redactor;}
    public void setRedactor(String author){this.redactor = author;}
}
