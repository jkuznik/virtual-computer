package pl.computer.team.drive;

import pl.computer.team.file.File;

public interface Drive {
    void addFile(File file);
    void listFiles();
    File findFile(String name);
}
