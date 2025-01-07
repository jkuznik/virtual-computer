package main.hardware.components.drive;

import main.hardware.components.shared.Component;

public interface Drive extends Component {
    void getWriteSpeed();
    void getReadSpeed();
}
