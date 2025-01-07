package main.hardware.components.usbdevice;

import main.hardware.components.shared.Component;

public interface USBDevice extends Component {
    boolean connect();
    boolean disconnect();
}
