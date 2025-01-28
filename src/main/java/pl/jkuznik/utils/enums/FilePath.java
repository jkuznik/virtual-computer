package pl.jkuznik.utils.enums;

public enum FilePath {
    COMPUTER_STATE("src/main/resources/computerState/.computer-state.txt"),

    LANGUE_PL("src/main/resources/I18N/langue-pl.txt"),
    LANGUE_EN("src/main/resources/I18N/langue-en.txt"),
    LANGUE_DE("src/main/resources/I18N/langue-de.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
