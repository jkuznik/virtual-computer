package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.utils.consoleReader.ConsoleReader;

import static pl.jkuznik.computer.userInterface.UserChoice.*;
import static pl.jkuznik.utils.enums.FilePath.*;
import static pl.jkuznik.utils.enums.MenuMessage.*;
import static pl.jkuznik.utils.langueHandler.LangueHandler.displayMessage;
import static pl.jkuznik.utils.langueHandler.LangueHandler.loadLangue;

public class UserInterface {
    private final static Computer computer = new Computer();
    private final static ConsoleReader consoleReader = ConsoleReader.getInstance();
    private static UserChoice userChoice;

    public static void languageMenu() {
        ComputerBootstrap.run(computer);
        loadLangue(LANGUE_PL);
        displayMessage(GREETINGS_MESSAGE);

        do {
            displayMessage(LANGUE_MENU_MESSAGE);
            userChoice = userChoice(consoleReader.getScanner().nextLine(), SubMenu.LANGUE_MENU);

            switch (userChoice) {
                case PL -> loadLangue(LANGUE_PL);
                case EN -> loadLangue(LANGUE_EN);
                case DE -> loadLangue(LANGUE_DE);
                case IT -> loadLangue(LANGUE_IT);
                case FR -> loadLangue(LANGUE_FR);
                case ES -> loadLangue(LANGUE_ES);
                case EXIT -> System.exit(0);
                case DEFAULT -> System.out.println("Błąd, spróbuj ponownie!");
            }
            userInterface();
        } while (!userChoice.equals(EXIT));
    }

    public static void userInterface() {
        do {
            displayMessage(MAIN_MENU_MESSAGE);
            userChoice = userChoice(consoleReader.getScanner().nextLine(), SubMenu.MAIN_MENU);

            switch (userChoice) {
                // TODO: dodać możliwość zarządzania podzespołąmi wraz z możliwośćia zapisu i odczytu
                case HARDWARE_MENU ->
                        computer.getAllComponents().forEach(component -> System.out.println(component.getComponentName()));
                case SOFTWARE_MENU -> FileMenu.displayMenu(computer);
                case EXIT -> System.exit(0);
                case DEFAULT -> displayMessage(ERROR_MESSAGE);
            }
        } while (!userChoice.equals(BACK));
    }
}
