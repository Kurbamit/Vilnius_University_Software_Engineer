package Biblioteka;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasė Knyga, paveldinti Leidinys
 * Klasė, skirta saugoti knygų duomenims
 * @author Dominykas Černovas
 * @version 1.0
 * @since 1.0
 */
public class Knyga extends Leidinys implements Pratesiamas, Cloneable, Serializable {

    /**
     * Klasės Knyga laukas, skirtas saugoti knygos autorių.
     */
    private String author;

    /**
     * Klasės Knyga laukas, skirtas saugoti knygų skaičių.
     */
    private static int bookCount = 0;

    /**
     * Klasės Knyga laukas, skirtas saugoti maksimalų knygos išdavimo dienų skaičių.
     */
    private final int MAX_BOOK_ISSUED_DAYS = 30;

    /**
     * Knygos konstruktorius
     * Konstruktorius skirtas sukurti tuščią knygą
     */
    public Knyga(){}

    /**
     * Knygos konstruktorius
     * Konstruktorius skirtas sukurti knygą su pavadinimu, autoriumi ir leidimo metais
     * @param name - knygos pavadinimas
     * @param author - knygos autorius
     * @param issueYear - knygos leidimo metai
     */
    public Knyga(String name, String author, int issueYear){
        super(name, issueYear);
        this.author = author;
        ++bookCount;
    }

    /**
     * isVisoKnygu metodas
     * Metodas skirtas grąžinti visų knygų skaičių
     * @return int - knygų skaičius
     */
    public static int isVisoKnygu(){
        return bookCount;
    }

    /**
     * toString metodas
     * Metodas skirtas išvesti knygos duomenis į konsolę
     * @return String
     */
    @Override
    public String toString(){
        return "\nAutorius: " + author + super.toString();
    }

    /**
     * isduoti metodas
     * Metodas skirtas išduoti knygą
     * @throws LibraryException - išimtis, jei knyga jau išduota
     */
    @Override
    public void isduoti() throws LibraryException{
        if(getIssued())
            throw new LibraryException("Knyga jau išduota.");
        else{
            setIssued(true);
            setIssueDate(LocalDate.now());
            setReturnDate(LocalDate.now().plusDays(MAX_BOOK_ISSUED_DAYS));
        }
    }
    /**
     * grazinti metodas
     * Metodas skirtas grąžinti knygą
     * @throws LibraryException - išimtis, jei knyga nėra išduota
     */
    @Override
    public void grazinti() throws LibraryException{
        if(!getIssued())
        {
            throw new LibraryException("Knyga nėra išduota.");
        }else{
            setIssued(false);
            setReturnDate(null);
            setIssueDate(null);
        }
    }
    /**
     * pratesti metodas
     * Metodas skirtas pratęsti knygos grąžinimo datą
     * @param days - dienų skaičius, kiek norima pratęsti knygos grąžinimo datą
     * @throws LibraryException - išimtis, jei knyga nėra išduota
     * @throws NegativeDaysException - išimtis, jei dienų skaičius neigiamas
     */
    public final void pratesti(int days) throws LibraryException {
        if(!getIssued()) {
            throw new LibraryException("Knyga nėra išduota.");
        }else if(days <= 0){
            throw new NegativeDaysException("Neigiamas dienų skaičius.", days);
        }else{
            setReturnDate(LocalDate.now().plusDays(days));
        }
    }

    /**
     * pratesti metodas
     * Metodas skirtas pratęsti knygos grąžinimo datą viena savaite
     * @throws LibraryException - išimtis, jei knyga nėra išduota
     */
    public final void pratesti() throws LibraryException{
        if(!getIssued()) {
            throw new LibraryException("Knyga nėra išduota.");
        }
        setReturnDate(getReturnDate().plusWeeks(1));
    }

    /**
     * clone metodas
     * Metodas skirtas klonuoti knygą
     * @return Object
     * @throws CloneNotSupportedException - išimtis, jei klonavimas nepalaikomas
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Metodas skirtas gauti knygos autorių.
     * @return String - knygos autorius
     */
    public String getAuthor(){return author;}

    /**
     * Metodas skirtas pakeisti knygos autorių.
     * @param author - knygos autorius
     */
    public void setAuthor(String author){this.author = author;}
}
