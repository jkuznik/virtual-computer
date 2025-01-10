package XO2;

import java.util.Arrays;

import static XO2.SinglePlayer.*;

public class CheckWinCon extends Board {

    static int [][] winingCombo = {
            {0, 1, 2},
            {2, 1, 0},
            {3, 4, 5},
            {5, 4, 3},
            {6, 7, 8},
            {8, 7, 6},
            {0, 3, 6},
            {6, 3, 0},
            {1, 4, 7},
            {7, 4, 1},
            {2, 5, 8},
            {8, 5, 2},
            {0, 4, 8},
            {8, 4, 0},
            {2, 4, 6},
            {6, 4, 2}
    };
 public void checkWhoWon() {
    IfGameEnds ifGameEnds = new IfGameEnds();
     checkIfDraw();
     for (int[] combo : winingCombo) {

         if (gameAreaArray[combo[0]].contains("X ") && gameAreaArray[combo[1]].contains("X ") && gameAreaArray[combo[2]].contains("X ")) {

             ifGameEnds.addPointToX();
             ifGameEnds.addCurrentRoundsCounter();
             System.out.println(XValue + " wins! \n" + XValue + " score is " +ifGameEnds.getXScore() + "\n" + OValue + " score is " +ifGameEnds.getOScore() + "\n");
             showOnlyBoard();
             IfGameEnds.gameEnds();
         }
         if (gameAreaArray[combo[0]].contains("O ") && gameAreaArray[combo[1]].contains("O ") && gameAreaArray[combo[2]].contains("O ")) {
             ifGameEnds.addPointToO();
             ifGameEnds.addCurrentRoundsCounter();
             System.out.println(OValue + " wins! \n" + OValue + " score is " +ifGameEnds.getOScore() + "\n" + XValue + " score is " +ifGameEnds.getXScore() + "\n");
             showOnlyBoard();
             IfGameEnds.gameEnds();
         }
     }

}
    public void checkIfDraw() {
        if (Arrays.stream(gameAreaArray).allMatch(gameAreaArray -> gameAreaArray.matches("[XO]\\s?"))) {
            System.out.println("\nDraw!\n");
            showOnlyBoard();
            IfGameEnds.gameEnds();
        }
    }
}
