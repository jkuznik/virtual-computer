package computer.hardware.components.drive;

import computer.hardware.shared.Component;

public interface Drive extends Component {
    void getWriteSpeed();
    void getReadSpeed();
}
