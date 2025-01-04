package userInterface;

import hardware.components.drive.HDDDrive;
import hardware.components.drive.SSDDrive;
import hardware.components.headphones.Headphones;
import hardware.components.monitor.Monitor;
import hardware.components.shared.FileStorage;
import hardware.components.shared.StorageCapacity;
import hardware.components.usbdevice.MemoryStick;
import hardware.components.usbdevice.Mouse;
import hardware.computer.Computer;
import software.file.File;
import software.file.imagefile.GIFImageFile;
import software.file.imagefile.JPGImageFile;
import software.file.musicfile.MP3MusicFile;

import java.util.Scanner;

public class UserInterface {
    static Computer computer = new Computer();
    static FileStorage fileStorage = new FileStorage(StorageCapacity.GB512);
    static boolean bootstrap = false;

    public static void userInterface() {

        if (!bootstrap) {computerBootstrap();}

        Scanner scanner = new Scanner(System.in);

        System.out.println("""
         
         Witam! 
         1.Wyświetl podzespoły 
         2.Zarządzanie plikami
         """);

        int userInput = Integer.parseInt(scanner.nextLine());


        switch (userInput) {
            case 1 -> computer.listComponent();
            case 2 -> fileMenager();
        }
        userInterface();
    }

    public static void fileMenager() {
        Scanner scanner = new Scanner(System.in);
        GIFImageFile tempFile = new GIFImageFile("temp.gif", 1); // plik tymczasowy, dodany w celu testowania

        System.out.println("""
                
                1.Wyświetl pliki.
                2.Dodaj plik.
                3.Usuń plik.
                8.Powrót.
                9.Wyjście.
                """);
                int userInput = scanner.nextInt();
                scanner.nextLine();


                switch (userInput) {
                    case 1 -> fileStorage.listFiles();
                    case 2 -> fileStorage.addFile(tempFile);
                    case 3 -> {
                        System.out.println("Podaj nazwe pliku który chcesz usunąć");
                        String fileName = scanner.nextLine();
                        File fileForDelete = fileStorage.findFile(fileName);
                        fileStorage.removeFile(fileForDelete);
                    }
                    case 8 -> userInterface();
                    case 9 -> System.exit(0);
                    default -> {System.out.println("Błąd, spróbuj ponownie!"); fileMenager(); }
                }
                fileMenager();
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

        fileStorage.addFile(gifImageFile);
        fileStorage.addFile(jpgImageFile);
        fileStorage.addFile(mp3MusicFile);
        bootstrap = true;


    }

}
