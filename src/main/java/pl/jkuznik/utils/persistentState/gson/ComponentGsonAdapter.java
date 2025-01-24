package pl.jkuznik.utils.persistentState.gson;

import com.google.gson.*;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.Component;

import java.lang.reflect.Type;

public class ComponentGsonAdapter implements JsonSerializer<Component>, JsonDeserializer<Component> {
    @Override
    public JsonElement serialize(Component srcComponent, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
        System.out.println("Adapter log");

        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("componentType", srcComponent.getComponentType().name());
        jsonObject.addProperty("name", srcComponent.getComponentName());

        if (srcComponent instanceof AbstractDrive abstractDrive) {
            jsonObject.addProperty("fileHandler", abstractDrive.getFileHandler().toString());
        } else if (srcComponent instanceof Headphones headphones) {
            // nic specialnego
        } else if (srcComponent instanceof Monitor monitor) {
            jsonObject.addProperty("width", monitor.getWidth());
            jsonObject.addProperty("height", monitor.getHeight());
        } else if (srcComponent instanceof MemoryStick memoryStick) {
            jsonObject.addProperty("fileHandler", memoryStick.getFileHandler().toString());
            jsonObject.addProperty("ejected", memoryStick.isEjected());
        } else if (srcComponent instanceof Mouse mouse) {
            // nic specialnego
        } else {
            throw new IllegalArgumentException("Unexpected value: " + srcComponent);
        }

        return jsonObject;
    }

    @Override
    public Component deserialize(JsonElement jsonElement, Type typeOfSrc, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
