package computer.hardware;

import computer.hardware.shared.Component;
import computer.hardware.shared.ComponentNotFoundException;
import computer.hardware.shared.enums.ComponentType;

import java.util.HashSet;
import java.util.Set;

public class Computer {
    private final Set<Component> components = new HashSet<>();

    public void addComponent(Component component) {
        components.add(component);
    }

    public Component getComponent(ComponentType componentType) throws ComponentNotFoundException {
        return components.stream()
                .filter(component -> component.getComponentType().equals(componentType))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Component of type " + componentType.toString().toLowerCase() + " not found"));
    }

    public Component getComponent(String componentName) throws ComponentNotFoundException {
        return components.stream()
                .filter(component -> component.getComponentName().equals(componentName))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Component with " + componentName + " name not found"));
    }

    public Set<Component> getAllComponents() {
        return components;
    }

    public void removeComponent(Component component) {
        components.remove(component);
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

