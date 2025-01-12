package software.game.TicTacToe;

import java.util.Scanner;

import static software.game.TicTacToe.Board.gameAreaArray;


public class SinglePlayer {
   static ComputerMoves computerMoves = new ComputerMoves();
   static CheckWinCon checkWinCon = new CheckWinCon();
   IfGameEnds ifGameEnds = new IfGameEnds();

    static Board board = new Board();
    static String playerChose;
    static String XValue;
    static String OValue;
    static String computerChose;

    static Scanner scannerSP = new Scanner(System.in);
    public boolean singlePlayerXO() {

        System.out.println("Choose the number of winning rounds");
        ifGameEnds.setRoundCounter(scannerSP.nextInt());
        scannerSP.nextLine();
        System.out.println("Chose X or O!");
        playerChose = scannerSP.nextLine();
        playerChose = playerChose.toUpperCase();

        if (playerChose.equals("X")) {
            OValue = "Computer";
            XValue = "Player1";
            computerChose = "O";
            howWillMakeFirstMoveSinglePlayer();
        } else if (playerChose.equals("O")) {
            OValue = "Player1";
            XValue = "Computer";
            computerChose = "X";
            howWillMakeFirstMoveSinglePlayer();
        } else {
            System.out.println("Wrong input! " + StatusCodes.FORBIDDEN + " " + StatusCodes.FORBIDDEN.getCode());
            return singlePlayerXO();
        }

        board.gameAreaReset();
        return true;
    }

    public static void howWillMakeFirstMoveSinglePlayer(){
        System.out.println("""
        Choose who will be making first move!
          1.Player
          2.AI
        """);
        String firstMove = scannerSP.nextLine();
        if (firstMove.equals("1")) {
            singlePlayerXOMoves();
        } if (firstMove.equals("2")) {
            computerMoves.computerRandomMove();
        } else {
            System.out.println("Error");
        }
        singlePlayerXOMoves();
        scannerSP.close();
    }

    public static void singlePlayerXOMoves() {
            Board board = new Board();
            System.out.println("Make move!");
            board.showBoard();
            userMove();
   }
    public static void userMove() {

            while (true) {
            checkWinCon.checkWhoWon();
            Scanner scannerMoves = new Scanner(System.in);
            String userMove = scannerMoves.nextLine();
            switch (userMove.toLowerCase()) {

                case "a1" -> {
                    if (gameAreaArray[0].contains("X") || gameAreaArray[0].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[0] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "a2" -> {
                    if (gameAreaArray[1].contains("X") || gameAreaArray[1].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[1] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "a3" -> {
                    if (gameAreaArray[2].contains("X") || gameAreaArray[2].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[2] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "b1" -> {
                    if (gameAreaArray[3].contains("X") || gameAreaArray[3].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[3] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "b2" -> {
                    if (gameAreaArray[4].contains("X") || gameAreaArray[4].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[4] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "b3" -> {
                    if (gameAreaArray[5].contains("X") || gameAreaArray[5].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[5] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "c1" -> {
                    if (gameAreaArray[6].contains("X") || gameAreaArray[6].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[6] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "c2" -> {
                    if (gameAreaArray[7].contains("X") || gameAreaArray[7].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[7] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                case "c3" -> {
                    if (gameAreaArray[8].contains("X") || gameAreaArray[8].contains("O")) {
                        System.out.println("Wrong move!");
                        singlePlayerXOMoves();
                    } else {
                        gameAreaArray[8] = playerChose + " ";
                        checkWinCon.checkWhoWon();
                        computerMoves.computerBlockMove();
                    }
                    computerMoves.computerRandomMove();
                }
                default -> System.out.println("Wrong move!!!");
            }
            System.out.println("Make move!");
            board.showBoard();
        }

    }
}









