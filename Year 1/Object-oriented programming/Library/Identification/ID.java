package Identification;
public class ID {
    private static int lastID = 0;
    private int id;

    public ID(){this.id = nextID();}

    public void printID(){
        System.out.println("ID: " + id);
    }

    public static int nextID(){return ++lastID;}
    // Getters
    public static int getLastID(){return lastID;}
    public int getId(){return id;}

    // Setters
    public void setId(int id){this.id = id;}
}
