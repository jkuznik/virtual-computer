package hardware.components.drive;

import hardware.components.shared.enums.ComponentType;
import hardware.components.shared.FileHandler;
import hardware.components.shared.FileStorage;
import hardware.components.shared.enums.StorageCapacity;
import software.file.File;

public class SSDDrive implements Drive, FileHandler {
    private final FileStorage fileStorage;
    private final String name;

    public SSDDrive(StorageCapacity storageCapacity, String name) {
        this.fileStorage = new FileStorage(storageCapacity);
        this.name = name;
    }

    //  TODO: metoda do zaimplementowania w kolejnym tasku
    @Override
    public void getWriteSpeed() {

    }

    //  TODO: metoda do zaimplementowania w kolejnym tasku
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
