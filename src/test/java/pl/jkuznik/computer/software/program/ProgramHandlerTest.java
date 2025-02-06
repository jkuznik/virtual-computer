package pl.jkuznik.computer.software.program;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProgramHandlerTest {
    private final ProgramHandler programHandler = ProgramHandler.getInstance();

    @Test
    void shouldReturnNotEmptyProgramList() {
        given();

        when();
        List<Program> result = programHandler.programList();

        then();
        Assertions.assertFalse(result.isEmpty());
    }

    @Test
    void shouldStartProgram_whenProgramExists() throws NoSuchFieldException, IllegalAccessException, ProgramNotFoundException {
        given();
        Field programsField = programHandler.getClass().getDeclaredField("programs");
        programsField.setAccessible(true);
        var programList = (List<Program>) programsField.get(programHandler);

        Program program = Mockito.mock(Program.class);
        programList.add(program);

        when();
        Mockito.when(program.getName()).thenReturn("foo");

        then();
        programHandler.startProgramByName("foo");
        Mockito.verify(program).startProgram();
    }

    @Test
    void shouldThrowException_whenProgramDoesNotExist() throws ProgramNotFoundException {
        given();

        when();

        then();
        assertThrows(ProgramNotFoundException.class, () -> programHandler.startProgramByName("bar"));
    }

    private void given() {
    }

    private void when() {
    }

    private void then() {
    }
}