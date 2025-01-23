package pl.jkuznik.utils.persistentState;

import com.google.gson.*;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;
import pl.jkuznik.computer.software.file.musicfile.MusicFile;

import java.lang.reflect.Type;

public class FileAdapterGson implements JsonSerializer<File>, JsonDeserializer<File> {


    @Override
    public JsonElement serialize(File src, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("type", src.getClass().getSimpleName());
        jsonObject.addProperty("name", src.getName());
        jsonObject.addProperty("size", src.getSize());

        switch (src) {
            case GIFImageFile gifImageFile -> {
//            obecnie gif nie posiada wyróżniającego argumentu, dlatego ten blok jest pusty
            }
            case JPGImageFile jpgImageFile -> {
                jsonObject.addProperty("compression", jpgImageFile.getCompression());
            }
            case MP3MusicFile mp3MusicFile -> {
                jsonObject.addProperty("bandName", mp3MusicFile.getBandName());
                jsonObject.addProperty("title", mp3MusicFile.getTitle());
                jsonObject.addProperty("quality", mp3MusicFile.getQuality());
            }
            default -> throw new JsonParseException("Unsupported file type: " + src.getClass().getName());
        }

        return jsonObject;
    }

    @Override
    public File deserialize(JsonElement jsonElement, Type jsonType, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String type = jsonObject.get("type").getAsString();
        String name = jsonObject.get("name").getAsString();
        long size = jsonObject.get("size").getAsLong();

        switch (type) {
            case
        }
        return null;
    }
}
