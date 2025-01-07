package software.game;

import software.game.TicTacToe.TicTacToe;
import software.game.findNumber.FindNumberGame;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GameHandler {

    private final List<Game> games = new ArrayList<>();

    //TODO: dodająć nową gre trzeba w konstruktorze dodać ją do aktualnej kolekcji gier. W przyszłości można dodać logikę
    // umożliwiającą na 'instalowanie' gier dynamicznie tzn w trakcie działania programu
    public GameHandler() {
        FindNumberGame findNumberGame = new FindNumberGame();
        TicTacToe ticTacToe = new TicTacToe();
        games.add(findNumberGame);
        games.add(ticTacToe);
    }

    public void gameList() {
        for (int i=0; i < games.size(); i++) {
            System.out.println((i+1)+ ". " + games.get(i).getName());
        }
    }


    public void startGameByName(String name) {
        games.stream()
                .filter(game -> game.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException())
                .startGame();
    }
}
