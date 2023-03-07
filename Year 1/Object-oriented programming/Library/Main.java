import Biblioteka.*;
import Identification.ID;

public class Main {
    public static void main(String[] args) {
        Knyga K1 = new Knyga("Hamletas", "Sekspyras", 2020);
        Knyga K2 = new Knyga();

        Zurnalas Z1 = new Zurnalas();
        Zurnalas Z2 = new Zurnalas("Savaitė", "TV3", 2023);

        K1.isduoti();
        K1.println();

        Z2.isduoti();
        Z2.println();

        ID ID1 = new ID();
        ID ID2 = new ID();
        ID1.registracija();
        ID1.printID();
        ID2.registracija();
        ID2.printID();
    }
}