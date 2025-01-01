package hardware.components.usbdevice;

import hardware.components.FileStorage;
import hardware.components.StorageCapacity;

public class MemoryStick implements USBDevice {
    private final FileStorage fileStorage;
    private final String name;
    private boolean ejected = false;

    public MemoryStick(String name, StorageCapacity storageCapacity) {
        this.name = name;
        this.fileStorage = new FileStorage(storageCapacity);
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
    public String getName() {
        return name;
    }
}
