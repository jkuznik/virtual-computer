package pl.jkuznik.utils.persistentState.gsonTypeAdapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.computer.software.file.imagefile.GIFImageFile;
import pl.jkuznik.computer.software.file.imagefile.JPGImageFile;
import pl.jkuznik.computer.software.file.musicfile.MP3MusicFile;

import java.util.Map;

class FileAdapterGsonTest {

    private final Map<String, String> preparedValues = PreparedAssertion.read();
    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(File.class, new FileAdapterGson())
            .create();

    @Test
    void shouldSerializeFile_whenFileIsValidJPGImageFile() throws Exception {
        given();
        var file = new JPGImageFile("foo", 5, 5);

        when();
        String result = gson.toJson(file);

        then();
        Assertions.assertEquals(preparedValues.get("JpgFile"),result);
    }

    @Test
    void shouldSerializeFile_whenFileIsValidGIFImageFile() throws Exception {
        given();
        var file = new GIFImageFile("foo", 5);

        when();
        String result = gson.toJson(file);

        then();
        Assertions.assertEquals(preparedValues.get("GifFile"),result);
    }

    @Test
    void shouldSerializeFile_whenFileIsValidMP3MusicFile() throws Exception {
        given();
        var file = new MP3MusicFile("foo", 5, "bar", "bazz", 5);

        when();
        String result = gson.toJson(file);
        System.out.println(file);

        then();
        Assertions.assertEquals(preparedValues.get("Mp3File"),result);
    }


    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}