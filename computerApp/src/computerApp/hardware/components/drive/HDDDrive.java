package computerApp.hardware.components.drive;

import computerApp.hardware.components.shared.enums.StorageCapacity;

public class HDDDrive extends AbstractDrive{

    //TODO: dodać pola w klasie HDDDrive oraz SDDDrive rozróżniające te dwie klasy lub dodać nowe typy w ComponentType
    // dedykowane dla HDD oraz SDD i nadpisać metody getComponentType() w tych klasach
    public HDDDrive(StorageCapacity storageCapacity, String name) {
        super(storageCapacity, name);
    }
}
