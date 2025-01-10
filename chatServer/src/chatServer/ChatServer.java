package chatServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ChatServer {
    private static final int PORT = 9999;
    private static final ClientManager clientManager = new ClientManager();
    private static final ExecutorService openConnections = Executors.newFixedThreadPool(20);
    private static boolean stillRunning = true;

    public static void main(String[] args) {
        System.out.println("Start serwera...");

        ExecutorService shutDownListener = Executors.newSingleThreadExecutor();
        try {
            shutDownListener.execute(() -> {
                try(Scanner scanner = new Scanner(System.in)){
                    String userInput;

                    while (true) {
                        userInput = scanner.nextLine();
                        if (userInput.equalsIgnoreCase("exit")) {
                            System.out.println("Zamykanie serwera...");
                            stillRunning = false;
                            break;
                        }
                    }
                }
            });
        } finally {
            shutDownListener.shutdown();
        }

        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(PORT);
            while (stillRunning) {
                try {
                    serverSocket.setSoTimeout(5000);
                    Socket newClient = serverSocket.accept();
                    System.out.println("Nowy użytkownik podłączony");
                    openConnections.execute(new ClientHandler(newClient, clientManager));
                } catch (SocketTimeoutException ste) {
                    if (!stillRunning) {
                        System.out.println("Serwer został zatrzymany.");
                        break;
                    }
                    System.out.println("Current users connected: " + clientManager.getClients().size());
                } catch (IOException e) {
                    System.out.println("Błąd połączenia nowego użytkownika: " + e.getMessage());
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("Błąd przy uruchamianiu serwera: " + e.getMessage());
        } finally {
            shutdownServer();
        }
    }

    private static void shutdownServer() {
        System.out.println("Zamykanie zasobów serwera...");
        try {
            clientManager.getClients().forEach(client ->
                    client.close());
        } catch (Exception e) {
            System.out.println("Błąd przy zamykaniu klientów: " + e.getMessage());
        }
        openConnections.shutdown();
        System.out.println("Serwer zamknięty.");
    }
}


