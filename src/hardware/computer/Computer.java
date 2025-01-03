package hardware.computer;

import hardware.components.drive.Drive;
import hardware.components.drive.HDDDrive;
import hardware.components.drive.SSDDrive;
import hardware.components.headphones.Headphones;
import hardware.components.monitor.Monitor;
import hardware.components.shared.Component;
import hardware.components.shared.ComponentType;
import hardware.components.usbdevice.MemoryStick;
import hardware.components.usbdevice.Mouse;
import hardware.components.usbdevice.USBDevice;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Computer {
    private final List<Component> components = new ArrayList<>();

    public Monitor getMonitor() {
        return (Monitor) components.stream()
                .filter(component -> component.getComponentType().equals(ComponentType.MONITOR))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Computer has no available monitor yet"));
    }

    public void setMonitor(Monitor monitor) {
        components.add(monitor);
    }

    public Drive getDrive() {
        return (Drive) components.stream()
                .filter(component -> component.getComponentType().equals(ComponentType.DRIVE))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Computer has no available drive yet"));
    }

    public void setDrive(Drive drive) {
        components.add(drive);
    }

    public Headphones getHeadphones() {
        return (Headphones) components.stream()
                .filter(component -> component.getComponentType().equals(ComponentType.HEADPHONES))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Computer has no available headphones yet"));
    }

    public void setHeadphones(Headphones headphones) {
        components.add(headphones);
    }

//    TODO: do zaimplementowania
//    public List<USBDevice> getUsbDevices() {
//        return usbDevices;
//    }

//    TODO: do zaimplementowania logika ustawiania 'isConnected' dla usbDevice
    public void addUSBDevice(USBDevice usbDevice) {
        components.add(usbDevice);
    }

//    TODO: do zaimplementowania logika ustawiania 'isConnected' dla usbDevice
    public void removeUSBDevice(USBDevice usbDevice) {
        components.remove(usbDevice);
    }

    public void addComponent(Monitor monitor) {
        components.add(monitor);
    }

    public void addComponent(HDDDrive hddDrive) {
        components.add(hddDrive);
    }

    public void addComponent(SSDDrive ssdDrive) {
        components.add(ssdDrive);
    }

    public void addComponent(Headphones headphones) {
        components.add(headphones);
    }

    public void addComponent(MemoryStick memoryStick) {
        components.add(memoryStick);
    }

    public void addComponent(Mouse mouse) {
        components.add(mouse);
    }


}

