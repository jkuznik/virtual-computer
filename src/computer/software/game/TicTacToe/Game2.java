package computer.software.game.TicTacToe;

import java.util.Objects;
import java.util.Scanner;


public class Game2 {
    static String gameModeStatus;
    public void gameStart2() {
        MainMenu mainMenu = new MainMenu();
        Board board = new Board();
        Scanner scannerGame = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    XO menu!
                     1.SinglePlayer (Player vs AI)
                     2.Multiplayer (Player vs Player)
                     8.Back to main menu!
                     9.Exit!""");

           String userChoiceTicTacTie = scannerGame.nextLine();

            if (!Objects.equals(userChoiceTicTacTie, "1") &&
                    !Objects.equals(userChoiceTicTacTie, "2") &&
                    !Objects.equals(userChoiceTicTacTie, "8") &&
                    !Objects.equals(userChoiceTicTacTie, "9")) {
                System.out.println("Wrong input! " + StatusCodes.FORBIDDEN + " " + StatusCodes.FORBIDDEN.getCode());
            }
            switch (userChoiceTicTacTie) {
                case "1" -> {
                    SinglePlayer singlePlayer = new SinglePlayer();
                    gameModeStatus = "1";
                    singlePlayer.singlePlayerXO();
                }
                case "2" -> {
                    gameModeStatus = "2";
                    Multiplayer multiplayer = new Multiplayer();
                    multiplayer.multiPlayerXO();
                }
                case "8" -> {
                    board.gameAreaReset();
                    mainMenu.mainMenu();
                }
                case "9" -> System.exit(1);
            }
        }
    }
}









