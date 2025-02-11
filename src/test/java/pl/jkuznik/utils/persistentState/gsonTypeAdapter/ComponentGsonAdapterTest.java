package pl.jkuznik.utils.persistentState.gsonTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.components.drive.HDDDrive;
import pl.jkuznik.computer.hardware.components.drive.SSDDrive;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.utils.persistentState.PersistentStateTest;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ComponentGsonAdapterTest {
    private final Map<String, String> expectedValues = readExpectedValues();
    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Component.class, new ComponentGsonAdapter())
            .create();

    @Test
    void shouldSerializeComponent_whenComponentIsHDDType() {
        given();
        var HDDComponent = new HDDDrive(StorageCapacity.GB1, "foo");

        when();
        String json = gson.toJson(HDDComponent);

        then();
        assertEquals(expectedValues.get("HDD"), json);
    }

    @Test
    void shouldSerializeComponent_whenComponentIsSSDType() {
        given();
        var SSDComponent = new SSDDrive(StorageCapacity.GB1, "foo");

        when();
        String json = gson.toJson(SSDComponent);

        then();
        assertEquals(expectedValues.get("SSD"), json);
    }

    @Test
    void deserialize() {
    }

    private Map<String, String> readExpectedValues() {
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

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}