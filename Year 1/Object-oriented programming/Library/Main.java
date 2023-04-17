package Main;
import Biblioteka.*;


public class Main {
    public static void main(String[] args) {
        Knyga K1 = new Knyga("Hamletas", "Sekspyras", 2020);
        Knyga K2 = new Knyga();

        Zurnalas Z1 = new Zurnalas();
        Zurnalas Z2 = new Zurnalas("Savaitė", "TV3", 2023);


        Knyga K3 = new Knyga("Hamletas", "Sekspyras", 2020);
        Zurnalas Z3 = new Zurnalas("Savaitė", "TV3", 2023);



        try{
            Z1 = (Zurnalas) Z2.clone();
        }catch (CloneNotSupportedException cnse)
        {
            System.out.println(cnse);
        }

        Z1.remejas.setRemejas("PILDYK");

        System.out.println(Z2);
        System.out.println(Z1);
    }
}
