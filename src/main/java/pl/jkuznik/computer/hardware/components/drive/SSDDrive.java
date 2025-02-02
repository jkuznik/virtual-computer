package pl.jkuznik.computer.hardware.components.drive;

import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;

public class SSDDrive extends AbstractDrive{

    //TODO: dodać pola w klasie HDDDrive oraz SDDDrive rozróżniające te dwie klasy lub dodać nowe typy w ComponentType
    // dedykowane dla HDD oraz SDD i nadpisać metody getComponentType() w tych klasach
    public SSDDrive(StorageCapacity storageCapacity, String name) {
        super(storageCapacity, name);
    }

    public SSDDrive(FileHandler fileHandler, String name) {
        super(fileHandler, name);
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.SSD;
    }
}
