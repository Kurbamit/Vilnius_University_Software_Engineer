package Biblioteka;
import java.time.LocalDate;

public class Zurnalas extends Leidinys implements Isduodamas, Cloneable{
    // Additional field
    private String redactor;
    private static int journalCount = 0;
    private final int MAX_JOURNAL_ISSUED_DAYS = 1;
    public Remejas remejas = new Remejas("TELE2");

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
        return "\nRedaktorius: " + redactor + super.toString() + remejas;
    }

    @Override
    public void isduoti() throws LibraryException{
        if(getIssued())
            throw new LibraryException("Journal is already issued.");
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_JOURNAL_ISSUED_DAYS));
        }
    }
    @Override
    public void grazinti() throws LibraryException {
        if(getIssued())
        {
            throw new LibraryException("Journal is not issued.");
        }else{
            setIssued(false);
            setReturnDate(null);
            setIssueDate(null);
        }
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        //? DEEP klonavimas
        Zurnalas zurnalas = (Zurnalas) super.clone();
        zurnalas.remejas = (Remejas) remejas.clone();
        return zurnalas;

        //? Shallow klonavimas
//        return super.clone();
    }
    public String getRedactor(){return redactor;}
    public void setRedactor(String author){this.redactor = author;}
}
