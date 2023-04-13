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

        // ? JEIGU LEIDINYS JAU ISDUOTAS
        try{
            K3.isduoti();
        }catch(PublicationIssuedException pie){
            System.out.println("Leidinys jau išduotas.");
        }

        try{
            K3.isduoti();
        }catch(PublicationIssuedException pie){
            System.out.println("Leidinys jau išduotas.");
        }

        // ?------------------------------------------
        // ? Jeigu leidinys nera isduotas arba neigiamas dienu skaicius
        try{
            K1.pratesti();
        }catch(NegativeDaysException nde){
            System.out.println("Neigiamas dienu skaicius.");
        }catch(PublicationIssuedException pie)
        {
            System.out.println("Leidinys nera isduotas.");
        }

        try{
            K3.pratesti(-1);
        }catch(NegativeDaysException nde){
        System.out.println("Neigiamas dienu skaicius.");
        }
        catch(PublicationIssuedException pie){
        System.out.println("Leidinys nera isduotas.");
        }

    }
}
