package pl.jkuznik.computer.software.file;

public interface File {
    String getName();
    long getSize();
    FileType getFileType();

    default int getVersion() {
        return 1;
    }
}
