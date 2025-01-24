package pl.jkuznik.utils.persistentState.gson;

import com.google.gson.*;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.software.file.File;

import java.lang.reflect.Type;

public class ComponentGsonAdapter implements JsonSerializer<Component>, JsonDeserializer<Component> {
    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(FileHandlerAdapterGson.class, new FileHandlerAdapterGson())
            .create();

    @Override
    public JsonElement serialize(Component srcComponent, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("componentType", srcComponent.getComponentType().name());
        jsonObject.addProperty("name", srcComponent.getComponentName());

        switch (srcComponent) {
            case AbstractDrive abstractDrive ->
                    jsonObject.add("fileHandler", jsonSerializationContext.serialize(abstractDrive.getFileHandler()));
            case Headphones headphones -> {
                // nic specialnego
            }
            case Monitor monitor -> {
                jsonObject.addProperty("width", monitor.getWidth());
                jsonObject.addProperty("height", monitor.getHeight());
            }
            case MemoryStick memoryStick -> {
                jsonObject.add("fileHandler", jsonSerializationContext.serialize(memoryStick.getFileHandler()));
                jsonObject.addProperty("ejected", memoryStick.isEjected());
            }
            case Mouse mouse -> {
                // nic specialnego
            }
            default -> throw new IllegalArgumentException("Unexpected value: " + srcComponent);
        }

        return jsonObject;
    }

    @Override
    public Component deserialize(JsonElement jsonElement, Type typeOfSrc, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
