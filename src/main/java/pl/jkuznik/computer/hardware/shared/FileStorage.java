package pl.jkuznik.computer.hardware.shared;

import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;
import java.util.List;

public interface FileStorage {
    void addFile(File file);
    void removeFile(File file);
    List<File> getFiles();
    File findFile(String name) throws FileNotFoundException;
}
