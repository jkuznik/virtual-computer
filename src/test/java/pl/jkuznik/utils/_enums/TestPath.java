package pl.jkuznik.utils._enums;

import java.nio.file.Path;

public enum TestPath {

    TEST_FILE_PATH("src/test/resources/.test-file.txt"),
    TEST_EXPECTED_VALUES("src/test/resources/.json-assertions.txt");

    private String path;

    TestPath(String path) {
        this.path = path;
    }

    public Path getPath() {
        return Path.of(path);
    }
}
