package pl.jkuznik.computer.hardware.components.usbdevice;

import pl.jkuznik.computer.hardware.shared.Component;

public interface USBDevice extends Component {
    boolean connect();
    boolean disconnect();
}
