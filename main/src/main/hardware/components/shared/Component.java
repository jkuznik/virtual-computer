package main.hardware.components.shared;

import main.hardware.components.shared.enums.ComponentType;

public interface Component {
    String getComponentName();
    ComponentType getComponentType();
}
