package pl.jkuznik.computer.software.file.musicfile;

import pl.jkuznik.computer.software.file.AbstractFile;
import pl.jkuznik.computer.software.file.FileType;

public abstract class AbstractMusicFile extends AbstractFile implements MusicFile {
    protected String bandName;
    protected String title;

    public AbstractMusicFile(FileType fileType, String name, long size, String bandName, String title) {
        super(fileType, name, size);
        this.bandName = bandName;
        this.title = title;
    }
}
