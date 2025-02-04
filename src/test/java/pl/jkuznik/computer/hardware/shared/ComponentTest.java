package pl.jkuznik.computer.hardware.shared;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.hibernate.validator.messageinterpolation.ResourceBundleMessageInterpolator;
import org.hibernate.validator.resourceloading.PlatformResourceBundleLocator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.jkuznik.computer.hardware.components.monitor.Monitor;
import pl.jkuznik.computer.hardware.shared._enums.ComponentType;

import java.util.Locale;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

class ComponentTest {
    private Validator validator;

    @BeforeEach
    void setUp() {
        Locale.setDefault(Locale.ENGLISH);

        try (
                ValidatorFactory validatorFactory = Validation.byDefaultProvider()
                        .configure()
                        .messageInterpolator(new ResourceBundleMessageInterpolator(
                                new PlatformResourceBundleLocator("ValidationMessages", Set.of(Locale.ENGLISH))
                        ))
                        .buildValidatorFactory()
        ) {
            validator = validatorFactory.getValidator();
        }
    }


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
        Set<ConstraintViolation<Component>> validate = validator.validate(component);

        then();
        assertThat(validate).isNotEmpty();
        assertThat(validate)
                .extracting(ConstraintViolation::getMessage)
                .contains("must not be null");
    }

    @Test
    void shouldThrowException_whenComponentNameIsNotValid2() {
        given();
        Component component = new Monitor("");

        when();
        Set<ConstraintViolation<Component>> validate = validator.validate(component);

        then();
        assertThat(validate).isNotEmpty();
        assertThat(validate)
                .extracting(ConstraintViolation::getMessage)
                .contains("must not be blank");
    }

    @Test
    void getComponentType() {
        given();
        var monitor = new Monitor("foo");

        when();
        ComponentType result = monitor.getComponentType();

        then();
        assertThat(ComponentType.MONITOR).isEqualTo(result);
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}