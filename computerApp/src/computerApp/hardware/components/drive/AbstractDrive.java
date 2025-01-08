package computerApp.hardware.components.drive;

import computerApp.hardware.components.shared.FileHandler;
import computerApp.hardware.components.shared.FileStorage;
import computerApp.hardware.components.shared.enums.ComponentType;
import computerApp.hardware.components.shared.enums.StorageCapacity;
import computerApp.software.file.File;

public abstract class AbstractDrive implements Drive, FileHandler {
    private final FileStorage fileStorage;
    private final String name;

    public AbstractDrive(StorageCapacity storageCapacity, String name) {
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
