package pl.jkuznik.utils.persistentState;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import pl.jkuznik.computer.hardware.components.drive.HDDDrive;
import pl.jkuznik.computer.hardware.components.drive.SSDDrive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.utils._enums.FilePath;
import pl.jkuznik.utils.persistentState.gsonTypeAdapter.ComponentGsonAdapter;
import pl.jkuznik.utils.persistentState.gsonTypeAdapter.FileAdapterGson;
import pl.jkuznik.utils.persistentState.gsonTypeAdapter.FileHandlerAdapterGson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static pl.jkuznik.computer.hardware.shared._enums.ComponentType.valueOf;

public class StateReader {
    private final List<Component> components = new ArrayList<>();

    private final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Component.class, new ComponentGsonAdapter())
            .registerTypeHierarchyAdapter(FileHandler.class, new FileHandlerAdapterGson())
            .registerTypeHierarchyAdapter(File.class, new FileAdapterGson())
            .create();

    public List<Component> readState(Path path) {
        try {
            List<String> lines = Files.readAllLines(path);

            for (String line : lines) {
                JsonElement jsonElement = JsonParser.parseString(line);
                ComponentType componentType = valueOf(jsonElement.getAsJsonObject().get("componentType").getAsString());

                Component component = null;
                switch (componentType) {
                    case HDD -> component = gson.fromJson(line, HDDDrive.class);
                    case SSD -> component = gson.fromJson(line, SSDDrive.class);
                    case MONITOR -> component = gson.fromJson(line, Monitor.class);
                    case MOUSE -> component = gson.fromJson(line, Mouse.class);
                    case HEADPHONES -> component = gson.fromJson(line, Headphones.class);
                    case MEMORY_STICK -> component = gson.fromJson(line, MemoryStick.class);
                }

                if (component != null) {
                    components.add(component);
                }
            }
        } catch (IOException e) {
            System.out.println("File .computer-state.txt not found");
        }
        return components;
    }
}
