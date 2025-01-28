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
import pl.jkuznik.utils.enums.FilePath;
import pl.jkuznik.utils.langueHandler.LangueHandler;

import java.io.FileNotFoundException;

import static pl.jkuznik.utils.enums.MenuMessage.*;

public class UserInterface {
    static Computer computer = new Computer();
    static ConsoleReader consoleReader = ConsoleReader.getInstance();
    static LangueHandler langueHandler = new LangueHandler();
    static UserChoice userInput;

    public static void languageMenu() {

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
            userInput = UserChoice.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 -> langueHandler.loadLangue(FilePath.LANGUE_PL);
                case USER_INPUT_2 -> langueHandler.loadLangue(FilePath.LANGUE_EN);
                case USER_INPUT_3 -> langueHandler.loadLangue(FilePath.LANGUE_DE);
                case USER_INPUT_4 -> langueHandler.loadLangue(FilePath.LANGUE_IT);
                case USER_INPUT_5 -> langueHandler.loadLangue(FilePath.LANGUE_FR);
                case USER_INPUT_6 -> langueHandler.loadLangue(FilePath.LANGUE_ES);
                case USER_INPUT_9 -> System.exit(0);
                default -> System.out.println("Błąd, spróbuj ponownie!");
            }
            userInterface();
        } while (!userInput.equals(UserChoice.USER_INPUT_9));
    }

    public static void userInterface() {

        // TODO: dodać możliwość zarządzania podzespołąmi wraz z możliwośćia zapisu i odczytu
        computerBootstrap();
        langueHandler.displayMessage(GREETINGS);
        do {
            langueHandler.displayMessage(MAIN_MENU);
            userInput = UserChoice.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 -> computer.getAllComponents().forEach(component -> System.out.println(component.getComponentName()));
                case USER_INPUT_2 -> fileManager();
                case USER_INPUT_8 -> languageMenu();
                case USER_INPUT_9 -> langueHandler.displayMessage(END_PROGRAM);
                default -> langueHandler.displayMessage(ERROR);
            }
        } while (!userInput.equals(UserChoice.USER_INPUT_9));
    }

    public static void fileManager() {
        do {
            langueHandler.displayMessage(FILE_MENU);
            userInput = UserChoice.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 -> listFiles();
                case USER_INPUT_2 -> addFile();
                case USER_INPUT_3 -> deleteFile();
                case USER_INPUT_4 -> runProgram();
                case USER_INPUT_5 -> runGame();
                case USER_INPUT_8 -> System.out.println(System.lineSeparator() + "Menu główne!");
                case USER_INPUT_9 -> System.exit(0);
                default -> langueHandler.displayMessage(ERROR);
            }
        } while (!userInput.equals(UserChoice.USER_INPUT_8));
    }

    private static void runGame() {
        langueHandler.displayMessage(RUN_GAME);
        computer.getGameHandler().gameList();
        try {
            computer.getGameHandler().startGameByName(consoleReader.getScanner().nextLine());
        } catch (GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProgram() {
        langueHandler.displayMessage(RUN_PROGRAM);
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

        langueHandler.displayMessage(ADD_FILE);
        userInput = UserChoice.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));
        switch (userInput) {
            case USER_INPUT_1 -> {
                    langueHandler.displayMessage(INPUT_FILE_NAME);
                    name = consoleReader.getScanner().nextLine() + ".jpg";
                    langueHandler.displayMessage(INPUT_FILE_SIZE);
                    size = Integer.parseInt(consoleReader.getScanner().nextLine());
                    langueHandler.displayMessage(INPUT_FILE_COMPRESSION);
                    compression = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new JPGImageFile(FileType.JPG, name, size, compression));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            }
            case USER_INPUT_2 -> {
                    langueHandler.displayMessage(INPUT_FILE_NAME);
                    name = consoleReader.getScanner().nextLine() + ".gif";
                    langueHandler.displayMessage(INPUT_FILE_SIZE);
                    size = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new GIFImageFile(FileType.GIF, name, size));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            case USER_INPUT_3 -> {
                   langueHandler.displayMessage(INPUT_FILE_NAME);
                   name = consoleReader.getScanner().nextLine() + ".mp3";
                   langueHandler.displayMessage(INPUT_FILE_SIZE);
                   size = Integer.parseInt(consoleReader.getScanner().nextLine());
                   langueHandler.displayMessage(INPUT_SONG_BAND_NAME);
                   bandName = consoleReader.getScanner().nextLine();
                   langueHandler.displayMessage(INPUT_SONG_TITLE);
                   title = consoleReader.getScanner().nextLine();
                   langueHandler.displayMessage(INPUT_FILE_QUALITY);
                   quality = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new MP3MusicFile(FileType.MP3, name, size, bandName, title, quality));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> langueHandler.displayMessage(ERROR);
       }
    }

    private static void deleteFile() {
        langueHandler.displayMessage(INPUT_FILE_NAME_FOR_DELETE);
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
