package pl.jkuznik.utils.persistentState;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.components.drive.HDDDrive;
import pl.jkuznik.computer.hardware.shared.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static pl.jkuznik.utils.persistentState.PersistentStateTest.TEST_FILE_PATH;

class StateReaderTest {

    @BeforeEach
    void setUp() {
        String serializedDriveComponent = """
                {
                  "componentType": "HDD",
                  "name": "foo",
                  "fileHandler": {
                    "storageCapacity": "GB512",
                    "currentCapacity": 15,
                    "files": [
                      {
                        "fileType": "GIF",
                        "name": "bar",
                        "size": 5
                      },
                      {
                        "fileType": "JPG",
                        "name": "baz",
                        "size": 5,
                        "compression": 1
                      },
                      {
                        "fileType": "MP3",
                        "name": "test",
                        "size": 5,
                        "bandName": "test",
                        "title": "test",
                        "quality": 10
                      }
                    ]
                  }
                }
                """;
        String testJson = serializedDriveComponent.replaceAll("\\s+", " ");
        try {
            Files.writeString(TEST_FILE_PATH, testJson);
        } catch (IOException e) {
            throw new RuntimeException("Error while write test values into file in test of StateReader", e);
        }
    }
    @Test
    void shouldReadState_whileFileExists() throws IOException {
        given();
        StateReader stateReader = new StateReader();
        List<Component> components = stateReader.readState(TEST_FILE_PATH);

        when();
        boolean result = components.getFirst() instanceof HDDDrive;

        then();
        assertTrue(result);
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}