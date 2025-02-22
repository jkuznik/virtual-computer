package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.userInterface._enums.SubMenu;
import pl.jkuznik.computer.userInterface._enums.UserChoice;
import pl.jkuznik.utils.computerBootstrap.ComputerBootstrap;
import pl.jkuznik.utils.consoleReader.ConsoleReader;

import static pl.jkuznik.computer.userInterface.HardwareMenu.hardwareMenu;
import static pl.jkuznik.computer.userInterface.SoftwareMenu.softwareMenu;
import static pl.jkuznik.computer.userInterface._enums.UserChoice.*;
import static pl.jkuznik.utils._enums.FilePath.COMPUTER_STATE;
import static pl.jkuznik.utils._enums.LanguageFilePath.DE;
import static pl.jkuznik.utils._enums.LanguageFilePath.EN;
import static pl.jkuznik.utils._enums.LanguageFilePath.ES;
import static pl.jkuznik.utils._enums.LanguageFilePath.FR;
import static pl.jkuznik.utils._enums.LanguageFilePath.IT;
import static pl.jkuznik.utils._enums.LanguageFilePath.PL;
import static pl.jkuznik.utils._enums.MenuMessage.*;
import static pl.jkuznik.utils.langueHandler.LanguageHandler.displayMessage;
import static pl.jkuznik.utils.langueHandler.LanguageHandler.loadLanguage;

public class UserInterface {
    private final static Computer computer = new Computer();
    private final static ConsoleReader consoleReader = ConsoleReader.getInstance();
    private static UserChoice userChoice;

    public static void userInterface() {
        computer.loadState();
        loadLanguage(PL);
        displayMessage(GREETINGS_MESSAGE);

        do {
            displayMessage(MAIN_MENU_MESSAGE);
            userChoice = userChoice(consoleReader.getScanner().nextLine(), SubMenu.MAIN_MENU);

            switch (userChoice) {
                // TODO: dodać możliwość zarządzania podzespołąmi wraz z możliwośćia zapisu i odczytu
                case HARDWARE_MENU -> hardwareMenu(computer);
                case SOFTWARE_MENU -> softwareMenu(computer);
                case LANGUE_OPTION -> languageMenu();
                case DEFAULT_SETTINGS -> defaultSettings();
                case EXIT -> {
                    return;
                }
                default -> displayMessage(ERROR_MESSAGE);
            }
        } while (!userChoice.equals(EXIT));
    }

    private static void languageMenu() {
        do {
            displayMessage(LANGUAGE_MENU_MESSAGE);
            userChoice = userChoice(consoleReader.getScanner().nextLine(), SubMenu.LANGUE_MENU);

            switch (userChoice) {
                case PL -> {
                    loadLanguage(PL);
                    return;
                }
                case EN -> {
                    loadLanguage(EN);
                    return;
                }
                case DE -> {
                    loadLanguage(DE);
                    return;
                }
                case IT -> {
                    loadLanguage(IT);
                    return;
                }
                case FR -> {
                    loadLanguage(FR);
                    return;
                }
                case ES -> {
                    loadLanguage(ES);
                    return;
                }
                case BACK -> {
                    return;
                }
                default -> System.out.println("Błąd, spróbuj ponownie!");
            }
        } while (!userChoice.equals(BACK));
    }

    private static void defaultSettings() {
        computer.getAllComponents().clear();
        ComputerBootstrap.run(computer);
        computer.saveState(COMPUTER_STATE.getPath());
    }
}
