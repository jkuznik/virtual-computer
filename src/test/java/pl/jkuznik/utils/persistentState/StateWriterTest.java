package pl.jkuznik.utils.persistentState;

import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.utils.computerBootstrap.ComputerBootstrap;

import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class StateWriterTest {

    public static final String TEST_FILE_PATH = "src/main/resources/computerState/.test-file.txt";

    @Test
    void shouldWriteStateToFile() {
        given();
        Path path = Path.of(TEST_FILE_PATH);
        var computer = new Computer();
        ComputerBootstrap.run(computer);


    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}