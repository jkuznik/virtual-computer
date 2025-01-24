package pl.jkuznik.utils.persistentState.gson;

import com.google.gson.*;
import pl.jkuznik.computer.hardware.components.drive.AbstractDrive;

import java.lang.reflect.Type;

public class DriveAdapterGson implements JsonSerializer<AbstractDrive>, JsonDeserializer<AbstractDrive> {

    @Override
    public JsonElement serialize(AbstractDrive srcDrive, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
//        jsonObject.addProperty("");
        return null;
    }

    @Override
    public AbstractDrive deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
