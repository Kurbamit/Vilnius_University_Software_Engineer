import java.time.LocalDate;

public class Leidinys {
    // Fields (laukai)
    private String name;
    private String author;
    private String type;
    private LocalDate issueDate;
    private LocalDate returnDate;
    private boolean issued = false;

    private final int MAX_ISSUED_DAYS = 30;
    private static int publicationCount = 0;

    // Constructor
    public Leidinys(){
        this(null, null, "Knyga");
    };
    public Leidinys(String name, String author, String type) {
        this.name = name;
        this.author = author;
        this.type = type;
        ++publicationCount;
    }

    // Methods
    public final void println(){
        System.out.println("Autorius:    " + author);
        System.out.println("Pavadinimas: " + name);
        System.out.println("Tipas:       " + type);
        System.out.println("Išduota:     " + issueDate);
        System.out.println("Grąžinti:    " + returnDate);
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
    public boolean isduoti()
    {
        if(this.issued)
            return false;
        else if(this.type.equals("Knyga")){
            this.issued = true;
            this.issueDate = LocalDate.now();
            this.returnDate = LocalDate.now().plusDays(MAX_ISSUED_DAYS);
            return true;
        }else
        {
            this.issued = true;
            this.issueDate = LocalDate.now();
            this.returnDate = LocalDate.now().plusDays(1);
            return true;
        }
    }
    public boolean pratestiLeidini(int days){
        if(!this.issued) {
            return false;
        }else {
            returnDate = returnDate.plusDays(days);
            return true;
        }
    }
    public boolean pratestiLeidini(){
        if(!this.issued) {
            return false;
        }
        returnDate = returnDate.plusWeeks(1);
        return true;
    }


    // Getters
    public String getAuthor(){return author;}
    public String getName(){return name;}
    public String getType(){return type;}
    public LocalDate getIssueDate(){return issueDate;}
    public LocalDate getReturnDate(){return returnDate;}
    public boolean getIssued(){return issued;}
    // Setters
    public void setAuthor(String author){this.author = author;}
    public void setName(String name){this.name = name;}
    public void setType(String type){this.type = type;}
    public void setIssueDate(LocalDate issueDate){this.issueDate = issueDate;}
    public void setReturnDate(LocalDate returnDate){this.returnDate = returnDate;}
    public void setIssued(boolean issued){this.issued = issued;}
}
