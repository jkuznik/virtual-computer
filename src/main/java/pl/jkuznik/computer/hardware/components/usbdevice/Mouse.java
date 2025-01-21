package pl.jkuznik.computer.hardware.components.usbdevice;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Mouse implements USBDevice {
    private final String name;

    private transient final Gson gson = new Gson();

    public Mouse(String name) {
        this.name = name;
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
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        jsonMap.put("type", this.getComponentType().name());
        jsonMap.put("name", name);

        return gson.toJson(jsonMap);
    }
}
