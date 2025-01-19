package pl.jkuznik.utils.persistentState;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.Component;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StateWriter {

    private final Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());
    private final Gson gson = new Gson();

    public void writeState(List<Component> components) {
        components.forEach(component -> {

        });
    }
}
