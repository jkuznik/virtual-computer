package pl.jkuznik.computer.software.file.imagefile;

import pl.jkuznik.computer.software.file.AbstractFile;
import pl.jkuznik.computer.software.file.FileType;

public abstract class AbstractImageFile extends AbstractFile {

    protected AbstractImageFile(String name, long size) {
        super(name, size);
    }

}
