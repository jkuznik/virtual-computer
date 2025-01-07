package main.hardware.components.drive;

import main.hardware.components.shared.enums.StorageCapacity;

public class SSDDrive extends AbstractDrive{

    //TODO: dodać pola w klasie HDDDrive oraz SDDDrive rozróżniające te dwie klasy lub dodać nowe typy w ComponentType
    // dedykowane dla HDD oraz SDD i nadpisać metody getComponentType() w tych klasach
    public SSDDrive(StorageCapacity storageCapacity, String name) {
        super(storageCapacity, name);
    }
}
