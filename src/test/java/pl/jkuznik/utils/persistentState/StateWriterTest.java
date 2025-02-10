package pl.jkuznik.utils.persistentState;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.jkuznik.utils.persistentState.PersistentStateTest.TEST_FILE_PATH;

class StateWriterTest {

    @AfterAll
    static void tearDown() throws IOException {
        Files.deleteIfExists(TEST_FILE_PATH);
    }

    @Test
    void shouldWriteStateToFile() {
        given();
        var computer = new Computer();
        computer.addComponent(new Monitor("foo"));
        List<String> result;

        when();
        computer.saveState(TEST_FILE_PATH);
        try {
            result = Files.readAllLines(TEST_FILE_PATH);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file in test of StateWriter", e);
        }

        then();
        assertEquals(1, result.size());
        assertTrue(result.getFirst().contains("foo"));
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}