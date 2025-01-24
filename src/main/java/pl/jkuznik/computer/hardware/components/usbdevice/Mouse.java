package pl.jkuznik.computer.hardware.components.usbdevice;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.computer.software.file.File;
import pl.jkuznik.utils.persistentState.gson.ComponentGsonAdapter;
import pl.jkuznik.utils.persistentState.gson.FileAdapterGson;

public class Mouse implements USBDevice {
    private final String name;

    private transient final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(File.class, new FileAdapterGson())
            .registerTypeHierarchyAdapter(Component.class, new ComponentGsonAdapter())
            .create();

    public Mouse(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean connect() {
        System.out.println("Mouse connected");
        return true;
    }

    @Override
    public boolean disconnect() {
        System.out.println("Mouse disconnected");
        return true;
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MOUSE;
    }

    @Override
    public String toJson() {
        return gson.toJson(this);
    }
}
