package Biblioteka;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Klasė, skirta žurnalų nuskaitymui iš failo.
 * Klasė paveldi Thread klasę, kad galėtų būti paleista kaip atskiras procesas.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class LoadJournals extends Thread{
    private ArrayList<Zurnalas> zurnalai;

    /**
     * Metodas, kuris nuskaito žurnalus iš failo.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run() {
        try
        {
            FileInputStream fis = new FileInputStream("SaveJournals.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            zurnalai = (ArrayList<Zurnalas>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Žurnalai nuskaityti sėkmingai.");
    }

    /**
     * Metodas, kuris grąžina nuskaitytus žurnalus.
     * @return nuskaitytus žurnalus.
     */
    public ArrayList<Zurnalas> getZurnalai() {
        return zurnalai;
    }

}
