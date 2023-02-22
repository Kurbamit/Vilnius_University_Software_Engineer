import javax.swing.*;

import static java.lang.Math.random;

public class Main {
    public static void main(String[] args) {
        ImageIcon icon = new ImageIcon("SteveCarrell.jpg");

        int min = 1;
        int max = 100;

        int restart = 0;

        int random = randomNumber(min, max);
        int iGuess = -1;

        String[] message = {"Taip", "Ne"};


        while(iGuess != random && restart == 0) {

            String guess = JOptionPane.showInputDialog(null,
                    "Aš sugalvojau skaičių tarp " + min + " - " + max + " Jūsų spėjimas:",
                    "ATSPĖK SKAIČIŲ",
                    JOptionPane.PLAIN_MESSAGE);
            //If cancel or close
            if(guess == null)
            {
                System.exit(0);
            }

            while (isNumeric(guess)) {
                guess = JOptionPane.showInputDialog(null,
                        "Aš sugalvojau skaičių tarp " + min + " - " + max + " Jūsų spėjimas:",
                        "ATSPĖK SKAIČIŲ",
                        JOptionPane.PLAIN_MESSAGE);
            }

            iGuess = Integer.parseInt(guess);
            if (iGuess < random) {
                JOptionPane.showMessageDialog(null,
                        "Skaičius yra didesnis, nei " + iGuess,
                        "ATSPĖK SKAIČIŲ",
                        JOptionPane.PLAIN_MESSAGE);
            } else if (iGuess > random) {
                JOptionPane.showMessageDialog(null,
                        "Skaičius yra mažesnis, nei " + iGuess,
                        "ATSPĖK SKAIČIŲ",
                        JOptionPane.PLAIN_MESSAGE);
            }else
            {
                restart = JOptionPane.showConfirmDialog(null,
                        " JŪS LAIMĖJOTE! Atsakymas buvo: " + iGuess + " Ar norite žaisti iš naujo?",
                        "ATSPĖK SKAIČIŲ",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.INFORMATION_MESSAGE,
                        icon);
                random = randomNumber(min, max);
                iGuess = -1;
            }

        }
    }

    public static boolean isNumeric(String strNum) {
        try
        {
            int i = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe)
        {
            return true;
        }
        return false;
    }

    public static int randomNumber(int min, int max)
    {
        return (int) (random() * (max - min + 1)) + min;
    }
}
