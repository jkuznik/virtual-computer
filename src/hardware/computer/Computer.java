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

    public Monitor getMonitor() throws ComponentNotFoundException {
        return (Monitor) components.stream()
                .filter(component -> component.getComponentType().equals(ComponentType.MONITOR))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Computer has no available monitor yet"));
    }

    public AbstractDrive getDrive() throws ComponentNotFoundException {
        return (AbstractDrive) components.stream()
                .filter(component -> component.getComponentType().equals(ComponentType.DRIVE))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Computer has no available drive yet"));
    }

    public Headphones getHeadphones() throws ComponentNotFoundException {
        return (Headphones) components.stream()
                .filter(component -> component.getComponentType().equals(ComponentType.HEADPHONES))
                .findFirst()
                .orElseThrow(() -> new ComponentNotFoundException("Computer has no available headphones yet"));
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

    public Component getComponentByType(ComponentType componentType) throws ComponentNotFoundException {
        Set<Component> collected = components.stream()
                .filter(component -> component.getComponentType().equals(componentType))
                .collect(Collectors.toSet());

        if (collected.isEmpty()) {
            throw new ComponentNotFoundException("Component with " + componentType.toString().toLowerCase() + " not found");
        }
        if (collected.size() > 1) {
            int i = 1;
            int userInput;
            System.out.println("Znalezione więcej niż jeden podzespół typu: " + componentType.toString().toLowerCase());
            for (Component component : components) {
                System.out.println(i + "." + component.getComponentName());
                i++;
            }
            while(true){
                System.out.println("Podaj nr podzepołu który Cię interesuje lub wpisz 0 aby wyjść:");
                try {
                    userInput = Integer.parseInt(consoleReader.getScanner().nextLine());
                    if (userInput == 0 ) break;
                    if (userInput > collected.size()) {
                        System.out.println("Zły wybór. Podaj jeszcze raz");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Należy wybrać cyfrę");
                }

            }
        }
    }

   public void listComponents() {
      for (Component component : components) {
          System.out.println(component.getComponentType() + "- " + component.getComponentName());
          //System.out.println(component.getComponentName());
      }
   }

}

