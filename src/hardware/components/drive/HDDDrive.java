package hardware.components.drive;

import hardware.components.shared.ComponentType;
import hardware.components.shared.FileHandler;
import hardware.components.shared.FileStorage;
import hardware.components.shared.StorageCapacity;
import software.file.File;

public class HDDDrive implements Drive, FileHandler {
    private final FileStorage fileStorage;
    private final String name;

    public HDDDrive(StorageCapacity storageCapacity, String name) {
        this.fileStorage = new FileStorage(storageCapacity);
        this.name = name;
    }

    @Override
    public void getWriteSpeed() {

    }

    @Override
    public void getReadSpeed() {

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
    public void removeFile(File file) {
        fileStorage.removeFile(file);
    }

    @Override
    public File findFile(String fileName) {
        return fileStorage.findFile(fileName);
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.DRIVE;
    }
}
