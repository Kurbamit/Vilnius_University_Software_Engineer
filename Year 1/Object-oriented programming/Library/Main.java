package Main;
import Biblioteka.*;


public class Main {
    public static void main(String[] args) {
        Knyga K1 = new Knyga("Hamletas", "Sekspyras", 2020);
        Knyga K2 = new Knyga();

        Zurnalas Z1 = new Zurnalas();
        Zurnalas Z2 = new Zurnalas("Savaitė", "TV3", 2023);


//        K1.isduoti();
//        K1.println();
//
//        Z2.isduoti();
//        Z2.println();
//
//        ID ID1 = new ID();
//        ID ID2 = new ID();
//        ID1.printID();
//        ID2.printID();
//        System.out.println(ID.getLastID());

        // Polymorphism
        Knyga K3 = new Knyga("Hamletas", "Sekspyras", 2020);
        Zurnalas Z3 = new Zurnalas("Savaitė", "TV3", 2023);

        K3.isduoti();
        Z3.isduoti();

//        K3.println();
//        Z3.println();

        // Isduoti/Grazinti
//        K1.isduoti();
//        K1.println();
//        K1.grazinti();
//        K1.println();


        // toString
        System.out.println(K3);
        System.out.println(Z3);
    }
}
