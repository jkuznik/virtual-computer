package pl.jkuznik.computer.software.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GameHandlerTest {
    private final GameHandler gameHandler = GameHandler.getInstance();

    @Test
    void shouldReturnNotEmptyGameList() {
        given();
        
        when();
        List<Game> result = gameHandler.gameList();

        then();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void shouldStartGame_whenGameExists() throws NoSuchFieldException, IllegalAccessException, GameNotFoundException {
        given();
        Field gamesField = gameHandler.getClass().getDeclaredField("games");
        gamesField.setAccessible(true);
        var gameList = (List<Game>) gamesField.get(gameHandler);

        Game game = Mockito.mock(Game.class);
        gameList.add(game);

        when();
        Mockito.when(game.getName()).thenReturn("foo");

        then();
        gameHandler.startGameByName("foo");
        Mockito.verify(game).startGame();
    }

    @Test
    void shouldThrowException_whenGameDoesNotExist() throws GameNotFoundException {
        given();

        when();

        then();
        assertThrows(GameNotFoundException.class, () -> gameHandler.startGameByName("bar"));
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}