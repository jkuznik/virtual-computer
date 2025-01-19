package pl.jkuznik.computer.hardware.components.usbdevice;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.FileStorage;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;

public class MemoryStick implements USBDevice, FileStorage {
    private final FileHandler fileHandler;
    private final String name;
    private boolean ejected = false;

    private transient final Gson gson = new Gson();

    public MemoryStick(StorageCapacity storageCapacity, String name) {
        this.fileHandler = new FileHandler(storageCapacity);
        this.name = name;
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
        return ComponentType.MEMORYSTICK;
    }

    @Override
    public String toJson() {
        return gson.toJson(this);
    }
}
