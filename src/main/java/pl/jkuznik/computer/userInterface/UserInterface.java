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

import java.io.FileNotFoundException;


public class UserInterface {
    static Computer computer = new Computer();
    static ConsoleReader consoleReader = ConsoleReader.getInstance();
    static ProgramHandler programHandler = ProgramHandler.getInstance();
    static GameHandler gameHandler = new GameHandler();
    static UserChoiceEnum userInput;
    static boolean polishSelected;
    static boolean englishSelected;

    public static void languageMenu() {

        System.out.println("Witam!");
        do {
            System.out.println("""
                    Wybierz język/Select language
                     1.Polski!
                     2.English!
                     9.Wyjście/Exit.
                    """);
            userInput = UserChoiceEnum.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 -> {
                    polishSelected = true;
                    englishSelected = false;
                    userInterface();
                }
                case USER_INPUT_2 -> {
                    englishSelected = true;
                    polishSelected = false;
                    userInterface();
                }
                case USER_INPUT_9 -> System.exit(0);
                default -> System.out.println("Błąd, spróbuj ponownie!");
            }
        } while (!userInput.equals(UserChoiceEnum.USER_INPUT_9));
    }

    public static void userInterface() {

        computerBootstrap();
        System.out.println("Witam!");
        do {
            if (polishSelected) {
                System.out.println(MultiLingualHandler.MAIN_MENU.getTextPl());
            } else if (englishSelected) {
                System.out.println(MultiLingualHandler.MAIN_MENU.getTextEng());
            }
            userInput = UserChoiceEnum.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));

            switch (userInput) {
                case USER_INPUT_1 ->
                        computer.getAllComponents().forEach(component -> System.out.println(component.getComponentName()));
                case USER_INPUT_2 -> fileManager();
                case USER_INPUT_8 -> languageMenu();
                case USER_INPUT_9 -> {
                    if (polishSelected) {
                        System.out.println(MultiLingualHandler.PROGRAM_ENDED.getTextPl());
                    } else if (englishSelected) {
                        System.out.println(MultiLingualHandler.PROGRAM_ENDED.getTextEng());
                    }
                }
                default -> {
                    if (polishSelected) {
                        System.out.println(MultiLingualHandler.ERROR.getTextPl());
                    } else if (englishSelected) {
                        System.out.println(MultiLingualHandler.ERROR.getTextEng());
                    }
                }
            }
        } while (!userInput.equals(UserChoiceEnum.USER_INPUT_9));
    }

    public static void fileManager() {
        do {
            if (polishSelected) {
                System.out.println(MultiLingualHandler.FILE_MANAGER.getTextPl());
            } else if (englishSelected) {
                System.out.println(MultiLingualHandler.FILE_MANAGER.getTextEng());
            }

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
                    if (polishSelected) {
                        System.out.println(MultiLingualHandler.ERROR.getTextPl());
                    } else if (englishSelected) {
                        System.out.println(MultiLingualHandler.ERROR.getTextEng());
                    }
                }
            }
        } while (!userInput.equals(UserChoiceEnum.USER_INPUT_8));
    }

    private static void runGame() {
        if (polishSelected) {
            System.out.println(MultiLingualHandler.RUN_GAME.getTextPl());
        } else if (englishSelected) {
            System.out.println(MultiLingualHandler.RUN_GAME.getTextEng());
        }
        gameHandler.gameList();
        try {
            gameHandler.startGameByName(consoleReader.getScanner().nextLine());
        } catch (GameNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void runProgram() {
        if (polishSelected) {
            System.out.println(MultiLingualHandler.RUN_PROGRAM.getTextPl());
        } else if (englishSelected) {
            System.out.println(MultiLingualHandler.RUN_PROGRAM.getTextEng());
        }
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
        String name = "name";
        int size = 0;
        int compression = 0;
        String bandName = "";
        String title = "title";
        int quality = 0;

        if (polishSelected) {
            System.out.println(MultiLingualHandler.ADD_FILE.getTextPl());
        } else if (englishSelected) {
            System.out.println(MultiLingualHandler.ADD_FILE.getTextEng());
        }
        userInput = UserChoiceEnum.userChoice(Integer.parseInt(consoleReader.getScanner().nextLine()));
        switch (userInput) {
            case USER_INPUT_1 -> {
                if (polishSelected) {
                    System.out.println(MultiLingualHandler.INPUT_NAME.getTextPl());
                    name = consoleReader.getScanner().nextLine() + ".jpg";
                    System.out.println(MultiLingualHandler.INPUT_SIZE.getTextPl());
                    size = Integer.parseInt(consoleReader.getScanner().nextLine());
                    System.out.println(MultiLingualHandler.INPUT_COMPRESION.getTextPl());
                    compression = Integer.parseInt(consoleReader.getScanner().nextLine());

                } else if (englishSelected) {
                    System.out.println(MultiLingualHandler.INPUT_NAME.getTextEng());
                    name = consoleReader.getScanner().nextLine() + ".jpg";
                    System.out.println(MultiLingualHandler.INPUT_SIZE.getTextEng());
                    size = Integer.parseInt(consoleReader.getScanner().nextLine());
                    System.out.println(MultiLingualHandler.INPUT_COMPRESION.getTextEng());
                    compression = Integer.parseInt(consoleReader.getScanner().nextLine());
                }
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
