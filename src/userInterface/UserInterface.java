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

public class UserInterface {
    static Computer computer = new Computer();
    public static void userInterface() {

        computerBootstrap();



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

       computer.addFile(gifImageFile);
       computer.addFile(jpgImageFile);
       computer.addFile(mp3MusicFile);




    }


}
