package pl.jkuznik.computer.hardware.components.usbdevice;

import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.FileStorage;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;
import java.util.List;

public class MemoryStick implements USBDevice, FileStorage {
    private final FileHandler fileHandler;
    private final String name;
    private boolean ejected = false;

    public MemoryStick(StorageCapacity storageCapacity, String name) {
        this.fileHandler = new FileHandler(storageCapacity);
        this.name = name;
    }

    public MemoryStick(FileHandler fileHandler, String name) {
        this.fileHandler = fileHandler;
        this.name = name;
    }

    public FileHandler getFileHandler() {
        return fileHandler;
    }

    public String getName() {
        return name;
    }

    public boolean isEjected() {
        return ejected;
    }

    @Override
    public boolean connect() {
        System.out.println("Connected Memory Stick");
        return true;
    }

    @Override
    public boolean disconnect() {
        if (!ejected) {
            System.out.println("Please eject Memory Stick first");
            return false;
        } else {
            System.out.println("Memory Stick disconnected");
            return true;
        }
    }

    public void eject() {
        System.out.println("Ejecting Memory Stick");
        ejected = true;
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
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MEMORYSTICK;
    }

}
