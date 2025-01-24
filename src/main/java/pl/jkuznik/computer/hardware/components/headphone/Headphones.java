package pl.jkuznik.computer.hardware.components.headphone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared.enums.ComponentType;
import pl.jkuznik.utils.persistentState.gson.ComponentGsonAdapter;

public class Headphones implements Component {
    private final String name;
    private transient final Gson gson = new GsonBuilder()
            .registerTypeHierarchyAdapter(Component.class, new ComponentGsonAdapter())
            .create();

    public Headphones(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
