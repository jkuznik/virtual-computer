package hardware.components.shared;

import hardware.components.shared.enums.StorageCapacity;
import software.file.File;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class FileHandler {

    private final StorageCapacity storageCapacity;
    private long currentCapacity = 0;
    private List<File> files = new ArrayList<>();

    public FileHandler(StorageCapacity storageCapacity) {
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
//         files.forEach(System.out::println);
        for (File file : files) {
            System.out.println(file.getName());
        }
    }

}
