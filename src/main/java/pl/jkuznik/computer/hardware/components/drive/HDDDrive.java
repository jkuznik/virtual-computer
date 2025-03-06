package pl.jkuznik.computer.hardware.components.drive;

import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;

public class HDDDrive extends AbstractDrive{

    public HDDDrive(FileHandler fileHandler, String name, ReadWriteSpeed readWriteSpeed) {
        super(fileHandler, name, readWriteSpeed);
    }

    public HDDDrive(StorageCapacity storageCapacity, String name, ReadWriteSpeed readWriteSpeed) {
        super(storageCapacity, name, readWriteSpeed);
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.HDD;
    }

    @Override
    public String toString() {
        return  "Name= " + name + '\n' +
                "Read speed= " + readWriteSpeed.readSpeed() + '\n' +
                "Write speed= " + readWriteSpeed.writeSpeed() + '\n' +
                "Storage capacity= " + fileHandler.getStorageCapacity().name() + '\n' +
                "Current capacity= " + fileHandler.getCurrentCapacity();
    }
}
