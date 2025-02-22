package pl.jkuznik.utils.langueHandler;

import pl.jkuznik.utils._enums.FilePath;
import pl.jkuznik.utils._enums.LanguageFilePath;
import pl.jkuznik.utils._enums.MenuMessage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LanguageHandler {

    private final static Map<MenuMessage, List<String>> messages = new HashMap<>();

    public static Map<MenuMessage, List<String>> loadLanguage(LanguageFilePath filePath) {
        Path path = filePath.getPath();
        try {
            List<String> lines = Files.readAllLines(path);

            List<String[]> processedLines = lines.stream()
                    .filter(line -> !line.trim().isEmpty())
                    .map(line -> line.split(";"))
                    .toList();

            for (String[] processedLine : processedLines) {
                MenuMessage menuMessage = MenuMessage.valueOf(processedLine[0]);

                // TODO: doadać zwracanie komunikatu w pzypadku wczytania pustego komunikatu dla jakiejkolwiek warsości MenuMessage
                messages.put(menuMessage, Arrays.asList(Arrays.copyOfRange(processedLine, 1, processedLine.length)));
            }
        } catch (IOException e) {
            System.out.println("Nie udało się odczytać pliku: " + filePath.name());
        }
        return messages;
    }

    public static void displayMessage(MenuMessage menuMessage) {
        messages.get(menuMessage).forEach(System.out::println);
    }
}
