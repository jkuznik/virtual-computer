package hardware.components.drive;

import hardware.components.shared.enums.StorageCapacity;

public class SSDDrive extends AbstractDrive{

    public SSDDrive(StorageCapacity storageCapacity, String name) {
        super(storageCapacity, name);
    }
}
