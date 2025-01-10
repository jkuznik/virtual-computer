package computerApp.software.program.chat;

import computerApp.software.program.Program;
import computerApp.utils.ConsoleReader;

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

    private final String NAME = "gg";

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void startProgram() {
        System.out.println("Podaj nick: ");
        String nickName = consoleReader.getScanner().nextLine();

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
                        System.out.println(serverMessage);
                    }
                } catch (IOException e) {
                    System.out.println("Błąd podczas obierania wiadomości: " + e.getMessage());
                } finally {
                    chatThread.shutdown();
                }
            });

            System.out.println("Połączono z serwerem. Aby wyjść wpisz 'exit'");

            String userMessage;
            while (true) {
                userMessage = consoleReader.getScanner().nextLine();
                if ("exit".equalsIgnoreCase(userMessage)) {
                    serverOutput.println(nickName + " żegna się!");
                    serverOutput.println((socket + "exit"));
                    System.out.println("Zakończenie czatu...");
                    break;
                }
                serverOutput.println(nickName + ": " + userMessage);
            }
        } catch (IOException e) {
            System.out.println("Błąd podczas łączenia się z czatem");
        }
    }
}
