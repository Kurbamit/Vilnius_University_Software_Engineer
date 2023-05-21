package Biblioteka;

/**
 * Klasė, skirta išimčiai, kuri atsitinka, kai įvedamas neigiamas dienų skaičius.
 * Klasė paveldi LibraryException klasę.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class NegativeDaysException extends LibraryException{

    /**
     * Kintamasis (int tipo).
     * Dienų skaičius, kuris buvo įvestas
     */
    public int days;
    /**
     * Neigiamų dienų skaičiaus išimties konstruktorius.
     * Konstruktorius skirtas sukurti išimtį su pranešimu.
     * @param message - pranešimas, kuris bus išvestas, kai įvyks klaida.
     * @param days - dienų skaičius, kuris buvo įvestas.
     */
    public NegativeDaysException(String message, int days){super(message); this.days = days;}
}
