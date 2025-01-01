package hardware.components.drive;

import hardware.components.FileStorage;
import hardware.components.StorageCapacity;
import software.file.File;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class SSDDrive implements Drive {
    private final FileStorage fileStorage;

    public SSDDrive(StorageCapacity storageCapacity) {
        this.fileStorage = new FileStorage(storageCapacity);
    }

    @Override
    public void addFile(File file) {
        fileStorage.addFile(file);
    }

    @Override
    public void listFiles() {
        fileStorage.listFiles();
    }

    @Override
    public File findFile(String fileName) {
        return fileStorage.findFile(fileName);
    }
}
