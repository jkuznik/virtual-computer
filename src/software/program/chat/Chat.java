package software.program.chat;

import software.program.Program;
import utils.ConsoleReader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Chat implements Program {
    private static final String SERVER_ADDRESS = "localhost";
    private static final int SERVER_PORT = 9999; // Currently Chat server is listening on port 9999
    private static final ConsoleReader consoleReader = ConsoleReader.getInstance();

    private final String NAME = "Gadu gadu";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void startGame() {
        try (
                Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
                PrintWriter serverOutput = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader serverInput = new BufferedReader(new InputStreamReader(socket.getInputStream()))
        ) {

            ExecutorService chatThread = Executors.newSingleThreadExecutor();

            chatThread.execute(() -> {
                try {
                    String serverMessage;
                    while ((serverMessage = serverInput.readLine()) != null) {
                        System.out.println("Server: " + serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Error receiving server messages: " + e.getMessage());
                }
            });

            System.out.println("Connected to the server. Type 'exit' to quit.");

            String userMessage;
            while (true) {
                userMessage = consoleReader.getScanner().nextLine();
                if ("exit".equalsIgnoreCase(userMessage)) {
                    System.out.println("Zakończenie czatu...");
                    break;
                }
                serverOutput.println(userMessage); // Send message to the server
            }
        } catch (IOException e) {
        System.out.println("Błąd podczas łączenia się z czatem");
    }
    }
}
