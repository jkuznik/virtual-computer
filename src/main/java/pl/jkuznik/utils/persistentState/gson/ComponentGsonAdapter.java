package pl.jkuznik.utils.persistentState.gson;

import com.google.gson.*;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;

import java.lang.reflect.Type;

import static pl.jkuznik.computer.hardware.shared.enums.ComponentType.valueOf;

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
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();

        ComponentType componentType = valueOf(jsonObject.get("componentType").getAsString());

        switch (componentType) {
            case DRIVE -> {
                return null;
            }
            case HEADPHONES -> {
                return new Headphones(name);
            }
            case MONITOR -> {
                var monitor = new Monitor(name);
                monitor.setHeight(jsonObject.get("height").getAsInt());
                monitor.setWidth(jsonObject.get("width").getAsInt());

                return monitor;
            }
            case MEMORYSTICK -> {
                return null;
            }
            case MOUSE -> {
                return new Mouse(name);
            }
            default -> throw new JsonParseException("Can not parse to Component type JSON of " + jsonElement.getAsString());
        }
    }
}
