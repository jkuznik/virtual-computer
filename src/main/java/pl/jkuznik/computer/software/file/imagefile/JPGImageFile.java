package pl.jkuznik.computer.software.file.imagefile;

import pl.jkuznik.computer.software.file.FileType;

public class JPGImageFile extends AbstractImageFile {
    private final int compression;

    public JPGImageFile(String name, long size, int compression) {
        super(name, size);
        this.compression = compression;
    }

    public int getCompression() {
        return compression;
    }

    public void displayImage() {
        System.out.println("Displaying JPG");
    }

    @Override
    public FileType getFileType() {
        return FileType.JPG;
    }
}
