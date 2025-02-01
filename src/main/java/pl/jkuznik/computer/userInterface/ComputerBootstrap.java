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
import pl.jkuznik.computer.software.file.FileType;
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;

class ComputerBootstrap {

    private ComputerBootstrap() {}

    public static void run(Computer computer) {

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
            computerDrive(computer).addFile(gifImageFile);
            computerDrive(computer).addFile(jpgImageFile);
            computerDrive(computer).addFile(mp3MusicFile);
            memoryStick.addFile(gifImageFile);
            memoryStick.addFile(jpgImageFile);
            memoryStick.addFile(mp3MusicFile);
        } catch (ComponentNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static AbstractDrive computerDrive(Computer computer) throws ComponentNotFoundException {
        return (AbstractDrive) computer.getComponent(ComponentType.HDD);
    }
}
