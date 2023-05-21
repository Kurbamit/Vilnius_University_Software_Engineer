import UserInterface.UserInterface;


/**
 * Main klasė, skirta paleisti programą.
 * @author Dominykas Černovas.
 * @version 1.0
 * @since 2023-05-07
 */
public class Main {
    /**
     * Main metodas, skirtas paleisti programą.
     * @param args - argumentai, kuriuos galima perduoti programai.
     */
    public static void main(String[] args) {

        UserInterface ui = new UserInterface();
        ui.start();
    }
}
