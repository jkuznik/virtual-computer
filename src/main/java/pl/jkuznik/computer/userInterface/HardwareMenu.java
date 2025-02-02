package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.hardware.components.drive.HDDDrive;
import pl.jkuznik.computer.hardware.components.drive.SSDDrive;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.utils.consoleReader.ConsoleReader;
import pl.jkuznik.utils.enums.MenuMessage;
import pl.jkuznik.utils.langueHandler.LangueHandler;

import java.util.Arrays;
import java.util.Locale;

import static pl.jkuznik.utils.langueHandler.LangueHandler.displayMessage;

class HardwareMenu {
    private final static ConsoleReader consoleReader = ConsoleReader.getInstance();
    private static UserChoice userChoice;

    private static final int ESTIMATED_COMPONENT_TYPE_NAME_LENGTH = 15;

    private HardwareMenu() {
    }

    public static void hardwareMenu(Computer computer) {
        do {
            // TODO: dodać wsparcie poniższego komunikatu dla wszystkich języków - aktualnie działający język to PL
            displayMessage(MenuMessage.HARDWARE_MENU_MESSAGE);
            userChoice = UserChoice.userChoice(consoleReader.getScanner().nextLine(), SubMenu.HARDWARE_MENU);

            switch (userChoice) {
                case LIST_COMPONENTS -> listComponents(computer);
                case ADD_COMPONENT -> addComponent(computer);
                case UPDATE_COMPONENT -> System.out.println("update");
                case DELETE_COMPONENT -> System.out.println("delete");
                case BACK -> System.out.println(System.lineSeparator() + "Menu główne!");
                case EXIT -> System.exit(0);
                default -> displayMessage(MenuMessage.ERROR_MESSAGE);
            }
        } while (!userChoice.equals(UserChoice.BACK));
    }

    private static void listComponents(Computer computer) {
        computer.getAllComponents().forEach(component -> {
            System.out.print(component.getComponentType());
            for (int i = component.getComponentType().toString().length(); i < ESTIMATED_COMPONENT_TYPE_NAME_LENGTH; i++) {
                System.out.print(" ");
            }
            System.out.print(": " + component.getComponentName() + System.lineSeparator());
        });
    }

    private static void addComponent(Computer computer) {
        displayMessage(MenuMessage.ADD_COMPONENT_TYPE_MESSAGE);
        ComponentType[] componentTypes = ComponentType.values();
        StorageCapacity[] storageCapacities = StorageCapacity.values();
        int componentTypeIterator = 1;
        int storageCapacityIterator = 1;
        for (ComponentType componentType : componentTypes) {
            System.out.println(componentTypeIterator + " " + componentType);
            componentTypeIterator++;
        }

        ComponentType typeUserChoice;
        try {
            typeUserChoice = componentTypes[
                    Integer.parseInt
                            (consoleReader.getScanner().nextLine())
                            - 1];

            displayMessage(MenuMessage.ADD_COMPONENT_NAME_MESSAGE);
            String name = consoleReader.getScanner().nextLine();
            switch (typeUserChoice) {
                case HDD -> {
                    displayMessage(MenuMessage.ADD_DRIVE_CAPACITY_MESSAGE);
                    for (StorageCapacity storageCapacity : storageCapacities) {
                        System.out.println(storageCapacityIterator + " " + storageCapacity);
                        storageCapacityIterator++;
                    }

                    try {
                        StorageCapacity capacityUserChoice = storageCapacities[
                                Integer.parseInt
                                        (consoleReader.getScanner().nextLine())
                                        - 1];
                        computer.addComponent(new HDDDrive(capacityUserChoice, name));

                    } catch (RuntimeException e) {  // safe block for wrong storage capacity choose case
                        displayMessage(MenuMessage.ERROR_MESSAGE);
                    }
                }
                case SSD -> {
                    displayMessage(MenuMessage.ADD_DRIVE_CAPACITY_MESSAGE);
                    for (StorageCapacity storageCapacity : storageCapacities) {
                        System.out.println(storageCapacityIterator + " " + storageCapacity);
                        storageCapacityIterator++;
                    }

                    try {
                        StorageCapacity capacityUserChoice = storageCapacities[
                                Integer.parseInt
                                        (consoleReader.getScanner().nextLine())
                                        - 1];
                        computer.addComponent(new SSDDrive(capacityUserChoice, name));

                    } catch (RuntimeException e) {  // safe block for wrong storage capacity choose case
                        displayMessage(MenuMessage.ERROR_MESSAGE);
                    }
                }
                case MONITOR -> {
                }
                case MOUSE -> {
                }
                case KEYBOARD -> {
                }
                case MEMORY_STICK -> {
                }
                case HEADPHONES -> {
                }
            }


        } catch (RuntimeException e) {  // safe block for wrong component type choose case
            displayMessage(MenuMessage.ERROR_MESSAGE);
        }
    }
}
