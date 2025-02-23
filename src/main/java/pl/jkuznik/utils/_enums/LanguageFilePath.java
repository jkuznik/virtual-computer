package pl.jkuznik.utils._enums;

import java.nio.file.Path;

public enum LanguageFilePath {
    PL("src/main/resources/I18N/language-pl.txt"),
    EN("src/main/resources/I18N/language-en.txt"),
    DE("src/main/resources/I18N/language-de.txt"),
    IT("src/main/resources/I18N/language-it.txt"),
    FR("src/main/resources/I18N/language-fr.txt"),
    ES("src/main/resources/I18N/language-es.txt");

    private final String path;

    LanguageFilePath(String path) {
        this.path = path;
    }

    public Path getPath() {
        return Path.of(path);
    }
}
