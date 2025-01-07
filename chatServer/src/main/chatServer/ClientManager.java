package main.chatServer;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class ClientManager {

    private static final Set<PrintWriter> clients = Collections.synchronizedSet(new HashSet<>());

    public void addClient(PrintWriter newClient) {
        clients.add(newClient);
    }

    public void removeClient(PrintWriter clientToRemove) {
        clients.remove(clientToRemove);
    }

    public Set<PrintWriter> getClients() {
        return clients;
    }

    public void sendMessage(String message) {
        System.out.println(message);
        synchronized (clients) {
            clients.forEach(client -> client.println(message));
        }
    }
}
