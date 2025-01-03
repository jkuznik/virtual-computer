package software.game;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class GameHandler {

    private final List<Game> games = new ArrayList<>();

    //TODO: dodająć nową gre trzeba w konstruktorze dodać ją do aktualnej kolekcji gier. W przyszłości można dodać logikę
    // umożliwiającą na 'instalowanie' gier dynamicznie tzn w trakcie działania programu
    public GameHandler() {

    }

    public List<Game> gameList() {
        return games;
    }

    public void startGameByName(String name) {
        games.stream()
                .filter(game -> game.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException())
                .startGame();
    }
}
