package hardware.components;

import software.file.File;

import java.util.List;
import java.util.NoSuchElementException;

public class FileStorage {

    int capacity;

    List<File> files;

    public FileStorage(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public void addFile(File file) {
        files.add(file);
        capacity -= file.getSize();
    }

    public File getFile(File file) {
        return files.stream()
                .filter(f -> f.equals(file))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("File not found"));
    }
}
