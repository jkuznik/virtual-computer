package pl.jkuznik.utils.persistentState.gsonTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerAdapterGsonTest {

    private final Map<String, String> preparedValues = PreparedAssertion.read();
    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(FileHandler.class, new FileHandlerAdapterGson())
            .registerTypeHierarchyAdapter(File.class, new FileAdapterGson())
            .create();

    @Test
    void shouldSerializeEmptyFileHandler_whenFileHandlerIsValidAndEmpty() {
        given();
        var fileHandler = new FileHandler(StorageCapacity.GB1);

        when();
        String result = gson.toJson(fileHandler);
        System.out.println(result);

        then();
        Assertions.assertEquals(preparedValues.get("EmptyFileHandler"), result);
    }

    @Test
    void shouldSerializeFilledFileHandler_whenFileHandlerIsValidAndContainsFiles() {
        given();
        var fileHandler = new FileHandler(StorageCapacity.GB1);
        var file = new JPGImageFile("foo", 5, 5);
        fileHandler.addFile(file);

        when();
        String result = gson.toJson(fileHandler);

        System.out.println(result);

        then();
        assertEquals(preparedValues.get("FilledFileHandler"), result);

    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}