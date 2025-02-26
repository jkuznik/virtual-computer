package pl.jkuznik.computer.hardware.components.drive;

import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;

public class SSDDrive extends AbstractDrive{

    public SSDDrive(FileHandler fileHandler, String name, ReadWriteSpeed readWriteSpeed) {
        super(fileHandler, name, readWriteSpeed);
    }

    public SSDDrive(StorageCapacity storageCapacity, String name, ReadWriteSpeed readWriteSpeed) {
        super(storageCapacity, name, readWriteSpeed);
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.SSD;
    }
}
