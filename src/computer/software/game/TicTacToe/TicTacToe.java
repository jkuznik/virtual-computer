package computer.software.game.TicTacToe;

import computer.software.game.Game;

public class TicTacToe implements Game {

   String name = "TicTacToe";

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void startGame() {
        MainMenu mainMenu = new MainMenu();
        mainMenu.mainMenu();

    }
}