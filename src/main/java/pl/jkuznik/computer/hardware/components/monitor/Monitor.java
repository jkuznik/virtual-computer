package pl.jkuznik.computer.hardware.components.monitor;

import pl.jkuznik.computer.hardware.shared.Component;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

public class Monitor implements Component {
    public static final int MAX_HEIGHT = 3840;

    private final String name;
    private int width = 3840;
    private int height = 1920;

    public Monitor(String name) {
        this.name = name;
    }

    public static int getMaxHeight() {
        return MAX_HEIGHT;
    }

    public void setLowResolution() {
        width = 800;
        height = 600;
    }

    public void setHighResolution() {
        width = 3840;
        height = 1920;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getResolution() {
        return width + "x" + height;
    }

    @Override
    public String getComponentName() {
        return name;
    }

    @Override
    public ComponentType getComponentType() {
        return ComponentType.MONITOR;
    }

}
