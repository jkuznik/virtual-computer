package computerApp;

import chatServer.ChatServer;
import computerApp.userInterface.UserInterface;

public class ComputerApp {

    public static void main(String[] args) {
       UserInterface.userInterface();
       ChatServer chatServer = new ChatServer();
    }
}
