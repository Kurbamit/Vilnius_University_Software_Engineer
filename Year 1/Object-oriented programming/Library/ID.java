package Identification;
import java.util.UUID;

public class ID {
    private UUID personID;
    public ID(){}
    public ID(UUID personID){
        this.personID = personID;
    }

    public void printID(){
        System.out.println("Person's ID: " + personID);
    }

    public void registracija(){
        personID = UUID.randomUUID();
    }
}
