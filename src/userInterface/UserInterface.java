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

import java.util.Scanner;

public class UserInterface {
    static Computer computer = new Computer();
    static Scanner scanner = new Scanner(System.in);

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
           userInput = Integer.parseInt(scanner.nextLine());

            switch (userInput) {
                case 1 -> computer.listComponent();
                case 2 -> fileMenager();
                case 9 -> System.out.println("Program zakończony");
                default -> System.out.println("Błąd, spróbuj ponownie!");
            }
        } while (userInput!=9);
    }

    public static void fileMenager() {
        GIFImageFile tempFile = new GIFImageFile("temp.gif", 1); // plik tymczasowy, dodany w celu testowania
        int userInput;
        do {
            System.out.println("""
                                    
                    1.Wyświetl pliki.
                    2.Dodaj plik.
                    3.Usuń plik.
                    8.Powrót.
                    9.Wyjście.
                    """);
            userInput = scanner.nextInt();
            scanner.nextLine();


            switch (userInput) {
                case 1 -> computer.getDrive().listFiles();
                case 2 -> computer.getDrive().addFile(tempFile);
                case 3 -> {
                    System.out.println("Podaj nazwe pliku który chcesz usunąć");
                    String fileName = scanner.nextLine();
                    File fileForDelete = computer.getDrive().findFile(fileName);
                    computer.getDrive().removeFile(fileForDelete);}
                case 8 -> System.out.println(System.lineSeparator() + "Menu główne!");
                case 9 -> System.exit(0);
                default -> {
                    System.out.println("Błąd, spróbuj ponownie!");
                }
            }
        } while (userInput!=8);
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
