package pl.jkuznik.computer.software.file.imagefile;

public class JPGImageFile extends AbstractImageFile {
    private int compression;

    public JPGImageFile(String name, int size, int compression) {
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
    public String toString() {
        return "JPGImageFile{" +
                "compression=" + compression +
                ", name='" + name + '\'' +
                ", size=" + size +
                '}';
    }
}
