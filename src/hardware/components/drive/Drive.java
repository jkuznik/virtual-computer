package hardware.components.drive;

import hardware.components.shared.Component;
import software.file.File;

public interface Drive extends Component {
    void getWriteSpeed();
    void getReadSpeed();
}
