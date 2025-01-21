package pl.jkuznik.utils.persistentState;

import pl.jkuznik.computer.hardware.shared.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Set;

public class StateWriter {
    private final Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());

    public void writeState(Set<Component> components) {
        List<String> computerState = components.stream()
                .map(Component::toJson)
                .toList();

        try {
            Files.write(path, computerState);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
