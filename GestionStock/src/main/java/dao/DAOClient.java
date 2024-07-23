package dao;

import com.mysql.jdbc.Connection;
import entities.Client;
import utility.SingletonConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOClient implements DAO_Client{
    Connection conx = (Connection) SingletonConnection.seConnecter();

    @Override
    public void ajouterClient(Client client) {
        String query = "INSERT INTO client(username, email, password) VALUES (?, ?, ?)";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setString(1, client.getUsername());
            pst.setString(2,client.getEmail());
            pst.setString(3, client.getPassword());
            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Client ajouté avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void deleteClient(Long id) {
        String query = "DELETE FROM client WHERE codeCl = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setLong(1, id);

            int n = pst.executeUpdate();
            if(n == 1){
                System.out.println("Client supprime avec succés");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }

    @Override
    public Client getClient(Long id) {
        return null;
    }

    @Override
    public List<Client> getTousClients() {
        List<Client> clients = new ArrayList<>();
        String query = "SELECT * FROM client";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Client client = new Client(
                        result.getLong("codeCl"),
                        result.getString("username"),
                        result.getString("email"),
                        result.getString("password"),
                        result.getString("role")
                );
                clients.add(client);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return clients;
    }

    @Override
    public boolean authentification(String email, String password) {
        String query = "SELECT * FROM client WHERE password = ? AND email = ?";
        boolean usserApproved = false;
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setString(1, password);
            pst.setString(2, email);

            ResultSet result = pst.executeQuery();
            if(result.next()){
                usserApproved = true;
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return usserApproved;
    }

    @Override
    public String getRoleCilent(String email) {
        String role = null;
        String query = "SELECT role FROM client WHERE email = ?";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setString(1, email);
            ResultSet result = pst.executeQuery();
            if(result.next()){
                role =  result.getString(1);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return role;
    }

    @Override
    public void changerRole(long code) {
        String query = "UPDATE client" +
                " SET role = ? WHERE codeCl = ? ;";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            pst.setString(1, "admin");
            pst.setLong(2,code);

            int n = pst.executeUpdate();
            if(n != 0){
                System.out.println("Client devient ADMIN");
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
    }
}
