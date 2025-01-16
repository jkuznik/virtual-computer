package hardware.computer;

import hardware.components.drive.AbstractDrive;
import hardware.components.headphone.Headphones;
import hardware.components.monitor.Monitor;
import hardware.components.shared.Component;
import hardware.components.shared.ComponentNotFoundException;
import hardware.components.shared.enums.ComponentType;
import hardware.components.usbdevice.USBDevice;
import utils.ConsoleReader;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Computer {
    private final List<Component> components = new ArrayList<>();
    private final ConsoleReader consoleReader = ConsoleReader.getInstance();


    public void addComponent(Component component) {
        components.add(component);
    }

    public Component getComponent(ComponentType componentType) throws ComponentNotFoundException {
        return components.stream()
                .filter(component -> component.getComponentType().equals(componentType))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Component of type " + componentType.toString().toLowerCase() + " not found"));
    }

    public Component getComponent(ComponentType componentType, String componentName) throws ComponentNotFoundException {
        return components.stream()
                .filter(component -> component.getComponentType().equals(componentType) && component.getComponentName().equals(componentName))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Component of type " + componentType.toString().toLowerCase() +
        "and name " + componentName + " not found"));
    }

    public void listComponents() {
        for (Component component : components) {
            System.out.println(component.getComponentType() + "- " + component.getComponentName());
            //System.out.println(component.getComponentName());
        }
    }
//    TODO: do zaimplementowania
//    public List<USBDevice> getUsbDevices() {
//        return usbDevices;
//    }

    //    TODO: do zaimplementowania logika ustawiania 'isConnected' dla usbDevice
//    public void addUSBDevice(USBDevice usbDevice) {
//        components.add(usbDevice);
//    }

    //    TODO: do zaimplementowania logika ustawiania 'isConnected' dla usbDevice
//    public void removeUSBDevice(USBDevice usbDevice) {
//        components.remove(usbDevice);
//    }

}

