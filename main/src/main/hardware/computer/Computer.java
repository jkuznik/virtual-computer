package main.hardware.computer;

import main.hardware.components.drive.AbstractDrive;
import main.hardware.components.drive.Drive;
import main.hardware.components.headphone.Headphones;
import main.hardware.components.monitor.Monitor;
import main.hardware.components.shared.Component;
import main.hardware.components.shared.enums.ComponentType;
import main.hardware.components.usbdevice.USBDevice;

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

    public AbstractDrive getDrive() {
        return (AbstractDrive) components.stream()
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

    public void addComponent(Component component) {
        components.add(component);
    }


   public void listComponent() {
      for (Component component : components) {
          System.out.println(component.getComponentType() + "- " + component.getComponentName());
          //System.out.println(component.getComponentName());
      }
   }

}

