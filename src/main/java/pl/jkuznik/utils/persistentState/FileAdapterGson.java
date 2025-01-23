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

        if (src instanceof GIFImageFile gifImageFile) {
//            obecnie gif nie posiada wyróżniającego argumentu, dlatego ten blok jest pusty
        } else if (src instanceof JPGImageFile jpgImageFile) {
            jsonObject.addProperty("compression", jpgImageFile.getCompression());
        } else if (src instanceof MP3MusicFile mp3MusicFile) {
            jsonObject.addProperty("bandName", mp3MusicFile.getBandName());
            jsonObject.addProperty("title", mp3MusicFile.getTitle());
            jsonObject.addProperty("quality", mp3MusicFile.getQuality());
        } else {
            throw new JsonParseException("Unsupported file type: " + src.getClass().getName());
        }

        return jsonObject;
    }

    @Override
    public File deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }
}
