package software.game.TicTacToe;

import java.util.Scanner;


import static software.game.TicTacToe.Game2.gameModeStatus;
import static software.game.TicTacToe.SinglePlayer.*;

public class IfGameEnds {
    private static int roundCounter;
    private static int currentRoundsCounter;
    private static int XScore;
    private static int OScore;

    public int getXScore() {
        return XScore;
    }

    public void setXScore(int XScore) {
        IfGameEnds.XScore = XScore;
    }

    public int getOScore() {
        return OScore;
    }

    public void setOScore(int OScore) {
        IfGameEnds.OScore = OScore;
    }

    public int getRoundCounter() {
        return roundCounter;
    }

    public void setRoundCounter(int roundCounter) {
        IfGameEnds.roundCounter = roundCounter;
    }

    public static int getCurrentRoundsCounter() {
        return currentRoundsCounter;
    }

    public static void setCurrentRoundsCounter(int currentRoundsCounter) {
        IfGameEnds.currentRoundsCounter = currentRoundsCounter;
    }

    void addCurrentRoundsCounter(){currentRoundsCounter++;}
    void addPointToX(){
        XScore = XScore+1 ;}
    void addPointToO(){
        OScore++;}

    public static void gameEnds() {
        MainMenu mainMenu = new MainMenu();

        if (IfGameEnds.roundCounter == IfGameEnds.getCurrentRoundsCounter()) {
            if (XScore > OScore) {
                System.out.println("\n" + XValue + " won! " + XScore + ":" + OScore + "\n");
                mainMenu.mainMenu();
                board.gameAreaReset();
            } else if  (XScore < OScore) {
                System.out.println("\n" + OValue + " won! " + OScore + ":" + XScore + "\n");
                mainMenu.mainMenu();
                board.gameAreaReset();
            }
        }
        System.out.println("""
                1.Next round!
                2.New game!
                9.Exit XO menu!
                """);
        SinglePlayer singlePlayer = new SinglePlayer();
        Multiplayer multiplayer = new Multiplayer();
        Game2 game2 = new Game2();
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        String gameEndsUserChose = scanner.nextLine();

        switch (gameEndsUserChose) {
            case "1" -> {
                board.gameAreaReset();
               if (gameModeStatus.equals("1")){ howWillMakeFirstMoveSinglePlayer();}
                    else if(gameModeStatus.equals("2")){Multiplayer.multiPlayerXOMoves();}
            }
            case "2" -> {
                board.gameAreaReset();
                if (gameModeStatus.equals("1")){singlePlayer.singlePlayerXO();}
                    else if(gameModeStatus.equals("2")){multiplayer.multiPlayerXO();}
                }

                case "9" -> game2.gameStart2();
        }
    }
}
