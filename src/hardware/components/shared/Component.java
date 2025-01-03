package hardware.components.shared;

import hardware.components.shared.enums.ComponentType;

public interface Component {
    String getComponentName();
    ComponentType getComponentType();
}
