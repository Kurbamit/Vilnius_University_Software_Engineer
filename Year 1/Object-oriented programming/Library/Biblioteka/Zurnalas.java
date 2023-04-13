package Biblioteka;
import java.time.LocalDate;

public class Zurnalas extends Leidinys implements Isduodamas{
    // Additional field
    private String redactor;
    private static int journalCount = 0;
    private final int MAX_JOURNAL_ISSUED_DAYS = 1;


    public Zurnalas(){}
    public Zurnalas(String name, String redactor, int issueYear){
        super(name, issueYear);
        this.redactor = redactor;
        ++journalCount;
    }
    public static int isVisoZurnalu(){
        return journalCount;
    }


    // *toString override
    public String toString(){
        return "\nRedaktorius: " + redactor + super.toString();
    }

    // *Override
    public void isduoti() throws PublicationIssuedException{
        if(getIssued())
            throw new PublicationIssuedException("Journal is already issued.");
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_JOURNAL_ISSUED_DAYS));
        }
    }
    public void grazinti() throws PublicationIssuedException {
        if(getIssued())
        {
            throw new PublicationIssuedException("Journal is not issued.");
        }else{
            setIssued(false);
            setReturnDate(null);
            setIssueDate(null);
        }
    }

    public String getRedactor(){return redactor;}
    public void setRedactor(String author){this.redactor = author;}
}
