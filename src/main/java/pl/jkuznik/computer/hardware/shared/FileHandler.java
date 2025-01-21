package pl.jkuznik.computer.hardware.shared;

import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

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

    public File findFile(String fileName) throws FileNotFoundException {
        return files.stream()
                .filter(f -> f.getName().equals(fileName))
                .findFirst()
                .orElseThrow(() -> new FileNotFoundException("File " + fileName + " not found"));
    }

    public void getFiles() {
        for (File file : files) {
            System.out.println(file.getName());
        }
        System.out.println();
    }

}
