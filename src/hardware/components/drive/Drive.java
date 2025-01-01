package hardware.components.drive;

import hardware.components.shared.Component;
import software.file.File;

public interface Drive extends Component {
    void addFile(File file);
    void removeFile(File file);
    void listFiles();
    File findFile(String name);
}
