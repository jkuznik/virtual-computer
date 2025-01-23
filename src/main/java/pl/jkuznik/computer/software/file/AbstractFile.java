package pl.jkuznik.computer.software.file;

public abstract class AbstractFile implements File {
    protected String name;
    protected long size;

    protected AbstractFile(String name, long size) {
        this.name = name;
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
    public String toString() {
        return "AbstractFile{" +
                "name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
