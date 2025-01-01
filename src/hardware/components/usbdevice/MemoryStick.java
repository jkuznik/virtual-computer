package hardware.components.usbdevice;

import hardware.components.shared.ComponentType;
import hardware.components.shared.FileStorage;
import hardware.components.shared.StorageCapacity;

public class MemoryStick implements USBDevice {
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
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MEMORYSTICK;
    }
}
