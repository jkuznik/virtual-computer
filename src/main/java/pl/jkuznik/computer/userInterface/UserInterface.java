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

import java.io.FileNotFoundException;

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
        computerBootstrap();
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
