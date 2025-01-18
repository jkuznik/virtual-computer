package pl.jkuznik.utils.persistentState;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class StateReader {

    private final Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());

    public void readFile(){
        try {
            List<String> lines = Files.readAllLines(path);

            lines.forEach(line -> System.out.println(line));
        } catch (IOException e) {
            System.out.println("File about computer state not found");
        }
    }
}
