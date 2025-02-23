package pl.jkuznik.utils._enums;

import java.nio.file.Path;

public enum FilePath {
    COMPUTER_STATE("src/main/resources/computerState/.computer-state.txt");

    private final String path;

    FilePath(String path) {
        this.path = path;
    }

    public Path getPath() {
        return Path.of(path);
    }
}
