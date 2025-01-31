package pl.jkuznik.computer.userInterface;

import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;
import pl.jkuznik.computer.hardware.shared.ComponentNotFoundException;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.FileType;
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;
import pl.jkuznik.computer.software.game.GameNotFoundException;
import pl.jkuznik.computer.software.program.ProgramNotFoundException;
import pl.jkuznik.utils.consoleReader.ConsoleReader;

import java.io.FileNotFoundException;

import static pl.jkuznik.computer.userInterface.UserChoice.*;
import static pl.jkuznik.utils.enums.MenuMessage.*;
import static pl.jkuznik.utils.langueHandler.LangueHandler.displayMessage;

public class FileMenu {
    private final static ConsoleReader consoleReader = ConsoleReader.getInstance();
    private static UserChoice userChoice;
    private Computer computer;

    private FileMenu() {}

    public static void fileMenu(Computer computer) {
        do {
            displayMessage(FILE_MENU_MESSAGE);
            userChoice = userChoice(consoleReader.getScanner().nextLine(), SubMenu.SOFTWARE_MENU);

            switch (userChoice) {
                case LIST_FILE -> listFiles(computer);
                case ADD_FILE -> addFile(computer);
                case DELETE_FILE -> deleteFile(computer);
                case RUN_PROGRAM -> runProgram(computer);
                case RUN_GAME -> runGame(computer);
                case BACK -> System.out.println(System.lineSeparator() + "Menu główne!");
                case EXIT -> System.exit(0);
                case DEFAULT -> displayMessage(ERROR_MESSAGE);
            }
        } while (!userChoice.equals(BACK));
    }

    private static void runGame(Computer computer) {
        displayMessage(RUN_GAME_MESSAGE);
        computer.getGameHandler().gameList();
        try {
            computer.getGameHandler().startGameByName(consoleReader.getScanner().nextLine());
        } catch (GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProgram(Computer computer) {
        displayMessage(RUN_PROGRAM_MESSAGE);
        computer.getProgramHandler().programList();
        try {
            computer.getProgramHandler().startProgramByName(consoleReader.getScanner().nextLine());
        } catch (ProgramNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listFiles(Computer computer) {
        try {
            computerDrive(computer).getFiles().forEach(file -> System.out.println(file.getName()));
        } catch (ComponentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addFile(Computer computer) {
        String name = "name";
        int size = 0;
        int compression = 0;
        String bandName = "";
        String title = "title";
        int quality = 0;

        displayMessage(ADD_FILE_MESSAGE);
        userChoice = userChoice(consoleReader.getScanner().nextLine(), SubMenu.FILE_MANAGEMENT);
        switch (userChoice) {
            case JPG -> {
                displayMessage(INPUT_FILE_NAME_MESSAGE);
                name = consoleReader.getScanner().nextLine() + ".jpg";
                displayMessage(INPUT_FILE_SIZE_MESSAGE);
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                displayMessage(INPUT_FILE_COMPRESSION_MESSAGE);
                compression = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive(computer).addFile(new JPGImageFile(FileType.JPG, name, size, compression));
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
                    computerDrive(computer).addFile(new GIFImageFile(FileType.GIF, name, size));
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
                    computerDrive(computer).addFile(new MP3MusicFile(FileType.MP3, name, size, bandName, title, quality));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> displayMessage(ERROR_MESSAGE);
        }
    }

    private static void deleteFile(Computer computer) {
        displayMessage(INPUT_FILE_NAME_FOR_DELETE_MESSAGE);
        String fileName = consoleReader.getScanner().nextLine();
        try {
            File fileForDelete = computerDrive(computer).findFile(fileName);
            computerDrive(computer).removeFile(fileForDelete);
        } catch (ComponentNotFoundException | FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static AbstractDrive computerDrive(Computer computer) throws ComponentNotFoundException {
        return (AbstractDrive) computer.getComponent(ComponentType.HDD);
    }
}
