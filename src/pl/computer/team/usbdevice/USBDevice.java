package pl.computer.team.usbdevice;

public interface USBDevice {
    boolean connect();
    boolean disconnect();
    String getName();
}
