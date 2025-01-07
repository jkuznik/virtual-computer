package software.game;

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
        games.add(findNumberGame);
    }

    public void gameList() {
        games.forEach(game -> System.out.println(game.getName()));
    }

    public void startGameByName(String name) {
        games.stream()
                .filter(game -> game.getName().equals(name))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
                .startGame();
    }
}
