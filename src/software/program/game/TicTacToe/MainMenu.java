package software.program.game.TicTacToe;

import java.util.Scanner;

public class MainMenu {
    public void mainMenu() {
        Game2 game2 = new Game2();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("""
                    Welcome!
                    Main menu!
                     1.XO
                     9.Wyjście""");

            int userChoiceMainMenu = scanner.nextInt();
            switch (userChoiceMainMenu) {
                  case 1 -> game2.gameStart2();
                  case 9 -> System.exit(1);
           }
        }
    }
}
