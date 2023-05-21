package Biblioteka;

/**
 * Interface skirtas knygų ir žurnalų išdavimui, grąžinimui ir pratęsimui.
 * @author Dominykas Černovas.
 * @version 1.0
 */
interface Isduodamas{

    /**
     * isduoti metodas
     * Metodas skirtas išduoti knygą ar žurnalą
     * @throws LibraryException - išimtis, jei knyga ar žurnalas jau išduotas
     */
    void isduoti() throws LibraryException;

    /**
     * grazinti metodas
     * Metodas skirtas grąžinti knygą ar žurnalą
     * @throws LibraryException - išimtis, jei knyga ar žurnalas jau grąžintas
     */
    void grazinti() throws LibraryException;
}
