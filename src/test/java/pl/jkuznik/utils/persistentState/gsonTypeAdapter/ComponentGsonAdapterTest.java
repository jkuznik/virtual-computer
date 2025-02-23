package pl.jkuznik.utils.persistentState.gsonTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.components.drive.HDDDrive;
import pl.jkuznik.computer.hardware.components.drive.SSDDrive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.hardware.shared._enums.StorageCapacity;

import java.io.IOException;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;

class ComponentGsonAdapterTest {
    private final Map<String, String> preparedValues = PreparedAssertion.read();
    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Component.class, new ComponentGsonAdapter())
            .create();

    @Test
    void shouldSerializeComponent_whenComponentIsHDDType() {
        given();
        var HDDComponent = new HDDDrive(StorageCapacity.GB1, "foo");

        when();
        String json = gson.toJson(HDDComponent);

        then();
        assertEquals(preparedValues.get("HDD"), json);
    }

    @Test
    void shouldSerializeComponent_whenComponentIsSSDType() {
        given();
        var SSDComponent = new SSDDrive(StorageCapacity.GB1, "foo");

        when();
        String json = gson.toJson(SSDComponent);

        then();
        assertEquals(preparedValues.get("SSD"), json);
    }

    @Test
    void shouldSerializeComponent_whenComponentIsMonitorType() {
        given();
        var monitorComponent = new Monitor("foo");

        when();
        String json = gson.toJson(monitorComponent);

        then();
        assertEquals(preparedValues.get("Monitor"), json);
    }

    @Test
    void shouldSerializeComponent_whenComponentIsHeadphonesType() {
        given();
        var headphones = new Headphones("foo");

        when();
        String json = gson.toJson(headphones);

        then();
        assertEquals(preparedValues.get("Headphones"), json);
    }

    @Test
    void shouldSerializeComponent_whenComponentIsMemoryStickType() {
        given();
        var memoryStick = new MemoryStick(StorageCapacity.GB1, "foo");

        when();
        String json = gson.toJson(memoryStick);

        then();
        assertEquals(preparedValues.get("MemoryStick"), json);
    }

    @Test
    void shouldSerializeComponent_whenComponentIsMouseType() {
        given();
        var mouse = new Mouse("foo");

        when();
        String json = gson.toJson(mouse);

        then();
        assertEquals(preparedValues.get("Mouse"), json);
    }

    @Test
    void shouldThrowException_whenSerializeObjectIsNotValid() {
        given();
        var notValidObject = new Component() {
            @Override
            public String getComponentName() {
                return "foo";
            }

            @Override
            public ComponentType getComponentType() {
                return ComponentType.HDD;
            }
        };

        when();

        then();
        Assertions.assertThrows(IllegalArgumentException.class, () -> gson.toJson(notValidObject));
    }

    @Test
    void shouldReturnHDDComponentType_whenSerializedJSONIsValid() throws IOException {
        given();
        String serializedHDD = preparedValues.get("HDD");

        when();
        Component result = gson.fromJson(serializedHDD, Component.class);

        then();
        assertInstanceOf(HDDDrive.class, result);
    }

    @Test
    void shouldReturnSSDComponentType_whenSerializedJSONIsValid() throws IOException {
        given();
        String serializedSSD = preparedValues.get("SSD");

        when();
        Component result = gson.fromJson(serializedSSD, Component.class);

        then();
        assertInstanceOf(SSDDrive.class, result);
    }

    @Test
    void shouldReturnMonitorComponentType_whenSerializedJSONIsValid() throws IOException {
        given();
        String serializedMonitor = preparedValues.get("Monitor");

        when();
        Component result = gson.fromJson(serializedMonitor, Component.class);

        then();
        assertInstanceOf(Monitor.class, result);
    }

    @Test
    void shouldReturnHeadphonesComponentType_whenSerializedJSONIsValid() throws IOException {
        given();
        String serializedHeadphones = preparedValues.get("Headphones");

        when();
        Component result = gson.fromJson(serializedHeadphones, Component.class);

        then();
        assertInstanceOf(Headphones.class, result);
    }

    @Test
    void shouldReturnMemoryStickComponentType_whenSerializedJSONIsValid() throws IOException {
        given();
        String serializedMemoryStick = preparedValues.get("MemoryStick");

        when();
        Component result = gson.fromJson(serializedMemoryStick, Component.class);

        then();
        assertInstanceOf(MemoryStick.class, result);
    }

    @Test
    void shouldReturnMouseComponentType_whenSerializedJSONIsValid() throws IOException {
        given();
        String serializedMouse = preparedValues.get("Mouse");

        when();
        Component result = gson.fromJson(serializedMouse, Component.class);

        then();
        assertInstanceOf(Mouse.class, result);
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}