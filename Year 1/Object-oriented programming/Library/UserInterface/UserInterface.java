/**
 * Vartotojo sąsajos paketas, skirtas darbui su vartotojo sąsaja.
 */
package UserInterface;

import Biblioteka.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Klasė, skirta vartotojo sąsajai.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class UserInterface{
    private int choice = 0;
    private String input = null;
    ArrayList<Knyga> knygos = new ArrayList<Knyga>();
    ArrayList<Zurnalas> zurnalai = new ArrayList<Zurnalas>();

    /**
     * Konstruktorius, skirtas išspausdinti meniu.
     */
    public UserInterface(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("|                 Bibliotekos valdymo meniu                 |");
        System.out.println("-------------------------------------------------------------");
        printHelp();
    }

    /**
     * Metodas, skirtas visų galimų veiksmų išspausdinimui.
     * Pagrindinis metodas, skirtas vartotojo sąsajai.
     */
    public void start() {
        while (choice != -1) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Įveskite norimą veiksmą:");

            input = sc.nextLine();
            while(isNumeric(input)){
                System.out.println("Tokio pasirinkimo nėra.");
                System.out.println("Įveskite norimą veiksmą:");
                input = sc.nextLine();
            }
            choice = Integer.parseInt(input);

            switch (choice){
                case 1:
                    addBook();
                    break;

                case 2:
                    addMagazine();
                    break;
                case 3:
                    if(knygos.isEmpty()){
                        System.out.println("Sąrašas tuščias.");
                    }
                    else {
                        for (Knyga knyga : knygos) {
                            System.out.println(knyga);
                        }
                    }
                    break;
                case 4:
                    if(zurnalai.isEmpty()){
                        System.out.println("Sąrašas tuščias.");
                    }
                    else {
                        for (Zurnalas zurnalas : zurnalai) {
                            System.out.println(zurnalas);
                        }
                    }
                    break;
                case 5:
                    save(knygos, zurnalai);
                    break;
                case 6:
                    load();
                    break;
                case 7:
                    issueBook();
                    break;
                case 8:
                    issueMagazine();
                    break;
                case 9:
                    returnBook();
                    break;
                case 10:
                    returnMagazine();
                    break;
                case 11:
                    extendBook();
                    break;
                case 12:
                    removeBook();
                    break;
                case 13:
                    removeMagazine();
                    break;
                case 0:
                    printHelp();
                    break;
                case -1:
                    System.out.println("Darbas baigtas");
                    break;
                default:
                    System.out.println("Tokio pasirinkimo nėra.");
                    break;
            }
        }
    }

    /**
     * Metodas, skirtas pridėti knygą.
     * @since 1.0
     * @version 1.0
     */
    private void addBook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Įveskite knygos pavadinimą:");
        String name = sc.nextLine();
        System.out.println("Įveskite knygos autorių:");
        String author = sc.nextLine();
        System.out.println("Įveskite knygos leidimo metus:");
        int year = sc.nextInt();
        if(year > LocalDate.now().getYear() || year < 0){
            System.out.println("Neteisingai įvesti metai.");
            return;
        }
        knygos.add(new Knyga(name, author, year));
        System.out.println("Knyga pridėta.");
    }

    /**
     * Metodas, skirtas pridėti žurnalą.
     * @since 1.0
     * @version 1.0
     */
    private void addMagazine(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Įveskite žurnalo pavadinimą:");
        String name = sc.nextLine();
        System.out.println("Įveskite žurnalo leidėją:");
        String publisher = sc.nextLine();
        System.out.println("Įveskite žurnalo leidimo metus:");
        int year = sc.nextInt();
        if(year > LocalDate.now().getYear() || year < 0){
            System.out.println("Neteisingai įvesti metai.");
            return;
        }
        zurnalai.add(new Zurnalas(name, publisher, year));
        System.out.println("Žurnalas pridėtas.");
    }

    /**
     * Metodas, skirtas išsaugoti duomenis į failą.
     * @param knygos
     * @param zurnalai
     */
    private void save(ArrayList<Knyga> knygos, ArrayList<Zurnalas> zurnalai){
        SaveBook saveBook = new SaveBook(knygos);
        saveBook.start();
        SaveJournal saveJournal = new SaveJournal(zurnalai);
        saveJournal.start();
    }

    /**
     * Metodas, skirtas įkelti duomenis iš failo.
     * @since 1.0
     * @version 1.0
     */
    private void load(){
        LoadBooks loadBooks = new LoadBooks();
        loadBooks.start();
        try{
            loadBooks.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        LoadJournals loadJournals = new LoadJournals();
        loadJournals.start();
        try
        {
            loadJournals.join();
        }catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        knygos = loadBooks.getKnygos();
        zurnalai = loadJournals.getZurnalai();
    }

    /**
     * Metodas, skirtas išduoti knygą.
     * @since 1.0
     * @version 1.0
     */
    private void issueBook() {
        System.out.println("Įveskite knygos pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Knyga knyga : knygos) {
            if (knyga.getName().equals(name)){
                IssueBook issueBook = new IssueBook(knyga);
                issueBook.start();
                return;
            }
        }
        System.out.println("Tokios knygos nėra.");
    }

    /**
     * Metodas, skirtas išduoti žurnalą.
     * @since 1.0
     * @version 1.0
     */
    private void issueMagazine() {
        System.out.println("Įveskite žurnalo pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Zurnalas zurnalas : zurnalai) {
            if (zurnalas.getName().equals(name)){
                IssueJournal issueJournal = new IssueJournal(zurnalas);
                issueJournal.start();
                return;
            }
        }
        System.out.println("Tokio žurnalo nėra.");
    }

    /**
     * Metodas, skirtas grąžinti knygą.
     * @since 1.0
     * @version 1.0
     */
    private void returnBook(){
        System.out.println("Įveskite knygos pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Knyga knyga : knygos) {
            if (knyga.getName().equals(name)){
                try {
                    knyga.grazinti();
                } catch (LibraryException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Tokios knygos nėra.");
    }

    /**
     * Metodas, skirtas grąžinti žurnalą.
     * @since 1.0
     * @version 1.0
     */
    private void returnMagazine(){
        System.out.println("Įveskite žurnalo pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Zurnalas zurnalas : zurnalai) {
            if (zurnalas.getName().equals(name)){
                try {
                    zurnalas.grazinti();
                } catch (LibraryException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Tokio žurnalo nėra.");
    }

    /**
     * Metodas, skirtas pratęsti knygą.
     * @since 1.0
     * @version 1.0
     */
    private void extendBook(){
        System.out.println("Įveskite knygos pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Knyga knyga : knygos) {
            if (knyga.getName().equals(name)){
                try {
                    knyga.pratesti();
                } catch (LibraryException e) {
                    System.out.println(e.getMessage());
                }
                return;
            }
        }
        System.out.println("Tokios knygos nėra.");
    }

    /**
     * Metodas, skirtas ištrinti knygą.
     * @since 1.0
     * @version 1.0
     */
    private void removeBook(){
        System.out.println("Įveskite knygos pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Knyga knyga : knygos) {
            if (knyga.getName().equals(name)){
                knygos.remove(knyga);
                System.out.println("Knyga pašalinta.");
                return;
            }
        }
        System.out.println("Tokios knygos nėra.");
    }

    /**
     * Metodas, skirtas ištrinti žurnalą.
     * @since 1.0
     * @version 1.0
     */
    private void removeMagazine(){
        System.out.println("Įveskite žurnalo pavadinimą.");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        for (Zurnalas zurnalas : zurnalai) {
            if (zurnalas.getName().equals(name)){
                zurnalai.remove(zurnalas);
                System.out.println("Žurnalas pašalintas.");
                return;
            }
        }
        System.out.println("Tokio žurnalo nėra.");
    }

    /**
     * Metodas, skirtas išspauzdinti meniu.
     * @since 1.0
     * @version 1.0
     */
    private void printHelp(){
        System.out.println("-------------------------------------------------------------");
        System.out.println("| 1. Pridėti knygą.              | 2. Pridėti žurnalą.      |");
        System.out.println("| 3. Atspausdinti knygas.        | 4. Atspausdinti žurnalus.|");
        System.out.println("| 5. Išsaugoti leidinius.        | 6. Nuskaityti leidinius. |");
        System.out.println("| 7. Išduoti knygą.              | 8. Išduoti žurnalą.      |");
        System.out.println("| 9. Grąžinti knygą.             | 10. Grąžinti žurnalą.    |");
        System.out.println("| 11. Pratęsti knygos galiojimą. | 12. Ištrinti knygą.      |");
        System.out.println("| 13. Ištrinti žurnalą.          | -1. Baigti darbą.        |");
        System.out.println("| 0. Komandos.                                              |");
        System.out.println("-------------------------------------------------------------");
    }

    /**
     * Metodas, skirtas patikrinti ar eilutė yra skaičius.
     * @param strNum eilutė, kurią reikia patikrinti.
     * @return true, jei eilutė yra skaičius, false, jei eilutė nėra skaičius.
     * @since 1.0
     * @version 1.0
     */
    private boolean isNumeric(String strNum) {
        try
        {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe)
        {
            return true;
        }
        return false;
    }
}
