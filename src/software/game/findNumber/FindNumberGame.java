package software.game.findNumber;

import software.game.Game;

import java.util.Random;
import java.util.Scanner;

public class FindNumberGame implements Game {

    private static final String NAME = "Find number";

    private Scanner scanner = new Scanner(System.in);
    private String userChoice;
    private int number;
    private Random random = new Random();

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void startGame() {
        System.out.println("FIND GAME");

        do{
            System.out.println("""
                    1. Nowa gra
                    2. Wyjście
                    """);

            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1" -> {
                    game();
                }

                case "2" -> {
                    System.out.println("Do widzenia!");
                }

                default -> {
                    System.out.println("Zły wybór - wybierz jeszcze raz");
                }
            }


        }while(!userChoice.equals("2"));

    }

    private void game() {
        number = random.nextInt(100);
        int userChoice;
        int attempt = 1;

        do {
            System.out.println("Wybierz liczbe z przedziału 0-100");
            userChoice = Integer.parseInt(scanner.nextLine());

            if (userChoice == number) {
                System.out.println("Gratulacje! Udało Ci się trafić w " + attempt + " próbie!");
                break;
            }

            if (userChoice > number) {
                System.out.println("Za dużo!");
            } else {
                System.out.println("Za mało!");
            }

            attempt++;
        }while(!(userChoice==number));
    }
}
