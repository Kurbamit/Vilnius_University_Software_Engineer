package Biblioteka;

/**
 * Klasė, skirta knygos išdavimui.
 * Klasė paveldi Thread klasę.
 * @author Dominykas Černovas
 * @version 1.0
 * @since 1.0
 */
public class IssueBook extends Thread{
    Knyga K;
    /**
     * Konstruktorius, kuris nustato knygą.
     * @param K knyga, kurią reikia išduoti.
     */
    public IssueBook(Knyga K){
        this.K = K;
    }

    /**
     * Metodas, kuris išduoda knygą.
     * Override metodas iš Thread klasės.
     */
    @Override
    public void run(){
        try {
            K.isduoti();
        } catch (LibraryException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Knyga sėkmingai išduota.");
    }

}
