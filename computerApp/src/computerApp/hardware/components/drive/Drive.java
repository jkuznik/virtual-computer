package computerApp.hardware.components.drive;

import computerApp.hardware.components.shared.Component;

public interface Drive extends Component {
    void getWriteSpeed();
    void getReadSpeed();
}
