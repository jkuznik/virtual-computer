package pl.jkuznik.computer.software.game;

import pl.jkuznik.computer.software.game.TicTacToe.TicTacToe;
import pl.jkuznik.computer.software.game.findNumber.FindNumberGame;

import java.util.ArrayList;
import java.util.List;

public class GameHandler {

    private static volatile GameHandler instance;
    private final static List<Game> games = new ArrayList<>();

    //TODO: dodająć nową gre trzeba w konstruktorze dodać ją do aktualnej kolekcji gier. W przyszłości można dodać logikę
    // umożliwiającą na 'instalowanie' gier dynamicznie tzn w trakcie działania programu
    private GameHandler() {
        FindNumberGame findNumberGame = new FindNumberGame();
        TicTacToe ticTacToe = new TicTacToe();

        games.add(findNumberGame);
        games.add(ticTacToe);
    }

    public void gameList() {
        for (int i=0; i< games.size(); i++) {
            System.out.println((i+1) + ". " + games.get(i).getName());
        }
    }

    public void startGameByName(String gameName) throws GameNotFoundException {
        games.stream()
                .filter(game -> game.getName().equals(gameName))
                .findFirst()
                .orElseThrow(() -> new GameNotFoundException("Game " + gameName + " not found"))
                .startGame();
    }

    public static GameHandler getInstance() {
        if (instance==null){
            synchronized (GameHandler.class) {
                if (instance == null) {
                    instance = new GameHandler();
                }
            }
        }
        return instance;
    }
}
