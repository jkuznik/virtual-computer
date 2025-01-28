package pl.jkuznik.utils.langueReader;

import pl.jkuznik.utils.enums.FilePath;
import pl.jkuznik.utils.enums.MenuMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LangueReader {

    public Map<MenuMessage, List<String>> getMessages(FilePath filePath) {
        Path path = Paths.get(filePath.getPath());
        Map<MenuMessage, List<String>> messages = new HashMap<>();
        try {
            List<String> lines = Files.readAllLines(path);

            List<String[]> processedLines = lines.stream()
                    .map(line -> line.split(";"))
                    .toList();

            for (String[] processedLine : processedLines) {
                MenuMessage menuMessage = MenuMessage.valueOf(processedLine[0]);

                messages.put(menuMessage, Arrays.asList(Arrays.copyOfRange(processedLine, 1, processedLine.length)));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return messages;
    }
}
