package hardware.computer;

import hardware.components.drive.Drive;
import hardware.components.headphone.Headphones;
import hardware.components.monitor.Monitor;
import hardware.components.shared.Component;
import hardware.components.shared.enums.ComponentType;
import hardware.components.usbdevice.USBDevice;
import software.file.File;
import software.file.imagefile.AbstractImageFile;

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

