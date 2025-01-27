package pl.jkuznik.utils.persistentState;

public enum FilePath {
    COMPUTER_STATE("src/main/resources/computerState/.computer-state.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }
}
