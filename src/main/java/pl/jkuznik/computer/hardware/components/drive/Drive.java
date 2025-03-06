package pl.jkuznik.computer.hardware.components.drive;

import pl.jkuznik.computer.hardware.shared.Component;

public interface Drive extends Component {
    int getWriteSpeed();
    int getReadSpeed();
}
