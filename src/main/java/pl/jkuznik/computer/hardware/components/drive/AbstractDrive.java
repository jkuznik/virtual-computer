package pl.jkuznik.computer.hardware.components.drive;

import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.FileStorage;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;
import java.util.List;

public abstract class  AbstractDrive implements Drive, FileStorage {
    protected final FileHandler fileHandler;
    protected final String name;
    protected final ReadWriteSpeed readWriteSpeed;

    public AbstractDrive(StorageCapacity storageCapacity, String name, ReadWriteSpeed readWriteSpeed) {
        this.fileHandler = new FileHandler(storageCapacity);
        this.name = name;
        this.readWriteSpeed = readWriteSpeed;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public String getName() {
        return name;
    }

    @Override
    public void addFile(File file) {
        fileHandler.addFile(file);
    }

    @Override
    public List<File> getFiles() {
        return fileHandler.getFiles();
    }

    @Override
    public void removeFile(File file) {
        fileHandler.removeFile(file);
    }

    @Override
    public File findFile(String fileName) throws FileNotFoundException {
        return fileHandler.findFile(fileName);
    }

    @Override
    public void getWriteSpeed() {

    }

    @Override
    public void getReadSpeed() {

    }

    @Override
    public String getComponentName() {
        return name;
    }
}
