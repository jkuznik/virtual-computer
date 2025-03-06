package pl.jkuznik.computer.software.game;

import org.reflections.Reflections;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class GameHandler {

    private static volatile GameHandler instance;
    private final static List<Game> games = new ArrayList<>();

    private GameHandler() {
        Reflections reflections = new Reflections("pl.jkuznik.computer.software.game");
        Set<Class<? extends Game>> gameClasses = reflections.getSubTypesOf(Game.class);

        for (Class<? extends Game> gameClass : gameClasses) {
            try {
                games.add(gameClass.getDeclaredConstructor().newInstance());
            } catch (Exception e) {
                e.fillInStackTrace();
            }
        }
    }

    public List<Game> gameList() {
        return games;
    }

    public void startGameByName(String gameName) throws GameNotFoundException {
        games.stream()
                .filter(game -> game.getName().equals(gameName))
                .findFirst()
                .orElseThrow(() -> new GameNotFoundException("Game " + gameName + " not found"))
                .startGame();
    }

    public static GameHandler getInstance() {
        if (instance == null) {
            synchronized (GameHandler.class) {
                if (instance == null) {
                    instance = new GameHandler();
                }
            }
        }
        return instance;
    }
}
