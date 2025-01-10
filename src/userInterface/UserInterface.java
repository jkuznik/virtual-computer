package userInterface;

import hardware.components.drive.HDDDrive;
import hardware.components.headphone.Headphones;
import hardware.components.monitor.Monitor;
import hardware.components.shared.enums.StorageCapacity;
import hardware.components.usbdevice.MemoryStick;
import hardware.components.usbdevice.Mouse;
import hardware.computer.Computer;
import software.file.File;
import software.file.imagefile.GIFImageFile;
import software.file.imagefile.JPGImageFile;
import software.file.musicfile.MP3MusicFile;
import software.game.GameHandler;
import software.program.ProgramHandler;
import utils.ConsoleReader;


public class UserInterface {
    static Computer computer = new Computer();
    static ConsoleReader consoleReader = ConsoleReader.getInstance();
    static ProgramHandler programHandler = ProgramHandler.getInstance();
    static GameHandler gameHandler = new GameHandler();


    public static void userInterface() {

        computerBootstrap();
        System.out.println("Witam!");
        int userInput;
        do {
            System.out.println("""
                              
                    1.Wyświetl podzespoły 
                    2.Zarządzanie plikami
                    9.Wyjście.
                    """);
            userInput = Integer.parseInt(consoleReader.getScanner().nextLine());

            switch (userInput) {
                case 1 -> computer.listComponent();
                case 2 -> fileManager();
                case 9 -> System.out.println("Program zakończony");
                default -> System.out.println("Błąd, spróbuj ponownie!");
            }
        } while (userInput!=9);
    }

    public static void fileManager() {
        int userInput;
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
            userInput = consoleReader.getScanner().nextInt();
            consoleReader.getScanner().nextLine();;


            switch (userInput) {
                case 1 -> computer.getDrive().listFiles();
                case 2 -> addFile();
                case 3 -> {
                    System.out.println("Podaj nazwe pliku który chcesz usunąć");
                    String fileName = consoleReader.getScanner().nextLine();;
                    File fileForDelete = computer.getDrive().findFile(fileName);
                    computer.getDrive().removeFile(fileForDelete);
                }
                case 4 -> {
                    System.out.println("Wpisz nazwę programu który chcesz uruchomić:");
                    programHandler.programList();
                    programHandler.startProgramByName(consoleReader.getScanner().nextLine());
                }
                case 5 -> {
                System.out.println("Wpisz nazwę gry który chcesz uruchomić:");
                    gameHandler.gameList();
                    gameHandler.startGameByName(consoleReader.getScanner().nextLine());
                }
                case 8 -> System.out.println(System.lineSeparator() + "Menu główne!");
                case 9 -> System.exit(0);
                default -> {
                    System.out.println("Błąd, spróbuj ponownie!");
                }
            }
        } while (userInput!=8);
    }
    public static void addFile() {
        String name;
        int size;
        int compression;
        String bandName;
        String title;
        int quality;

        int userInput;
        System.out.println("""
                Podaj rodzaj pliku:
                1.JPG.
                2.GIF.
                3.MP3
                """);
        userInput = Integer.parseInt(consoleReader.getScanner().nextLine());
        switch (userInput) {
            case 1 -> {
                System.out.println("Podaj nazwe");
                name = consoleReader.getScanner().nextLine() + ".jpg";
                System.out.println("Podaj rozmiar");
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                System.out.println("Podaj kompresje");
                compression = Integer.parseInt(consoleReader.getScanner().nextLine());
                computer.getDrive().addFile(new JPGImageFile(name, size, compression));

            }
            case 2 -> {
                System.out.println("Podaj nazwe");
                name = consoleReader.getScanner().nextLine() + ".gif";
                System.out.println("Podaj rozmiar");
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                computer.getDrive().addFile(new GIFImageFile(name, size));
            }
            case 3 -> {
                System.out.println("Podaj nazwe");
                name = consoleReader.getScanner().nextLine() + ".mp3";
                System.out.println("Podaj rozmiar");
                size = Integer.parseInt(consoleReader.getScanner().nextLine());
                System.out.println("Podaj wykonawcę");
                bandName = consoleReader.getScanner().nextLine();;
                System.out.println("Podaj tytuł");
                title = consoleReader.getScanner().nextLine();;
                System.out.println("Podaj jakość");
                quality = Integer.parseInt(consoleReader.getScanner().nextLine());
                computer.getDrive().addFile(new MP3MusicFile(name , size , bandName , title , quality));
            }
            default -> System.out.println("Błąd, spróbuj ponownie!");
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

        computer.getDrive().addFile(gifImageFile);
        computer.getDrive().addFile(jpgImageFile);
        computer.getDrive().addFile(mp3MusicFile);

    }

}
