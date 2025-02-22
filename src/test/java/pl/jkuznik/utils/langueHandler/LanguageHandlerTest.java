package pl.jkuznik.utils.langueHandler;

import org.junit.jupiter.api.Test;
import pl.jkuznik.utils._enums.LanguageFilePath;
import pl.jkuznik.utils._enums.MenuMessage;

import java.util.*;

import static pl.jkuznik.utils.langueHandler.LanguageHandler.loadLanguage;

class LanguageHandlerTest {


    @Test
    void shouldNotThrowException_whenAllMessagesAreImplementedCorrectly() {
        given();
        List<Map<MenuMessage, List<String>>> lanuguageList = new ArrayList<>();

        when();
        Arrays.stream(LanguageFilePath.values())
                .forEach(path -> {
                    lanuguageList.add(loadLanguage(path));
                    lanuguageList.forEach(language -> {
                        Set<MenuMessage> menuMessages = language.keySet();

                        menuMessages.forEach(menuMessage -> {
                            try {
                                language.get(menuMessage).getFirst();
                            } catch (NoSuchElementException e) {
                                throw new AssertionError("Language " + path.name() + " is not implemented. " +
                                        "Message: " + menuMessage + " is empty.");
                            }
                        });
                    });
                });
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}