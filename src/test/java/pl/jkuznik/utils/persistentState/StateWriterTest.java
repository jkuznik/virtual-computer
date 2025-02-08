package pl.jkuznik.utils.persistentState;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.utils.computerBootstrap.ComputerBootstrap;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StateWriterTest {

    public static final String TEST_FILE_PATH = "src/main/resources/computerState/.test-file.txt";

    @AfterAll
    static void tearDown() throws IOException {
        Files.deleteIfExists(Path.of(TEST_FILE_PATH));
    }

    @Test
    void shouldWriteStateToFile() {
        given();
        Path path = Path.of(TEST_FILE_PATH);
        var computer = new Computer();
        computer.addComponent(new Monitor("foo"));
        List<String> result;

        when();
        computer.saveState(path);
        boolean exists = Files.exists(path);
        try {
            result = Files.readAllLines(path);
        } catch (IOException e) {
            throw new RuntimeException("Error while reading file in test of StateWriter", e);
        }

        then();
        assertTrue(exists);
        assertEquals(1, result.size());
        assertTrue(result.get(0).contains("foo"));

    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}