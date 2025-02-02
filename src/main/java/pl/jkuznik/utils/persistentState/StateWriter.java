package pl.jkuznik.utils.persistentState;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.utils._enums.FilePath;
import pl.jkuznik.utils.persistentState.gsonTypeAdapter.ComponentGsonAdapter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class StateWriter {
    private final Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());

    private transient final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Component.class, new ComponentGsonAdapter())
            .create();

    public void writeState(Set<Component> components) {
        List<String> computerState = components.stream()
                .map(gson::toJson)
                .toList();

        try {
            Files.write(path, computerState);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
