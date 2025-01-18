package pl.jkuznik.utils.persistentState;

public enum FilePath {
    COMPUTER_STATE("src/main/java/pl/jkuznik/utils/persistentState/.computer-state.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
