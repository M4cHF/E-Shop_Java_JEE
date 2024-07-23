package dao;

import entities.Client;
import java.util.List;

public interface DAO_Client {

    void ajouterClient(Client client);
    void deleteClient(Long id);
    Client getClient(Long id);
    List<Client> getTousClients();
    boolean authentification(String email, String password);
    String getRoleCilent(String email);
    void changerRole(long code);
}
