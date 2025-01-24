package pl.jkuznik.utils.persistentState.gson;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.lang.reflect.Type;
import java.util.List;

public class FileHandlerAdapterGson implements JsonSerializer<FileHandler>, JsonDeserializer<FileHandler> {

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
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        StorageCapacity storageCapacity = StorageCapacity.valueOf(jsonObject.get("storageCapacity").getAsString());

        List<File> files = jsonDeserializationContext.deserialize(jsonObject.get("files"), new TypeToken<List<File>>() {}.getType());

        FileHandler fileHandler = new FileHandler(storageCapacity);
        files.forEach(fileHandler::addFile);

        return fileHandler;
    }
}
