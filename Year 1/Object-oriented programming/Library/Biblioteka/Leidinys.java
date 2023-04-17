package Biblioteka;
import java.time.LocalDate;

public abstract class Leidinys implements Isduodamas{
    // Fields (laukai)
    private String name;
    private int issueYear;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean issued = false;
    private static int publicationCount = 0;


    // Constructor
    public Leidinys(){
        this(null,  0);
    };
    public Leidinys(String name, int issueYear) {
        this.name = name;
        this.issueYear = issueYear;
        ++publicationCount;
    }

    public String toString(){
        return "\nPavadinimas: " + name + "\nLeidimo metai: " + issueYear + "\nIšduota: " +
                issueDate + "\nGrąžinti: " + returnDate;
    }

    // Method
    public static int isVisoLeidiniu(){
        return publicationCount;
    }

    public void grazinti() throws LibraryException{}

    // Getters
    public String getName(){return name;}
    public LocalDate getIssueDate(){return issueDate;}
    public LocalDate getReturnDate(){return returnDate;}
    public boolean getIssued(){return issued;}
    public int getIssueYear(){return issueYear;}
    // Setters

    public void setName(String name){this.name = name;}
    public void setIssueDate(LocalDate issueDate){this.issueDate = issueDate;}
    public void setReturnDate(LocalDate returnDate){this.returnDate = returnDate;}
    public void setIssued(boolean issued){this.issued = issued;}
    public void setIssueYear(int issueYear){this.issueYear = issueYear;}
}
