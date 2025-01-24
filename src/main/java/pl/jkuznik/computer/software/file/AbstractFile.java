package pl.jkuznik.computer.software.file;

public abstract class AbstractFile implements File {
    protected FileType fileType;
    protected String name;
    protected long size;

    protected AbstractFile(FileType fileType, String name, long size) {
        this.fileType = fileType;
        this.name = name;
        this.size = size;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFileType(FileType fileType) {
        this.fileType = fileType;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public long getSize() {
        return this.size;
    }

    @Override
    public FileType getFileType() {
        return fileType;
    }
}
