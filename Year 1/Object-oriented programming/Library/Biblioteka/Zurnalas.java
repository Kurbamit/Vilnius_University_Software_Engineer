package Biblioteka;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasė Zurnalas, paveldinti Leidinys
 * Klasė, skirta saugoti žurnalų duomenims
 * @author Dominykas Černovas
 * @version 1.0
 * @since 1.0
 */
public class Zurnalas extends Leidinys implements Isduodamas, Cloneable, Serializable {

    /**
     * Klasės Zurnalas laukas, skirtas saugoti žurnalo redaktorių.
     */
    private String redactor;

    /**
     * Klasės Zurnalas laukas, skirtas saugoti žurnalų skaičių.
     */
    private static int journalCount = 0;

    /**
     * Klasės Zurnalas laukas, skirtas saugoti maksimalų žurnalo išdavimo dienų skaičių.
     */
    private final int MAX_JOURNAL_ISSUED_DAYS = 1;

    /**
     * Zurnalo konstruktorius
     * Konstruktorius skirtas sukurti tuščią žurnalą
     */
    public Zurnalas(){}
    /**
     * Zurnalo konstruktorius
     * Konstruktorius skirtas sukurti žurnalą su pavadinimu, redaktoriumi ir leidimo metais
     * @param name - žurnalo pavadinimas
     * @param redactor - žurnalo redaktorius
     * @param issueYear - žurnalo leidimo metai
     */
    public Zurnalas(String name, String redactor, int issueYear){
        super(name, issueYear);
        this.redactor = redactor;
        ++journalCount;
    }
    /**
     * isVisoZurnalu metodas
     * Metodas skirtas grąžinti visų žurnalų skaičių
     * @return int - žurnalų skaičius
     */
    public static int isVisoZurnalu(){
        return journalCount;
    }

    /**
     * toString metodas
     * Metodas skirtas išvesti žurnalo duomenis į konsolę
     * @return String
     */
    @Override
    public String toString(){
        return "\nRedaktorius: " + redactor + super.toString();
    }

    /**
     * isduoti metodas
     * Metodas skirtas išduoti žurnalą
     * @throws LibraryException - jei žurnalas jau išduotas
     */
    @Override
    public void isduoti() throws LibraryException{
        if(getIssued())
            throw new LibraryException("Žurnalas jau išduotas.");
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_JOURNAL_ISSUED_DAYS));
        }
    }

    /**
     * grazinti metodas
     * Metodas skirtas grąžinti žurnalą
     * @throws LibraryException - jei žurnalas nėra išduotas
     */
    @Override
    public void grazinti() throws LibraryException {
        if(getIssued())
        {
            throw new LibraryException("Žurnalas nėra išduotas.");
        }else{
            setIssued(false);
            setReturnDate(null);
            setIssueDate(null);
        }
    }

    /**
     * clone metodas
     * Metodas skirtas klonuoti žurnalą
     * @return Object
     * @throws CloneNotSupportedException - jei klonavimas nepalaikomas
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Metodas skirtas gauti žurnalo redaktorių
     * @return String - žurnalo redaktorius
     */
    public String getRedactor(){return redactor;}

    /**
     * Metodas skirtas nustatyti žurnalo redaktorių
     * @param author - žurnalo redaktorius
     */
    public void setRedactor(String author){this.redactor = author;}
}
