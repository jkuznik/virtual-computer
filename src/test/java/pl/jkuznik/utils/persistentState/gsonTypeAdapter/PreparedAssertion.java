package pl.jkuznik.utils.persistentState.gsonTypeAdapter;

import pl.jkuznik.utils.persistentState.PersistentStateTest;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PreparedAssertion {

    public static Map<String, String> read() {
        Map<String, String> expectedValues;
        try {
            List<String> values = Files.readAllLines(PersistentStateTest.TEST_EXPECTED_VALUES);
            expectedValues = values.stream()
                    .map(value -> value.split(";"))
                    .filter(array -> array.length == 2) // to avoid exception in case of empty lines or etc.
                    .collect(Collectors.toMap(parts -> parts[0], parts -> parts[1]));
        } catch (IOException e) {
            throw new RuntimeException("Error while read expected values from", e);
        }
        return expectedValues;
    }
}
