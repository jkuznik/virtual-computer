package pl.jkuznik.computer.hardware;

import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.ComponentNotFoundException;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.software.game.GameHandler;
import pl.jkuznik.computer.software.program.ProgramHandler;
import pl.jkuznik.utils._enums.FilePath;
import pl.jkuznik.utils.persistentState.StateReader;
import pl.jkuznik.utils.persistentState.StateWriter;

import java.nio.file.Path;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Computer {
    private final Set<Component> components = new HashSet<>();
    private final GameHandler gameHandler = GameHandler.getInstance();
    private final ProgramHandler programHandler = ProgramHandler.getInstance();
    private final StateReader stateReader = new StateReader();
    private final StateWriter stateWriter = new StateWriter();

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

    public void saveState(Path path) {
        stateWriter.writeState(components, path);
    }

    public void loadState() {
        List<Component> stateFromFile = stateReader.readState(FilePath.COMPUTER_STATE.getPath());
        components.clear();
        components.addAll(stateFromFile);
    }

    public GameHandler getGameHandler() {
        return gameHandler;
    }

    public ProgramHandler getProgramHandler() {
        return programHandler;
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

