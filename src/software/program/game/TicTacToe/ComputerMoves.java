package software.program.game.TicTacToe;

import java.util.Random;
import static software.program.game.TicTacToe.CheckWinCon.winingCombo;
import static software.program.game.TicTacToe.SinglePlayer.*;

public class ComputerMoves extends Board {

 public void computerBlockMove() {

     for (int[] combo: winingCombo) {
         if (gameAreaArray[combo[0]].contains(playerChose) && gameAreaArray[combo[1]].contains(playerChose) &&
             gameAreaArray[combo[2]].matches("[abc][123]\\s?")) {
             gameAreaArray[combo[2]] = computerChose + " ";
             System.out.println("Make move");
             board.showBoard();
             userMove();
         }

     }
 }

public void computerRandomMove() {

        Random random = new Random();
        int randomInt = random.nextInt(9);

        if (gameAreaArray[4].matches("[abc][123]\\s?")) {
            gameAreaArray[4] = computerChose + " ";
        } else if (gameAreaArray[randomInt].matches("[abc][123]\\s?")) {
                   gameAreaArray[randomInt] = computerChose + " ";

         checkWinCon.checkIfDraw();
        } else { computerRandomMove(); }

        }

}
