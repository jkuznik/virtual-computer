package pl.jkuznik.computer.hardware.components.usbdevice;

import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

public class Mouse implements USBDevice {
    private final String name;
    private boolean connected = true;

    public Mouse(String name) {
        this.name = name;
    }

    @Override
    public void connect() {
        System.out.println("Mouse connected");
        connected = true;
    }

    @Override
    public void disconnect() {
        System.out.println("Mouse disconnected");
        connected = false;
    }

    @Override
    public boolean isConnected() {
        return connected;
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
