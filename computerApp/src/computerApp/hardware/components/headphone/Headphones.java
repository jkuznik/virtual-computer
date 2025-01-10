package computerApp.hardware.components.headphone;

import computerApp.hardware.components.shared.enums.ComponentType;
import computerApp.hardware.components.shared.Component;

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
