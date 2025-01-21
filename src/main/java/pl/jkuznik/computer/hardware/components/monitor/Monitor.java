package pl.jkuznik.computer.hardware.components.monitor;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;

import java.util.LinkedHashMap;
import java.util.Map;

public class Monitor implements Component {

    public static final int MAX_HEIGHT = 3840;
    private final String name;
    private int width = 3840;
    private int height = 1920;

    private transient final Gson gson = new Gson();

    public Monitor(String name) {
        this.name = name;
    }

    public static int getMaxHeight() {
        return MAX_HEIGHT;
    }

    public void setLowResolution() {
        width = 800;
        height = 600;
    }

    public void setHighResolution() {
        width = 3840;
        height = 1920;
    }

    public String getResolution() {
        return width + "x" + height;
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MONITOR;
    }

    @Override
    public String toJson() {
        Map<String, Object> jsonMap = new LinkedHashMap<>();

        jsonMap.put("type", this.getComponentType().name());
        jsonMap.put("name", name);
        jsonMap.put("height", height);
        jsonMap.put("width", width);

        return gson.toJson(jsonMap);
    }
}
