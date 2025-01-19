package pl.jkuznik.utils.persistentState;

import pl.jkuznik.computer.hardware.shared.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StateReader {

    private final Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());


    public List<Component> readState(){
        try {
            List<String> lines = Files.readAllLines(path);

        } catch (IOException e) {
            System.out.println("File .computer-state.txt not found");
        }
        return null;
    }
}
