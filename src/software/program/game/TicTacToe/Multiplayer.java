package software.program.game.TicTacToe;

import java.util.Scanner;

import static software.program.game.TicTacToe.Board.gameAreaArray;


public class Multiplayer extends SinglePlayer {
    static String player1Chose;
    static String player2Chose;
    static boolean player1Move = false;
    static boolean player2Move = false;

    public boolean multiPlayerXO() {

        System.out.println("Choose the number of winning rounds");
        ifGameEnds.setRoundCounter(scannerSP.nextInt());
        scannerSP.nextLine();
        System.out.println("Player1. Chose X or O!");
        player1Chose = scannerSP.nextLine();
        player1Chose = player1Chose.toUpperCase();

        if (player1Chose.equals("X")) {
            OValue = "Player2";
            XValue = "Player1";
            player2Chose = "O";
            player1Chose = "X";
            player1Move = true;
            multiPlayerXOMoves();
        } else if (player1Chose.equals("O")) {
            OValue = "Player1";
            XValue = "Player2";
            player2Chose = "X";
            player1Chose = "O";
            player2Move = true;
            multiPlayerXOMoves();
        } else {
            System.out.println("Wrong input! " + StatusCodes.FORBIDDEN + " " + StatusCodes.FORBIDDEN.getCode());
            return singlePlayerXO();
        }
        return true;
    }

    public static void multiPlayerXOMoves() {
        Board board = new Board();
        board.showBoard();
        userMoveMultiplayer();
    }
    public static void userMoveMultiplayer() {

        while (true) {
            checkWinCon.checkWhoWon();
            Scanner scannerMoves = new Scanner(System.in);
            String userMove = scannerMoves.nextLine();
            switch (userMove.toLowerCase()) {

                case "a1" -> {
                    if (gameAreaArray[0].contains("X") || gameAreaArray[0].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[0] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else if (player2Move){
                            gameAreaArray[0] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();
                    }
                }
                case "a2" -> {
                    if (gameAreaArray[1].contains("X") || gameAreaArray[1].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[1] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[1] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();

                    }
                }
                case "a3" -> {
                    if (gameAreaArray[2].contains("X") || gameAreaArray[2].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[2] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[2] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                       }
                        checkWinCon.checkWhoWon();

                    }
                }
                case "b1" -> {
                    if (gameAreaArray[3].contains("X") || gameAreaArray[3].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[3] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[3] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                       }
                        checkWinCon.checkWhoWon();

                    }

                }
                case "b2" -> {
                    if (gameAreaArray[4].contains("X") || gameAreaArray[4].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[4] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[4] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();

                    }
                }
                case "b3" -> {
                    if (gameAreaArray[5].contains("X") || gameAreaArray[5].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[5] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[5] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();
                    }
                }
                case "c1" -> {
                    if (gameAreaArray[6].contains("X") || gameAreaArray[6].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[6] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[6] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();
                    }
                }
                case "c2" -> {
                    if (gameAreaArray[7].contains("X") || gameAreaArray[7].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[7] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[7] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();
                    }
                }
                case "c3" -> {
                    if (gameAreaArray[8].contains("X") || gameAreaArray[8].contains("O")) {
                        System.out.println("Wrong move!");
                        multiPlayerXOMoves();
                    } else {
                        if (player1Move) {
                            gameAreaArray[8] = player1Chose + " ";
                            player1Move = false;
                            player2Move = true;
                        } else {
                            gameAreaArray[8] = player2Chose + " ";
                            player2Move = false;
                            player1Move = true;
                        }
                        checkWinCon.checkWhoWon();
                    }
                }
                default -> System.out.println("Wrong move!!!");
            }
            board.showBoard();
        }

    }
}

