package computer.hardware.components.headphone;

import computer.hardware.shared.enums.ComponentType;
import computer.hardware.shared.Component;

public class Headphones implements Component {
    private final String name;

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
}
