package computer.hardware.shared;

import computer.hardware.shared.enums.ComponentType;

public interface Component {
    String getComponentName();
    ComponentType getComponentType();
}
