package userInterface;

import hardware.components.drive.HDDDrive;
import hardware.components.drive.SSDDrive;
import hardware.components.headphones.Headphones;
import hardware.components.monitor.Monitor;
import hardware.components.shared.StorageCapacity;
import hardware.components.usbdevice.MemoryStick;
import hardware.components.usbdevice.Mouse;
import hardware.computer.Computer;

public class UserInterface {
    static Computer computer = new Computer();
    public static void userInterface() {

        computerBootstrap();

    }


    private static void computerBootstrap() {
        Monitor monitor = new Monitor("Iiyama");
        Headphones headphones = new Headphones("HyperX");
        HDDDrive hddDrive = new HDDDrive(StorageCapacity.GB512, "HDDDrive");
        SSDDrive ssdDrive = new SSDDrive(StorageCapacity.GB1024, "SSDDrive");
        MemoryStick memoryStick = new MemoryStick(StorageCapacity.GB16, "Pendrive");
        Mouse mouse = new Mouse("Zowie");

        computer.addComponent(monitor);
        computer.addComponent(headphones);
        computer.addComponent(hddDrive);
        computer.addComponent(ssdDrive);
        computer.addComponent(memoryStick);
        computer.addComponent(mouse);

    }


}
