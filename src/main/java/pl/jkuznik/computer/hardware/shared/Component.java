package pl.jkuznik.computer.hardware.shared;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;


public interface Component {
    @NotNull
    @NotBlank
    String getComponentName();
    @NotNull
    ComponentType getComponentType();
}
