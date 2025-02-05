package pl.jkuznik.computer.software.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameHandlerTest {
    private GameHandler gameHandler = GameHandler.getInstance();

    @Test
    void gameList() {
        given();
        
        when();
        List<Game> result = gameHandler.gameList();

        then();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void startGameByName() {
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}