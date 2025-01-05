package software.program.chat;

import software.program.Program;

public class Chat implements Program {

    private final String NAME = "Gadu gadu";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void startGame() {
        System.out.println("Chat się uruchamia");
    }
}
