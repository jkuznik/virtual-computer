package pl.jkuznik.computer.hardware.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    private FileHandler fileHandler;

    @BeforeEach
    void setUp() {
        fileHandler = new FileHandler(StorageCapacity.GB1);
    }

    @Test
    void shouldAddFile_whenFileExists() {
        given();
        var file = new JPGImageFile("foo", 5,5);
        int before = fileHandler.getFiles().size();

        when();
        fileHandler.addFile(file);
        int after = fileHandler.getFiles().size();

        then();
        assertEquals(before + 1, after);
    }

    @Test
    void shouldRemoveFile_whenFileExists() {
        given();
        var file = new JPGImageFile("foo", 5,5);
        int before = fileHandler.getFiles().size();

        when();
        fileHandler.removeFile(file);
        int after = fileHandler.getFiles().size();

        then();
        assertEquals(before - 1, after);
        assertEquals(0, fileHandler.getFiles().size());
    }

    @Test
    void findFile() {
    }

    @Test
    void getCurrentCapacity() {
    }

    @Test
    void getStorageCapacity() {
    }

    @Test
    void getFiles() {
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}