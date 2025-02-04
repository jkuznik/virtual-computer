package pl.jkuznik.computer.hardware.shared;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;

import java.io.FileNotFoundException;
import java.util.List;

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
        fileHandler.addFile(file);
        int before = fileHandler.getFiles().size();

        when();
        fileHandler.removeFile(file);
        int after = fileHandler.getFiles().size();

        then();
        assertEquals(before - 1, after);
        assertEquals(0, fileHandler.getFiles().size());
    }

    @Test
    void shouldReturnFile_whenFileExists() throws FileNotFoundException {
        given();
        var file = new JPGImageFile("foo", 5,5);
        fileHandler.addFile(file);

        when();
        File result = fileHandler.findFile("foo");

        then();
        assertNotNull(result);
        assertEquals(file, result);
        assertEquals("foo", result.getName());
    }

    @Test
    void shouldThrowException_whenFileDoesNotExist() {
        given();

        when();

        then();
        assertThrows(FileNotFoundException.class, () -> fileHandler.findFile("bar"));
    }

    @Test
    void shouldReturnCurrentCapacity() {
        given();

        when();

        then();
        assertEquals(0, fileHandler.getCurrentCapacity());
    }

    @Test
    void shouldReturnStorageCapacity() {
        given();

        when();

        then();
        assertEquals(StorageCapacity.GB1, fileHandler.getStorageCapacity());
    }

    @Test
    void getFiles() {
        given();
        var file1 = new JPGImageFile("foo", 5,5);
        var file2 = new JPGImageFile("bar", 5,5);
        var file3 = new JPGImageFile("baz", 5,5);
        fileHandler.addFile(file1);
        fileHandler.addFile(file2);

        when();
        List<File> files = fileHandler.getFiles();

        then();
        assertEquals(2, files.size());
        assertTrue(files.contains(file1));
        assertTrue(files.contains(file2));
        assertFalse(files.contains(file3));
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}