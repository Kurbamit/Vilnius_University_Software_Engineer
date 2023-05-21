package Biblioteka;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

/**
 * Klasė, skirta knygų nuskaitymui iš failo.
 * Klasė paveldi Thread klasę, kad galėtų būti paleista kaip atskiras procesas.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class LoadBooks extends Thread{

    /**
     * Kintamasis, kuriame saugomos nuskaitytos knygos.
     */
    private ArrayList<Knyga> knygos;

    /**
     * Sole constructor. (For invocation by subclass
     * constructors, typically implicit.)
     */
    public LoadBooks(){}

    /**
     * Metodas, kuris nuskaito knygas iš failo.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run() {
        try
        {
            FileInputStream fis = new FileInputStream("SaveBooks.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            knygos = (ArrayList<Knyga>) ois.readObject();
            fis.close();
            ois.close();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
        System.out.println("Knygos nuskaitytos sėkmingai.");
    }

    /**
     * Metodas, kuris grąžina nuskaitytas knygas.
     * @return nuskaitytas knygas.
     */
    public ArrayList<Knyga> getKnygos() {
        return knygos;
    }
}


