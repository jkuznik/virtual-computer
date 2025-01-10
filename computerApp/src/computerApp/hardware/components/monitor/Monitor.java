package computerApp.hardware.components.monitor;

import computerApp.hardware.components.shared.enums.ComponentType;
import computerApp.hardware.components.shared.Component;

public class Monitor implements Component {

    public static final int MAX_HEIGHT = 3840;

    private int width = 3840;
    private int height = 1920;
    private final String name;

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
