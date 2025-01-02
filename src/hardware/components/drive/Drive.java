package hardware.components.drive;

import software.file.File;

public interface Drive {
    void addFile(File file);
    void removeFile(File file);
    void listFiles();
    File findFile(String name);
}
