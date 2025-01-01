package hardware.components;

import software.file.File;

import java.util.List;

public class FileStorage {

    final int capacity;

    List<File> files;

    public FileStorage(int capacity) {
        this.capacity = capacity;
    }
}
