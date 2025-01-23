package pl.jkuznik.computer.software.file.imagefile;

import pl.jkuznik.computer.software.file.FileType;

public class GIFImageFile extends AbstractImageFile {

    public GIFImageFile(String name, long size) {
        super(name, size);
    }

    public void showAnimation() {
        System.out.println("Showing funny GIF");
    }

    public int getVersion() {
        return 2;
    }
}
