package Biblioteka;
import java.time.LocalDate;

public class Leidinys {
    // Fields (laukai)
    private String name;
    private String author;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean issued = false;

    protected final int MAX_BOOK_ISSUED_DAYS = 30;
    protected final int MAX_JOURNAL_ISSUED_DAYS = 1;
    private static int publicationCount = 0;

    // Constructor
    public Leidinys(){
        this(null, null);
    };
    public Leidinys(String name, String author) {
        this.name = name;
        this.author = author;
        ++publicationCount;
    }

    // Methods
    public void println(String type, int issueYear){
        System.out.println("Autorius:      " + author);
        System.out.println("Pavadinimas:   " + name);
        System.out.println("Išduota:       " + issueDate);
        System.out.println("Grąžinti:      " + returnDate);
        System.out.println("Tipas:         " + type);
        System.out.println("Leidimo metai: " + issueYear);
    }

    //  !!Static method can only access static fields!!
    public static void isVisoLeidiniu(){
        System.out.println("Leidinių skaičius: " + publicationCount);
    }

    public boolean isduoti(int days)
    {
        if(this.issued)
            return false;
        else{
            this.issued = true;
            this.issueDate = LocalDate.now();
            this.returnDate = LocalDate.now().plusDays(days);
            return true;
        }
    }
//    public boolean isduoti()
//    {
//        if(this.issued)
//            return false;
//        else if(this.type.equals("Knyga")){
//            this.issued = true;
//            this.issueDate = LocalDate.now();
//            this.returnDate = LocalDate.now().plusDays(MAX_ISSUED_DAYS);
//            return true;
//        }else
//        {
//            this.issued = true;
//            this.issueDate = LocalDate.now();
//            this.returnDate = LocalDate.now().plusDays(1);
//            return true;
//        }
//    }
    // * Methods that can not be overridden
    public final boolean pratestiLeidini(int days){
        if(!this.issued) {
            return false;
        }else {
            returnDate = returnDate.plusDays(days);
            return true;
        }
    }
    public final boolean pratestiLeidini(){
        if(!this.issued) {
            return false;
        }
        returnDate = returnDate.plusWeeks(1);
        return true;
    }


    // Getters
    public String getAuthor(){return author;}
    public String getName(){return name;}
    public LocalDate getIssueDate(){return issueDate;}
    public LocalDate getReturnDate(){return returnDate;}
    public boolean getIssued(){return issued;}
    // Setters
    public void setAuthor(String author){this.author = author;}
    public void setName(String name){this.name = name;}
    public void setIssueDate(LocalDate issueDate){this.issueDate = issueDate;}
    public void setReturnDate(LocalDate returnDate){this.returnDate = returnDate;}
    public void setIssued(boolean issued){this.issued = issued;}
}
