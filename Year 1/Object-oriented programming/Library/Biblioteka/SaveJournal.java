package Biblioteka;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Klasė, skirta žurnalų išsaugojimui į failą.
 * Klasė paveldi Thread klasę, kad galėtų būti paleista kaip atskiras procesas.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class SaveJournal extends Thread{
    ArrayList<Zurnalas> zurnalai;

    /**
     * Konstruktorius, kuris nustato žurnalus, kuriuos reikia išsaugoti.
     * @param zurnalai - žurnalai, kuriuos reikia išsaugoti.
     */
    public SaveJournal(ArrayList<Zurnalas> zurnalai){
        this.zurnalai = zurnalai;
    }

    /**
     * Metodas, kuris išsaugo žurnalus į failą.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run() {
        try
        {
            FileOutputStream fos = new FileOutputStream("SaveJournals.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(zurnalai);
            fos.close();
            oos.close();
        }catch(Exception e){
            System.out.println("Klaida išsaugant žurnalus.");
        }
        System.out.println("Žurnalai išsaugoti sėkmingai.");
    }
}
