package pl.jkuznik.chatServer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientHandler implements Runnable {

    private final Socket socket;
    private final ClientManager clientManager;
    private PrintWriter receiver;

    public ClientHandler(Socket socket, ClientManager clientManager) {
        this.socket = socket;
        this.clientManager = clientManager;
    }
    @Override
    public void run() {
        try(BufferedReader messageIn = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            receiver = new PrintWriter(socket.getOutputStream(), true);
            clientManager.addClient(receiver);

            System.out.println("Dołączyłeś do czatu");
            clientManager.sendMessage(socket + " dołączył do czatu");

            String message;
            while ((message = messageIn.readLine()) != null) {
                if ((socket + "exit").equalsIgnoreCase(message)) {
                    break;
                }
                clientManager.sendMessage(message);
            }
        } catch (IOException e) {
            System.out.println("Błąd wysyłania wiadomości przez użytkownika " + socket);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println("Błąd przy zamykaniu gniazda: " + e.getMessage());
            }

            clientManager.removeClient(receiver);
            clientManager.sendMessage("Klient opuścił czat: " + socket);
            System.out.println("Połączenie zakończone: " + socket);
        }
    }
}