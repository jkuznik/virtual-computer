package pl.jkuznik.computer.hardware.components.drive;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.FileType;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;

import java.io.FileNotFoundException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;
import static org.junit.jupiter.api.Assertions.*;

class AbstractDriveTest {
    private AbstractDrive drive;

    @BeforeEach
    void setUp() {
        drive = new HDDDrive(StorageCapacity.GB64, "foo");
    }

    @Test
    void shouldAddFile_whenFileIsValid() {
        given();
        var file = new JPGImageFile("bar", 5, 5);
        int before = drive.getFiles().size();

        when();
        drive.addFile(file);
        int after = drive.getFiles().size();

        then();
        assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void shouldReturnFiles_whenFilesWasAddedCorrectly() {
        given();
        var file1 = new JPGImageFile("foo", 5, 5);
        var file2 = new JPGImageFile("bar", 5, 5);
        var file3 = new JPGImageFile("baz", 5, 5);
        drive.addFile(file1);
        drive.addFile(file2);
        drive.addFile(file3);

        when();
        List<File> files = drive.getFiles();

        then();
        assertThat(files.size()).isEqualTo(3);
    }

    @Test
    void shouldRemoveFile_whenFileExist() {
        given();
        var file1 = new JPGImageFile("foo", 5, 5);
        var file2 = new JPGImageFile("bar", 5, 5);
        var file3 = new JPGImageFile("baz", 5, 5);
        drive.addFile(file1);
        drive.addFile(file2);
        drive.addFile(file3);
        int before = drive.getFiles().size();

        when();
        drive.removeFile(file1);
        int after = drive.getFiles().size();

        then();
        assertThat(before - 1).isEqualTo(after);
    }

    @Test
    void shouldReturnFile_whenFileExist() throws FileNotFoundException {
        given();
        var file1 = new JPGImageFile("foo", 5, 5);
        drive.addFile(file1);

        when();
        var result = drive.findFile("foo");

        then();
        assertThat(result).isEqualTo(file1);
        assertThat(result.getName()).isEqualTo("foo");
    }

    @Test
    void shouldThrowException_whenFindFileWhichNotExist() throws FileNotFoundException {
        given();

        when();
        var exception = catchException(() -> drive.findFile("foo"));

        then();
        assertThat(exception).isExactlyInstanceOf(FileNotFoundException.class);
        assertThat(exception.getMessage()).isEqualTo("File foo not found");
    }

    @Test
    void getWriteSpeed() {
    }

    @Test
    void getReadSpeed() {
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}