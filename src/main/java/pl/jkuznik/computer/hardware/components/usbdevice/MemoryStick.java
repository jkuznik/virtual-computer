package pl.jkuznik.computer.hardware.components.usbdevice;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.FileStorage;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public class MemoryStick implements USBDevice, FileStorage {
    @Expose(serialize = false, deserialize = false)
    private final FileHandler fileHandler;
    private final String name;
    private boolean ejected = false;

    private transient final Gson gson = new Gson();

    public MemoryStick(StorageCapacity storageCapacity, String name) {
        this.fileHandler = new FileHandler(storageCapacity);
        this.name = name;
    }

    @Override
    public boolean connect() {
        System.out.println("Connected Memory Stick");
        return true;
    }

    @Override
    public boolean disconnect() {
        if (!ejected) {
            System.out.println("Please eject Memory Stick first");
            return false;
        } else {
            System.out.println("Memory Stick disconnected");
            return true;
        }
    }

    public void eject() {
        System.out.println("Ejecting Memory Stick");
        ejected = true;
    }


    @Override
    public void addFile(File file) {
        fileHandler.addFile(file);
    }

    @Override
    public void listFiles() {
        fileHandler.listFiles();
    }

    @Override
    public void removeFile(File file) {
        fileHandler.removeFile(file);
    }

    @Override
    public File findFile(String fileName) throws FileNotFoundException {
        return fileHandler.findFile(fileName);
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MEMORYSTICK;
    }

    @Override
    public String toJson() {
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        jsonMap.put("type", this.getComponentType().name());
        jsonMap.put("name", name);
        jsonMap.put("ejected", ejected);
        // TODO: toJson w fileHandler
        jsonMap.put("fileHandler", fileHandler.toString());

        return gson.toJson(jsonMap);
    }
}
