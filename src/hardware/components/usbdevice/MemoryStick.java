package hardware.components.usbdevice;

import hardware.components.shared.enums.ComponentType;
import hardware.components.shared.FileStorage;
import hardware.components.shared.FileHandler;
import hardware.components.shared.enums.StorageCapacity;
import software.file.File;

public class MemoryStick implements USBDevice, FileStorage {
    private final FileHandler fileHandler;
    private final String name;
    private boolean ejected = false;

    public MemoryStick(StorageCapacity storageCapacity,String name) {
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
    public File findFile(String fileName) {
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
