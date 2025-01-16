package computer.hardware.components.usbdevice;

import computer.hardware.shared.Component;

public interface USBDevice extends Component {
    boolean connect();
    boolean disconnect();
}
