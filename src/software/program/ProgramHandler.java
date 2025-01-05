package software.program;

import java.util.ArrayList;
import java.util.List;

public class ProgramHandler {

    private static volatile ProgramHandler instance;
    private static List<Program> programs = new ArrayList<>();

    private ProgramHandler() {
    }

    public ProgramHandler getInstance() {
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
