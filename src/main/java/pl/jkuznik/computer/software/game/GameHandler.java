package pl.jkuznik.computer.software.game;

import pl.jkuznik.computer.software.game.TicTacToe.TicTacToe;
import pl.jkuznik.computer.software.game.findNumber.FindNumberGame;

import java.util.ArrayList;
import java.util.List;

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
        games.forEach(game -> System.out.println(game.getName()));
    }

    public void startGameByName(String gameName) throws GameNotFoundException {
        games.stream()
                .filter(game -> game.getName().equals(gameName))
                .findFirst()
                .orElseThrow(() -> new GameNotFoundException("Game " + gameName + " not found"))
                .startGame();
    }


}
