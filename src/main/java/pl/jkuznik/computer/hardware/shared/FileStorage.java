package pl.jkuznik.computer.hardware.shared;

import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;

public interface FileStorage {
    void addFile(File file);
    void removeFile(File file);
    void listFiles();
    File findFile(String name) throws FileNotFoundException;
}
