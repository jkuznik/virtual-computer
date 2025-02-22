package pl.jkuznik.utils._enums;

import java.nio.file.Path;

public enum LanguageFilePath {
    PL("src/main/resources/I18N/langue-pl.txt"),
    EN("src/main/resources/I18N/langue-en.txt"),
    DE("src/main/resources/I18N/langue-de.txt"),
    IT("src/main/resources/I18N/langue-it.txt"),
    FR("src/main/resources/I18N/langue-fr.txt"),
    ES("src/main/resources/I18N/langue-es.txt");

    private final String path;

    LanguageFilePath(String path) {
        this.path = path;
    }

    public Path getPath() {
        return Path.of(path);
    }
}
