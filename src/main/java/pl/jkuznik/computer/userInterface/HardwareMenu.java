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
            LangueHandler.displayMessage(MenuMessage.HARDWARE_MENU_MESSAGE);
        } while(true);

    }
}
