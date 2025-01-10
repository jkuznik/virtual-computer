package computerApp.hardware.components.shared;

import computerApp.hardware.components.shared.enums.ComponentType;

public interface Component {
    String getComponentName();
    ComponentType getComponentType();
}
