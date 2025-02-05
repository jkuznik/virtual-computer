package pl.jkuznik.computer.hardware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.ComponentNotFoundException;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void shouldAddComponent_whenComponentIsValid() throws ComponentNotFoundException {
        given();
        var component = new Monitor("foo");
        computer.addComponent(component);

        when();
        Set<Component> allComponents = computer.getAllComponents();
        var result = computer.getComponent("foo");
        var result2 = computer.getComponent(ComponentType.MONITOR);

        then();
        assertEquals(1, allComponents.size());
        assertEquals(result, component);
        assertEquals(result2, component);
    }

    @Test
    void shouldReturnComponentByName_whenComponentIsExist() throws ComponentNotFoundException {
        given();
        var component = new Monitor("foo");
        computer.addComponent(component);

        when();
        Component result = computer.getComponent("foo");

        then();
        assertInstanceOf(Monitor.class, result);
        assertEquals("foo", result.getComponentName());
    }

    @Test
    void shouldReturnComponentByType_whenComponentIsExist() throws ComponentNotFoundException {
        given();
        var component = new Monitor("foo");
        computer.addComponent(component);

        when();
        Component result = computer.getComponent(ComponentType.MONITOR);

        then();
        assertInstanceOf(Monitor.class, result);
        assertEquals(ComponentType.MONITOR, result.getComponentType());
    }

    @Test
    void shouldThrowComponentNotFoundException_whenComponentIsNotExist() throws ComponentNotFoundException {
        given();
        computer.getAllComponents().clear();

        when();

        then();
        assertThrows(ComponentNotFoundException.class, () -> computer.getComponent("foo"));
        assertThrows(ComponentNotFoundException.class, () -> computer.getComponent(ComponentType.MONITOR));
    }

    @Test
    void getAllComponents() {
    }

    @Test
    void removeComponent() {
    }

    @Test
    void saveState() {
    }

    @Test
    void loadState() {
    }

    @Test
    void getGameHandler() {
    }

    @Test
    void getProgramHandler() {
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}