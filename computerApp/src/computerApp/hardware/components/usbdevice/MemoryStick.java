package computerApp.hardware.components.usbdevice;

import computerApp.hardware.components.shared.enums.ComponentType;
import computerApp.hardware.components.shared.FileHandler;
import computerApp.hardware.components.shared.FileStorage;
import computerApp.hardware.components.shared.enums.StorageCapacity;
import computerApp.software.file.File;

public class MemoryStick implements USBDevice, FileHandler {
    private final FileStorage fileStorage;
    private final String name;
    private boolean ejected = false;

    public MemoryStick(StorageCapacity storageCapacity,String name) {
        this.fileStorage = new FileStorage(storageCapacity);
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
        return ComponentType.MEMORYSTICK;
    }
}
