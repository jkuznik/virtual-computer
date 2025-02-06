package pl.jkuznik.computer.software.program;

import pl.jkuznik.computer.software.program.chat.Chat;

import java.util.ArrayList;
import java.util.List;

public class ProgramHandler {

    private static volatile ProgramHandler instance;
    private final static List<Program> programs = new ArrayList<>();

    private ProgramHandler() {
        Chat chat = new Chat();
        programs.add(chat);
    }

    public List<Program> programList(){
        return programs;
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
