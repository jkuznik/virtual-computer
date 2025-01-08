package computerApp.hardware.components.usbdevice;

import computerApp.hardware.components.shared.Component;

public interface USBDevice extends Component {
    boolean connect();
    boolean disconnect();
}
