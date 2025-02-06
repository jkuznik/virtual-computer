package pl.jkuznik.utils.computerBootstrap;

import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.Computer;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;
import pl.jkuznik.computer.hardware.components.drive.Drive;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.ComponentNotFoundException;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.software.file.File;

import java.util.HashSet;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ComputerBootstrapTest {

    @Test
    void run() throws ComponentNotFoundException {
        given();
        Computer computer = new Computer();
        var componentsBefore = new HashSet<>(computer.getAllComponents());

        when();
        ComputerBootstrap.run(computer);
        var componentsAfter = new HashSet<>(computer.getAllComponents());
        var drive = (AbstractDrive) computer.getComponent(ComponentType.HDD);
        List<File> files = drive.getFiles();

        then();
        assertEquals(0, componentsBefore.size());
        assertFalse(componentsAfter.isEmpty());
        assertFalse(files.isEmpty());

    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}