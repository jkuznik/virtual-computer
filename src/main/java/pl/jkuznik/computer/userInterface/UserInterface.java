package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;
import pl.jkuznik.computer.hardware.components.drive.HDDDrive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.ComponentNotFoundException;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.FileType;
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;
import pl.jkuznik.computer.software.game.GameNotFoundException;
import pl.jkuznik.computer.software.program.ProgramNotFoundException;
import pl.jkuznik.utils.consoleReader.ConsoleReader;
import pl.jkuznik.utils.langueHandler.LangueHandler;

import java.io.FileNotFoundException;

import static pl.jkuznik.computer.userInterface.UserInterfaceHandler.*;
import static pl.jkuznik.utils.enums.FilePath.*;
import static pl.jkuznik.utils.enums.MenuMessage.*;
import static pl.jkuznik.utils.langueHandler.LangueHandler.*;

public class UserInterface {
    static Computer computer = new Computer();
    static ConsoleReader consoleReader = ConsoleReader.getInstance();
    static UserInterfaceHandler userInput;

    public static void languageMenu() {
        computerBootstrap();

        System.out.println("Witam!");
        do {
            System.out.println("""
                    
                    Wybierz język/Select language:
                     1.Polski!
                     2.English!
                     3.Deutsch!
                     4.Italiano!
                     5.Français!
                     6.Español!
                     9.Wyjście/Exit.
                    """);
            userInput = userChoice(consoleReader.getScanner().nextLine(), SubMenu.LANGUE_MENU);

            switch (userInput) {
                case PL -> loadLangue(LANGUE_PL);
                case EN -> loadLangue(LANGUE_EN);
                case DE -> loadLangue(LANGUE_DE);
                case IT -> loadLangue(LANGUE_IT);
                case FR -> loadLangue(LANGUE_FR);
                case ES -> loadLangue(LANGUE_ES);
                case DEFAULT -> System.out.println("Błąd, spróbuj ponownie!");
            }
            userInterface();
        } while (!userInput.equals(EXIT));
    }

    public static void userInterface() {
        displayMessage(GREETINGS_MESSAGE);
        do {
            displayMessage(MAIN_MENU_MESSAGE);
            userInput = userChoice(consoleReader.getScanner().nextLine(), SubMenu.MAIN_MENU);

            switch (userInput) {
                // TODO: dodać możliwość zarządzania podzespołąmi wraz z możliwośćia zapisu i odczytu
                case HARDWARE_MENU -> computer.getAllComponents().forEach(component -> System.out.println(component.getComponentName()));
                case SOFTWARE_MENU -> fileMenu();
                case EXIT -> System.exit(0);
                case DEFAULT -> displayMessage(ERROR_MESSAGE);
            }
        } while (!userInput.equals(BACK));
    }

    public static void fileMenu() {
        do {
            displayMessage(FILE_MENU_MESSAGE);
            userInput = userChoice(consoleReader.getScanner().nextLine(), SubMenu.SOFTWARE_MENU);

            switch (userInput) {
                case LIST_FILE -> listFiles();
                case ADD_FILE -> addFile();
                case DELETE_FILE -> deleteFile();
                case RUN_PROGRAM -> runProgram();
                case RUN_GAME -> runGame();
                case BACK -> System.out.println(System.lineSeparator() + "Menu główne!");
                case EXIT -> System.exit(0);
                case DEFAULT -> displayMessage(ERROR_MESSAGE);
            }
        } while (!userInput.equals(BACK));
    }

    private static void runGame() {
        displayMessage(RUN_GAME_MESSAGE);
        computer.getGameHandler().gameList();
        try {
            computer.getGameHandler().startGameByName(consoleReader.getScanner().nextLine());
        } catch (GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProgram() {
        displayMessage(RUN_PROGRAM_MESSAGE);
        computer.getProgramHandler().programList();
        try {
            computer.getProgramHandler().startProgramByName(consoleReader.getScanner().nextLine());
        } catch (ProgramNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listFiles() {
        try {
            computerDrive().getFiles().forEach(file -> System.out.println(file.getName()));
        } catch (ComponentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addFile() {
        String name = "name";
        int size = 0;
        int compression = 0;
        String bandName = "";
        String title = "title";
        int quality = 0;

        displayMessage(ADD_FILE_MESSAGE);
        userInput = userChoice(consoleReader.getScanner().nextLine(), SubMenu.FILE_MANAGEMENT);
        switch (userInput) {
            case JPG -> {
                displayMessage(INPUT_FILE_NAME_MESSAGE);
                name = consoleReader.getScanner().nextLine() + ".jpg";
                displayMessage(INPUT_FILE_SIZE_MESSAGE);
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                displayMessage(INPUT_FILE_COMPRESSION_MESSAGE);
                compression = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new JPGImageFile(FileType.JPG, name, size, compression));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            }
            case GIF -> {
                displayMessage(INPUT_FILE_NAME_MESSAGE);
                name = consoleReader.getScanner().nextLine() + ".gif";
                displayMessage(INPUT_FILE_SIZE_MESSAGE);
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new GIFImageFile(FileType.GIF, name, size));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            case MP3 -> {
                displayMessage(INPUT_FILE_NAME_MESSAGE);
                name = consoleReader.getScanner().nextLine() + ".mp3";
                displayMessage(INPUT_FILE_SIZE_MESSAGE);
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                displayMessage(INPUT_SONG_BAND_NAME_MESSAGE);
                bandName = consoleReader.getScanner().nextLine();
                displayMessage(INPUT_SONG_TITLE_MESSAGE);
                title = consoleReader.getScanner().nextLine();
                displayMessage(INPUT_FILE_QUALITY_MESSAGE);
                quality = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new MP3MusicFile(FileType.MP3, name, size, bandName, title, quality));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> displayMessage(ERROR_MESSAGE);
        }
    }

    private static void deleteFile() {
        displayMessage(INPUT_FILE_NAME_FOR_DELETE_MESSAGE);
        String fileName = consoleReader.getScanner().nextLine();
        try {
            File fileForDelete = computerDrive().findFile(fileName);
            computerDrive().removeFile(fileForDelete);
        } catch (ComponentNotFoundException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void computerBootstrap() {

        Monitor monitor = new Monitor("Iiyama");
        Headphones headphones = new Headphones("HyperX");
        HDDDrive hddDrive = new HDDDrive(StorageCapacity.GB512, "HDDDrive");
        MemoryStick memoryStick = new MemoryStick(StorageCapacity.GB16, "Pendrive");
        Mouse mouse = new Mouse("Zowie");

        computer.addComponent(monitor);
        computer.addComponent(headphones);
        computer.addComponent(hddDrive);
        computer.addComponent(memoryStick);
        computer.addComponent(mouse);

        GIFImageFile gifImageFile = new GIFImageFile(FileType.GIF, "funnygif.gif", 3);
        JPGImageFile jpgImageFile = new JPGImageFile(FileType.JPG, "funnyimage.png", 2, 1);
        MP3MusicFile mp3MusicFile = new MP3MusicFile(FileType.MP3, "song.mp3", 15, "Jackson", "Thriller", 10);

        try {
            computerDrive().addFile(gifImageFile);
            computerDrive().addFile(jpgImageFile);
            computerDrive().addFile(mp3MusicFile);
            memoryStick.addFile(gifImageFile);
            memoryStick.addFile(jpgImageFile);
            memoryStick.addFile(mp3MusicFile);
        } catch (ComponentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static AbstractDrive computerDrive() throws ComponentNotFoundException {
        return (AbstractDrive) computer.getComponent(ComponentType.HDD);
    }
}
