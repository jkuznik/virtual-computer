package pl.jkuznik.computer.hardware.shared;

import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchException;

class ComponentTest {

    @Test
    void shouldGetComponentName_whenComponentNameIsValid() {
        given();
        Component component = new Monitor("foo");

        when();
        String testedValue = component.getComponentName();

        then();
        assertThat("foo").isEqualTo(testedValue);
    }

    @Test
    void shouldThrowException_whenComponentNameIsNotValid() {
        given();
        Component component = new Monitor(null);

        when();
        Exception exception = catchException(() -> component.getComponentName());

        then();
        assertThat(exception).doesNotThrowAnyException();
    }

    @Test
    void getComponentType() {
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}