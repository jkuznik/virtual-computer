package pl.jkuznik.computer.hardware.components.usbdevice;

import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

public class Mouse implements USBDevice {
    private final String name;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public boolean connect() {
        System.out.println("Mouse connected");
        return true;
    }

    @Override
    public boolean disconnect() {
        System.out.println("Mouse disconnected");
        return true;
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
