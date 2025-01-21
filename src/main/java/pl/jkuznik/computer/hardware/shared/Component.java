package pl.jkuznik.computer.hardware.shared;

import pl.jkuznik.computer.hardware.shared.enums.ComponentType;

public interface Component {
    String getComponentName();
    ComponentType getComponentType();
    String toJson();
}
