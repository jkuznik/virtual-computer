package pl.jkuznik.utils.persistentState.gson;

import com.google.gson.*;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.software.file.File;

import java.lang.reflect.Type;

public class FileHandlerAdapterGson implements JsonSerializer<FileHandler>, JsonDeserializer<FileHandler> {

    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(File.class, new FileAdapterGson())
            .create();

    @Override
    public JsonElement serialize(FileHandler fileHandler, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("storageCapacity", fileHandler.getStorageCapacity().name());
        jsonObject.addProperty("currentCapacity", fileHandler.getCurrentCapacity());
        jsonObject.add("files", jsonSerializationContext.serialize(fileHandler.getFiles()));

        return jsonObject;
    }

    @Override
    public FileHandler deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
