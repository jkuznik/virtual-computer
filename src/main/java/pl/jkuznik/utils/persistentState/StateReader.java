package pl.jkuznik.utils.persistentState;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import pl.jkuznik.computer.hardware.components.drive.Drive;
import pl.jkuznik.computer.hardware.components.headphone.Headphones;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.components.usbdevice.MemoryStick;
import pl.jkuznik.computer.hardware.components.usbdevice.Mouse;
import pl.jkuznik.computer.hardware.shared.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StateReader {

    private final Path path = Paths.get(FilePath.COMPUTER_STATE.getPath());
    private final Gson gson = new Gson();
    private final List<Component> components = new ArrayList<>();

    public List<Component> readState(){
        try {
            List<String> lines = Files.readAllLines(path);

            for(String line: lines) {
                JsonElement jsonElement = JsonParser.parseString(line);
                String type = jsonElement.getAsJsonObject().get("type").getAsString();

                Component component = null;
                switch (type) {
                    case "MONITOR" -> component = gson.fromJson(line, Monitor.class);
                    case "MOUSE" -> component = gson.fromJson(line, Mouse.class);
                    case "HEADPHONES" -> component = gson.fromJson(line, Headphones.class);
                    case "MEMORYSTICK" -> component = gson.fromJson(line, MemoryStick.class);
                    case "DRIVE" -> component = gson.fromJson(line, Drive.class);
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
