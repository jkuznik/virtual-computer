package pl.computer.team.file.imagefile;

import pl.computer.team.file.AbstractFile;
import pl.computer.team.file.FileType;

public abstract class AbstractImageFile extends AbstractFile {

    protected AbstractImageFile(String name, int size) {
        super(name, size);
    }

    @Override
    public FileType getType() {
        return FileType.IMAGE;
    }
}
