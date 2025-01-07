package main.software.program;

import main.software.program.chat.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

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

    public void startProgramByName(String programName) {
        programs.stream()
                .filter(program -> program.getName().equals(programName))
                .findFirst()
                .orElseThrow(NoSuchElementException::new)
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
