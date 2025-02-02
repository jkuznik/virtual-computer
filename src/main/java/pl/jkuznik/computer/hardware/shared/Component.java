package pl.jkuznik.computer.hardware.shared;

import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

public interface Component {
    String getComponentName();
    ComponentType getComponentType();
}
