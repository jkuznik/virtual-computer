package pl.jkuznik.computer.hardware.components.drive;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.FileType;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AbstractDriveTest {
    AbstractDrive drive;

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
        Assertions.assertThat(before + 1).isEqualTo(after);
    }

    @Test
    void getFiles() {
    }

    @Test
    void removeFile() {
    }

    @Test
    void findFile() {
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