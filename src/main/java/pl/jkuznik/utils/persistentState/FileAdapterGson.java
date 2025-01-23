package pl.jkuznik.utils.persistentState;

import com.google.gson.*;
import pl.jkuznik.computer.software.file.File;

import java.lang.reflect.Type;

public class FileAdapterGson implements JsonSerializer<File>, JsonDeserializer<File> {


    @Override
    public JsonElement serialize(File file, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("");
        return null;
    }

    @Override
    public File deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
