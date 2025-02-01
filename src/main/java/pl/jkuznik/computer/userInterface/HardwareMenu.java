package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.utils.consoleReader.ConsoleReader;
import pl.jkuznik.utils.enums.MenuMessage;
import pl.jkuznik.utils.langueHandler.LangueHandler;

class HardwareMenu {
    private final static ConsoleReader consoleReader = ConsoleReader.getInstance();
    private static UserChoice userChoice;

    private HardwareMenu() {}

    public static void hardwareMenu(Computer computer) {
        do {
            // TODO: dodać wsparcie poniższego komunikatu dla wszystkich języków - aktualnie działający język to PL
            LangueHandler.displayMessage(MenuMessage.HARDWARE_MENU_MESSAGE);
            userChoice = UserChoice.userChoice(consoleReader.getScanner().nextLine(), SubMenu.HARDWARE_MENU);

            switch (userChoice) {
                case LIST_COMPONENTS -> System.out.println("list");
                case ADD_COMPONENT -> System.out.println("add");
                case UPDATE_COMPONENT -> System.out.println("update");
                case DELETE_COMPONENT -> System.out.println("delete");
                case BACK -> System.out.println(System.lineSeparator() + "Menu główne!");
                case EXIT -> System.exit(0);
                default -> LangueHandler.displayMessage(MenuMessage.ERROR_MESSAGE);
            }
        } while(!userChoice.equals(UserChoice.BACK));

    }
}
