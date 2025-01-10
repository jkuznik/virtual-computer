package hardware.components.usbdevice;

import hardware.components.shared.Component;

public interface USBDevice extends Component {
    boolean connect();
    boolean disconnect();
}
