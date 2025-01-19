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
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;
import pl.jkuznik.computer.software.game.GameHandler;
import pl.jkuznik.computer.software.game.GameNotFoundException;
import pl.jkuznik.computer.software.program.ProgramHandler;
import pl.jkuznik.computer.software.program.ProgramNotFoundException;
import pl.jkuznik.utils.ConsoleReader;
import pl.jkuznik.utils.persistentState.StateReader;
import pl.jkuznik.utils.persistentState.StateWriter;

import java.io.FileNotFoundException;


public class UserInterface {
    static Computer computer = new Computer();
    static ConsoleReader consoleReader = ConsoleReader.getInstance();
    static ProgramHandler programHandler = ProgramHandler.getInstance();
    static GameHandler gameHandler = new GameHandler();
    static UserChoiceEnum userInput;

    static StateReader stateReader = new StateReader();
    static StateWriter stateWriter = new StateWriter();

    public static void userInterface() {

        computerBootstrap();
        stateWriter.writeState(computer.getAllComponents());
        stateReader.readState();

        System.out.println("Witam!");
        do {
            System.out.println("""
                    
                    1.Wyświetl podzespoły 
                    2.Zarządzanie plikami
                    9.Wyjście.
                    """);

            userInput = UserChoiceEnum.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 ->
                        computer.getAllComponents().forEach(component -> System.out.println(component.getComponentName()));
                case USER_INPUT_2 -> fileManager();
                case USER_INPUT_9 -> System.out.println("Program zakończony");
                default -> System.out.println("Błąd, spróbuj ponownie!");
            }
        } while (!userInput.equals(UserChoiceEnum.USER_INPUT_9));
    }

    public static void fileManager() {
        do {
            System.out.println("""
                    
                    1.Wyświetl pliki.
                    2.Dodaj plik.
                    3.Usuń plik.
                    4.Uruchom program.
                    5.Uruchom grę.
                    8.Powrót.
                    9.Wyjście.
                    """);
            userInput = UserChoiceEnum.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 -> listFiles();
                case USER_INPUT_2 -> addFile();
                case USER_INPUT_3 -> deleteFile();
                case USER_INPUT_4 -> runProgram();
                case USER_INPUT_5 -> runGame();
                case USER_INPUT_8 -> System.out.println(System.lineSeparator() + "Menu główne!");
                case USER_INPUT_9 -> System.exit(0);
                default -> {
                    System.out.println("Błąd, spróbuj ponownie!");
                }
            }
        } while (!userInput.equals(UserChoiceEnum.USER_INPUT_8));
    }

    private static void runGame() {
        System.out.println("Wpisz nazwę gry który chcesz uruchomić:");
        gameHandler.gameList();
        try {
            gameHandler.startGameByName(consoleReader.getScanner().nextLine());
        } catch (GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProgram() {
        System.out.println("Wpisz nazwę programu który chcesz uruchomić:");
        programHandler.programList();
        try {
            programHandler.startProgramByName(consoleReader.getScanner().nextLine());
        } catch (ProgramNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void listFiles() {
        try {
            computerDrive().listFiles();
        } catch (ComponentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void addFile() {
        String name;
        int size;
        int compression;
        String bandName;
        String title;
        int quality;

        System.out.println("""
                Podaj rodzaj pliku:
                1.JPG.
                2.GIF.
                3.MP3
                """);
        userInput = UserChoiceEnum.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));
        switch (userInput) {
            case USER_INPUT_1 -> {
                System.out.println("Podaj nazwe");
                name = consoleReader.getScanner().nextLine() + ".jpg";
                System.out.println("Podaj rozmiar");
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                System.out.println("Podaj kompresje");
                compression = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new JPGImageFile(name, size, compression));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }

            }
            case USER_INPUT_2 -> {
                System.out.println("Podaj nazwe");
                name = consoleReader.getScanner().nextLine() + ".gif";
                System.out.println("Podaj rozmiar");
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new GIFImageFile(name, size));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            case USER_INPUT_3 -> {
                System.out.println("Podaj nazwe");
                name = consoleReader.getScanner().nextLine() + ".mp3";
                System.out.println("Podaj rozmiar");
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                System.out.println("Podaj wykonawcę");
                bandName = consoleReader.getScanner().nextLine();
                ;
                System.out.println("Podaj tytuł");
                title = consoleReader.getScanner().nextLine();
                ;
                System.out.println("Podaj jakość");
                quality = Integer.parseInt(consoleReader.getScanner().nextLine());
                try {
                    computerDrive().addFile(new MP3MusicFile(name, size, bandName, title, quality));
                } catch (ComponentNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }
            default -> System.out.println("Błąd, spróbuj ponownie!");
        }
    }

    private static void deleteFile() {
        System.out.println("Podaj nazwe pliku który chcesz usunąć");
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

        GIFImageFile gifImageFile = new GIFImageFile("funnygif.gif", 3);
        JPGImageFile jpgImageFile = new JPGImageFile("funnyimage.png", 2, 1);
        MP3MusicFile mp3MusicFile = new MP3MusicFile("song.mp3", 15, "band", "title", 10);

        try {
            computerDrive().addFile(gifImageFile);
            computerDrive().addFile(jpgImageFile);
            computerDrive().addFile(mp3MusicFile);
        } catch (ComponentNotFoundException e) {
            System.out.println(e.getMessage());
        }

    }

    private static AbstractDrive computerDrive() throws ComponentNotFoundException {
        AbstractDrive drive = (AbstractDrive) computer.getComponent(ComponentType.DRIVE);
        return drive;
    }
}
