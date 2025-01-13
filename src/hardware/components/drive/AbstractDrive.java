package hardware.components.drive;

import hardware.components.shared.FileStorage;
import hardware.components.shared.FileHandler;
import hardware.components.shared.enums.ComponentType;
import hardware.components.shared.enums.StorageCapacity;
import software.file.File;

public abstract class AbstractDrive implements Drive, FileStorage {
    private final FileHandler fileHandler;
    private final String name;

    public AbstractDrive(StorageCapacity storageCapacity, String name) {
        this.fileHandler = new FileHandler(storageCapacity);
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
        fileHandler.addFile(file);
    }

    @Override
    public void listFiles() {
        fileHandler.listFiles();
    }

    @Override
    public void removeFile(File file) {
        fileHandler.removeFile(file);
    }

    @Override
    public File findFile(String fileName) {
        return fileHandler.findFile(fileName);
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
