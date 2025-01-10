package XO2;


import static XO2.Multiplayer.*;
import static XO2.SinglePlayer.OValue;
import static XO2.SinglePlayer.XValue;

public class Board {
  public static String[] gameAreaArray = new String[]{"a1", "a2", "a3", "b1", "b2", "b3" , "c1", "c2", "c3"};

    public void showBoard() {
        if (player1Move){ System.out.println("Player1 make move using " + player1Chose + "!"); }
        else if (player2Move){ System.out.println("Player2 make move using " + player2Chose + "!"); }
        System.out.println(
                "     " + gameAreaArray[0] + " | " + gameAreaArray[1] + " | " + gameAreaArray[2] + "\n" +
                "     --------------\n" +
                "     " + gameAreaArray[3] + " | " + gameAreaArray[4] + " | " + gameAreaArray[5] + "\n" +
                "     --------------\n" +
                "     " + gameAreaArray[6] + " | " + gameAreaArray[7] + " | " + gameAreaArray[8] + "\n"
       );
    }
    public void showOnlyBoard() {
        System.out.println(
                "     " + gameAreaArray[0] + " | " + gameAreaArray[1] + " | " + gameAreaArray[2] + "\n" +
                        "     --------------\n" +
                        "     " + gameAreaArray[3] + " | " + gameAreaArray[4] + " | " + gameAreaArray[5] + "\n" +
                        "     --------------\n" +
                        "     " + gameAreaArray[6] + " | " + gameAreaArray[7] + " | " + gameAreaArray[8] + "\n"

        );
    }
    public void gameAreaReset() {
        gameAreaArray[0] = "a1";
        gameAreaArray[1] = "a2";
        gameAreaArray[2] = "a3";
        gameAreaArray[3] = "b1";
        gameAreaArray[4] = "b2";
        gameAreaArray[5] = "b3";
        gameAreaArray[6] = "c1";
        gameAreaArray[7] = "c2";
        gameAreaArray[8] = "c3";
    }
}
