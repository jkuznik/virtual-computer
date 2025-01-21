package pl.jkuznik.computer.hardware.components.drive;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.FileHandler;
import pl.jkuznik.computer.hardware.shared.FileStorage;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.hardware.shared.enums.StorageCapacity;
import pl.jkuznik.computer.software.file.File;

import java.io.FileNotFoundException;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class AbstractDrive implements Drive, FileStorage {
    private transient final FileHandler fileHandler;
    private final String name;

    private transient final Gson gson = new Gson();

    public AbstractDrive(StorageCapacity storageCapacity, String name) {
        this.fileHandler = new FileHandler(storageCapacity);
        this.name = name;
    }

    //  TODO: metoda do zaimplementowania w kolejnym tasku
    @Override
    public void getWriteSpeed() {

    }

    //  TODO: metoda do zaimplementowania w kolejnym tasku
    @Override
    public void getReadSpeed() {

    }

    @Override
    public void addFile(File file) {
        fileHandler.addFile(file);
    }

    @Override
    public void getFiles() {
        fileHandler.getFiles();
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
        return ComponentType.DRIVE;
    }

    @Override
    public String toJson() {
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        jsonMap.put("type", this.getComponentType().name());
        jsonMap.put("name", name);
        // TODO: zaimplementować toJson w fileHandler aby umożliwić zapisanie stanu plików
//        jsonMap.put("fileHandler", fileHandler.toString());

        return gson.toJson(jsonMap);
    }
}
