package hardware.components;

import software.file.File;

import java.util.List;
import java.util.NoSuchElementException;

public class FileStorage {

    final StorageCapacity storageCapacity;
    long currentCapacity = 0;
    List<File> files;

    public FileStorage(StorageCapacity storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public long getCapacity() {
        return storageCapacity.getSize() - currentCapacity;
    }

    public void addFile(File file) {
        files.add(file);
        currentCapacity += file.getSize();
    }

    public File getFile(File file) {
        return files.stream()
                .filter(f -> f.equals(file))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("File not found"));
    }
}
