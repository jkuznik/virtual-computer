package pl.jkuznik.computer.hardware.components.usbdevice;

import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

public class Mouse implements USBDevice {
    private final String name;
    private boolean isEjected = true;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println("Mouse connected");
        isEjected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("Mouse disconnected");
        isEjected = false;
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MOUSE;
    }
}
