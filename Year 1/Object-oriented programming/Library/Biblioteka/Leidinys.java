/**
 * Bibliotekos paketas, skirtas darbui su biblioteka
 */
package Biblioteka;
import java.io.Serializable;
import java.time.LocalDate;

/**
 * Klasė Leidinys
 * Klasė, skirta saugoti leidinių duomenims
 * @author Dominykas Černovas
 * @version 1.0
 * @since 1.0
 */
public abstract class Leidinys implements Isduodamas, Serializable {

    /**
     * Klasės Leidinys laukas, skirtas saugoti leidinio pavadinimą.
     */
    private String name;

    /**
     * Klasės Leidinys laukas, skirtas saugoti leidinio išleidimo metus.
     */
    private int issueYear;

    /**
     * Klasės Leidinys laukas, skirtas saugoti leidinio išdavimo datą.
     */
    private LocalDate issueDate;

    /**
     * Klasės Leidinys laukas, skirtas saugoti leidinio grąžinimo datą.
     */
    private LocalDate returnDate;

    /**
     * Klasės Leidinys laukas, skirtas saugoti leidinio išdavimo būseną.
     */
    private boolean issued = false;

    /**
     * Klasės Leidinys laukas, skirtas saugoti leidinių skaičių.
     */
    private static int publicationCount = 0;


    /**
     * Leidinys konstruktorius
     * Konstruktorius skirtas sukurti tuščią leidinį
     */
    public Leidinys(){
        this(null,  0);
    };

    /**
     * Leidinys konstruktorius
     * Konstruktorius skirtas sukurti leidinį su pavadinimu ir leidimo metais
     * @param name - leidinio pavadinimas
     * @param issueYear - leidimo metai
     */
    public Leidinys(String name, int issueYear) {
        this.name = name;
        this.issueYear = issueYear;
        ++publicationCount;
    }

    /**
     * toString metodas
     * Metodas skirtas išvesti leidinio duomenis į konsolę
     * @return String - leidinio duomenys
     */
    @Override
    public String toString(){
        return "\nPavadinimas: " + name + "\nLeidimo metai: " + issueYear + "\nIšduota: " +
                issueDate + "\nGrąžinti: " + returnDate;
    }

    // Method
    /**
     * isVisoLeidiniu metodas
     * Metodas skirtas grąžinti visų leidinių skaičių
     * @return int - leidinių skaičius
     */
    public static int isVisoLeidiniu(){
        return publicationCount;
    }

    /**
     * grazinti metodas
     * Metodas skirtas grąžinti leidinį
     * @throws LibraryException - jeigu leidinys nebuvo išduotas.
     */
    public void grazinti() throws LibraryException{}

    /**
     * Metodas, skirtas gauti leidinio pavadinimą
     * @return String - leidinio pavadinimas
     */
    public String getName(){return name;}

    /**
     * Metodas, skirtas gauti leidinio išleidimo metus
     * @return LocalDate - leidinio išleidimo metai
     */
    public LocalDate getIssueDate(){return issueDate;}

    /**
     * Metodas, skirtas gauti leidinio grąžinimo datą
     * @return LocalDate - leidinio grąžinimo data
     */
    public LocalDate getReturnDate(){return returnDate;}

    /**
     * Metodas, skirtas gauti leidinio išdavimo būseną
     * @return boolean - leidinio išdavimo būsena
     */
    public boolean getIssued(){return issued;}

    /**
     * Metodas, skirtas gauti leidinio išleidimo metus
     * @return int - leidinio išleidimo metai
     */
    public int getIssueYear(){return issueYear;}


    // Setters

    /**
     * Metodas, skirtas pakeisti leidinio pavadinimą
     * @param name - leidinio pavadinimas
     */
    public void setName(String name){this.name = name;}

    /**
     * Metodas, skirtas pakeisti leidinio išleidimo metus
     * @param issueDate - leidinio išleidimo metai
     */
    public void setIssueDate(LocalDate issueDate){this.issueDate = issueDate;}

    /**
     * Metodas, skirtas pakeisti leidinio grąžinimo datą
     * @param returnDate - leidinio grąžinimo data
     */
    public void setReturnDate(LocalDate returnDate){this.returnDate = returnDate;}

    /**
     * Metodas, skirtas pakeisti leidinio išdavimo būseną
     * @param issued - leidinio išdavimo būsena
     */
    public void setIssued(boolean issued){this.issued = issued;}

    /**
     * Metodas, skirtas pakeisti leidinio išleidimo metus
     * @param issueYear - leidinio išleidimo metai
     */
    public void setIssueYear(int issueYear){this.issueYear = issueYear;}
}
