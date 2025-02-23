package pl.jkuznik.utils.persistentState.gsonTypeAdapter;

import com.google.gson.*;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.FileType;
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;

import java.lang.reflect.Type;

import static pl.jkuznik.computer.software.file.FileType.*;

public class FileAdapterGson implements JsonSerializer<File>, JsonDeserializer<File> {


    @Override
    public JsonElement serialize(File srcFile, Type typeOfSrc, JsonSerializationContext jsonSerializationContext) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("fileType", srcFile.getFileType().name());
        jsonObject.addProperty("name", srcFile.getName());
        jsonObject.addProperty("size", srcFile.getSize());

        switch (srcFile) {
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
            default -> throw new JsonParseException("Unsupported file type: " + srcFile.getClass().getName());
        }
        return jsonObject;
    }

    @Override
    public File deserialize(JsonElement jsonElement, Type jsonType, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        JsonObject jsonObject = jsonElement.getAsJsonObject();
        String name = jsonObject.get("name").getAsString();
        long size = jsonObject.get("size").getAsLong();

        FileType fileType = valueOf(jsonObject.get("fileType").getAsString());

        switch (fileType) {
            case GIF -> {
                return new GIFImageFile(name, size);
            }
            case JPG -> {
                int compression = jsonObject.get("compression").getAsInt();
                return new JPGImageFile(name, size, compression);
            }
            case MP3 -> {
                String bandName = jsonObject.get("bandName").getAsString();
                String title = jsonObject.get("title").getAsString();
                int quality = jsonObject.get("quality").getAsInt();
                return new MP3MusicFile(name, size, bandName, title, quality);
            }
            default -> throw new JsonParseException("Can not parse to File type JSON of " + jsonElement.getAsString());
        }
    }
}
