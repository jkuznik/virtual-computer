package pl.jkuznik.utils._enums;

public enum FilePath {
    COMPUTER_STATE("src/main/resources/computerState/.computer-state.txt"),

    LANGUE_PL("src/main/resources/I18N/langue-pl.txt"),
    LANGUE_EN("src/main/resources/I18N/langue-en.txt"),
    LANGUE_DE("src/main/resources/I18N/langue-de.txt"),
    LANGUE_IT("src/main/resources/I18N/langue-it.txt"),
    LANGUE_FR("src/main/resources/I18N/langue-fr.txt"),
    LANGUE_ES("src/main/resources/I18N/langue-es.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
