package pl.jkuznik.computer.software.file.imagefile;

import pl.jkuznik.computer.software.file.FileType;

public class GIFImageFile extends AbstractImageFile {

    public GIFImageFile(FileType fileType, String name, long size) {
        super(fileType, name, size);
    }

    public int getVersion() {
        return 2;
    }

    public void showAnimation() {
        System.out.println("Showing funny GIF");
    }
}
