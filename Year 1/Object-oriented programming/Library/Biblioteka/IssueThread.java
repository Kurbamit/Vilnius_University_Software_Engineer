package Biblioteka;

/**
 * Klasė, skirta knygos arba žurnalo išdavimui.
 * Klasė paveldi Thread klasę.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class IssueThread extends Thread{
    Knyga K;
    Zurnalas Z;

    /**
     * Konstruktorius, kuris nustato knygą.
     * @param K knyga, kurią reikia išduoti.
     */
    public IssueThread(Knyga K) {
        this.K = K;
    }

    /**
     * Konstruktorius, kuris nustato žurnalą.
     * @param Z žurnalas, kurį reikia išduoti.
     */
    public IssueThread(Zurnalas Z) {
        this.Z = Z;
    }

    /**
     * Metodas, kuris išduoda knygą arba žurnalą.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run() {
        if(K != null) {
            try {
                K.isduoti();
            } catch (LibraryException e) {
                throw new RuntimeException(e);
            }
        }
        else {
            try {
                Z.isduoti();
            } catch (LibraryException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
