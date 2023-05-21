package Biblioteka;

/**
 * Klasė, skirta žurnalo išdavimui.
 * Klasė paveldi Thread klasę.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */

public class IssueJournal extends Thread{
    Zurnalas Z;

    /**
     * Konstruktorius, kuris nustato žurnalą.
     * @param Z žurnalas, kurį reikia išduoti.
     */
    public IssueJournal(Zurnalas Z){
        this.Z = Z;
    }

    /**
     * Metodas, kuris išduoda žurnalą.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run(){
        try {
            Z.isduoti();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Žurnalas sėkmingai išduotas.");
    }
}
