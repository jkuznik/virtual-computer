package hardware.components.drive;

import hardware.components.shared.enums.StorageCapacity;

public class HDDDrive extends AbstractDrive{

    public HDDDrive(StorageCapacity storageCapacity, String name) {
        super(storageCapacity, name);
    }
}
