package computer.software.program;

import computer.software.program.chat.Chat;

import java.util.ArrayList;
import java.util.List;

public class ProgramHandler {

    private static volatile ProgramHandler instance;
    private final static List<Program> programs = new ArrayList<>();

    private ProgramHandler() {
        Chat chat = new Chat();
        programs.add(chat);
    }

    public void programList(){
        programs.forEach(program -> System.out.println(program.getName()));
    }

    public void startProgramByName(String programName) throws ProgramNotFoundException {
        programs.stream()
                .filter(program -> program.getName().equals(programName))
                .findFirst()
                .orElseThrow(() -> new ProgramNotFoundException("Program " + programName + " not found"))
                .startProgram();
    }

    public static ProgramHandler getInstance() {
        if (instance==null){
            synchronized (ProgramHandler.class){
                if (instance==null){
                    instance = new ProgramHandler();
                }
            }
        }
        return instance;
    }
}
