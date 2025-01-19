package pl.jkuznik.computer.hardware.components.headphone;

import com.google.gson.Gson;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;

public class Headphones implements Component {
    private final String name;
    private transient final Gson gson = new Gson();

    public Headphones(String name) {
        this.name = name;
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.HEADPHONES;
    }

    @Override
    public String toJson() {
        return gson.toJson(this);
    }
}
