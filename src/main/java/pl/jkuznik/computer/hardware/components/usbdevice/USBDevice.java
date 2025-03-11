package pl.jkuznik.computer.hardware.components.usbdevice;

import pl.jkuznik.computer.hardware.shared.Component;

public interface USBDevice extends Component {
    void connect();
    void disconnect();
    boolean isConnected();
}
