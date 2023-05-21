package Biblioteka;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
/**
 * Klasė, skirta knygų išsaugojimui į failą.
 * Klasė paveldi Thread klasę, kad galėtų būti paleista kaip atskiras procesas.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class SaveBook extends Thread{
    ArrayList<Knyga> knygos;
    /**
     * Konstruktorius, kuris nustato knygas, kurias reikia išsaugoti.
     * @param knygos - knygos, kurias reikia išsaugoti.
     */
    public SaveBook(ArrayList<Knyga> knygos){
        this.knygos = knygos;
    }

    /**
     * Metodas, kuris išsaugo knygas į failą.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run() {
        try
        {
            FileOutputStream fos = new FileOutputStream("SaveBooks.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(knygos);
            fos.close();
            oos.close();
        }catch(Exception e){
            System.out.println("Klaida išsaugant knygas.");
        }
        System.out.println("Knygos išsaugotos sėkmingai.");
    }
}
