package Biblioteka;

/**
 * Klasė, skirta išimčiai, kurią galima iššaukti, kai įvyksta klaida bibliotekoje.
 * Klasė paveldi Exception klasę.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 1.0
 */
public class LibraryException extends Exception{
    /**
     * Bibliotekos išimties konstruktorius.
     * Konstruktorius skirtas sukurti tuščią išimtį.
     */
    public LibraryException(){}
    /**
     * Bibliotekos išimties konstruktorius.
     * Konstruktorius skirtas sukurti išimtį su pranešimu.
     * @param message - pranešimas, kuris bus išvestas, kai įvyks klaida.
     */
    public LibraryException(String message){
        super(message);
    }
}
