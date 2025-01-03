package hardware.components.shared;

import software.file.File;

public interface FileHandler {
    void addFile(File file);
    void removeFile(File file);
    void listFiles();
    File findFile(String name);
}