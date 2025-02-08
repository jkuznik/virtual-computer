package pl.jkuznik.utils.persistentState;

import org.junit.jupiter.api.Test;
import pl.jkuznik.utils._enums.FilePath;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

class PersistentStateTest {

    @Test
    void shouldReturnTrue_whenFileExists() {
        given();
        Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());

        when();
        boolean exists = Files.exists(path);

        then();
        assertTrue(exists);
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}