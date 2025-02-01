package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.utils.consoleReader.ConsoleReader;
import pl.jkuznik.utils.enums.MenuMessage;
import pl.jkuznik.utils.langueHandler.LangueHandler;

class HardwareMenu {
    private final static ConsoleReader consoleReader = ConsoleReader.getInstance();
    private static UserChoice userChoice;

    private static final int ESTIMATED_COMPONENT_TYPE_NAME_LENGTH = 15;

    private HardwareMenu() {}

    public static void hardwareMenu(Computer computer) {
        do {
            // TODO: dodać wsparcie poniższego komunikatu dla wszystkich języków - aktualnie działający język to PL
            LangueHandler.displayMessage(MenuMessage.HARDWARE_MENU_MESSAGE);
            userChoice = UserChoice.userChoice(consoleReader.getScanner().nextLine(), SubMenu.HARDWARE_MENU);

            switch (userChoice) {
                case LIST_COMPONENTS -> listComponents(computer);
                case ADD_COMPONENT -> System.out.println("add");
                case UPDATE_COMPONENT -> System.out.println("update");
                case DELETE_COMPONENT -> System.out.println("delete");
                case BACK -> System.out.println(System.lineSeparator() + "Menu główne!");
                case EXIT -> System.exit(0);
                default -> LangueHandler.displayMessage(MenuMessage.ERROR_MESSAGE);
            }
        } while(!userChoice.equals(UserChoice.BACK));
    }

    private static void listComponents(Computer computer) {
        computer.getAllComponents().forEach(component -> {
            System.out.print(component.getComponentType());
            for(int i = component.getComponentType().toString().length(); i< ESTIMATED_COMPONENT_TYPE_NAME_LENGTH; i++) {
                System.out.print(" ");
            }
            System.out.print(": " + component.getComponentName() + System.lineSeparator());
        });
    }

    private static void addComponent(Computer computer) {

    }
}
