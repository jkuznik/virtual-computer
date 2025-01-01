package hardware.components.shared;

import software.file.File;

import java.util.List;
import java.util.NoSuchElementException;

public class FileStorage {

    private final StorageCapacity storageCapacity;
    private long currentCapacity = 0;
    private List<File> files;

    public FileStorage(StorageCapacity storageCapacity) {
        this.storageCapacity = storageCapacity;
    }

    public long getEmptyCapacity() {
        return storageCapacity.getSize() - currentCapacity;
    }

    public void addFile(File file) {
        files.add(file);
        currentCapacity += file.getSize();
    }

    public void removeFile(File file) {
        if (files.contains(file)) {
            files.remove(file);
            currentCapacity -= file.getSize();
        }
    }

    public File findFile(String fileName) {
        return files.stream()
                .filter(f -> f.getName().equals(fileName))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("File not found"));
    }

    public void listFiles() {
        files.forEach(System.out::println);
    }
}
