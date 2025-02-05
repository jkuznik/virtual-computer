package pl.jkuznik.computer.hardware;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.ComponentNotFoundException;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.utils.persistentState.StateReader;

import java.lang.reflect.Field;
import java.util.HashSet;
import java.util.List;
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
    void shouldThrowComponentNotFoundException_whenComponentIsNotExist() {
        given();
        computer.getAllComponents().clear();

        when();

        then();
        assertThrows(ComponentNotFoundException.class, () -> computer.getComponent("foo"));
        assertThrows(ComponentNotFoundException.class, () -> computer.getComponent(ComponentType.MONITOR));
    }

    @Test
    void shouldReturnComponentsList_whenComponentAreExist() {
        given();
        var component = new Monitor("foo");
        var component2 = new Headphones("bar");
        computer.addComponent(component);
        computer.addComponent(component2);

        when();
        Set<Component> result = computer.getAllComponents();

        then();
        assertEquals(2, result.size());
        assertTrue(result.contains(component));
        assertTrue(result.contains(component2));
    }

    @Test
    void shouldReturnEmptyComponentList_whenComponentAreNotExist() {
        given();
        computer.getAllComponents().clear();

        when();
        Set<Component> result = computer.getAllComponents();

        then();
        assertEquals(0, result.size());
    }

    @Test
    void shouldRemoveComponent_whenComponentIsExist() {
        var component = new Monitor("foo");
        computer.addComponent(component);

        when();
        Set<Component> before = new HashSet<>(computer.getAllComponents());
        computer.removeComponent(component);
        Set<Component> after = new HashSet<>(computer.getAllComponents());

        then();
        assertEquals(before.size() - 1, after.size());
        assertTrue(before.contains(component));
        assertTrue(after.isEmpty());
    }

    @Test
    void shouldLoadComputerState() throws ComponentNotFoundException, NoSuchFieldException, IllegalAccessException {
        given();
        computer.getAllComponents().clear();
        StateReader mock = Mockito.mock(StateReader.class);
        var components = Set.of(
                new Monitor("foo"),
                new Headphones("bar")
        );

        when();
        Mockito.when(mock.readState()).thenReturn(List.copyOf(components));
        Field stateReaderField = computer.getClass().getDeclaredField("stateReader");
        stateReaderField.setAccessible(true);
        stateReaderField.set(computer, mock);

        then();
        computer.loadState();
        Mockito.verify(mock).readState();
        assertEquals(components, computer.getAllComponents());
        assertTrue(computer.getAllComponents().contains(computer.getComponent("foo")));
    }

    /*
 tested directly in utils classes StateWriter, GameHandler and ProgramHandler

    @Test
    void saveState() {
    }

    @Test
    void getGameHandler() {
    }

    @Test
    void getProgramHandler() {
    }
*/

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}