package pl.jkuznik.computer.hardware.components.drive;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.FileStorage;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;

public abstract class AbstractDrive implements Drive, FileStorage {
    private final FileHandler fileHandler;
    private final String name;

    private transient final Gson gson = new Gson();

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
    public File findFile(String fileName) throws FileNotFoundException {
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

    @Override
    public String toJson() {
        return gson.toJson(this);
    }
}
