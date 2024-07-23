package entities;

import java.util.List;

public class Client {
    private long codeClient;
    private String username;
    private String password;
    private String email;
    private String role;

    // private List<Commande> listCommandesClient;

    public Client() {
    }
    public Client(String username,String email, String password)  {
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public Client(long codeClient, String username, String email, String password)  {
        this.codeClient = codeClient;
        this.username = username;
        this.password = password;
        this.email = email;
    }
    public Client(long codeClient, String username, String email, String password, String role)  {
        this.codeClient = codeClient;
        this.username = username;
        this.password = password;
        this.email = email;
        this.role = role;
    }


    // Gettres
    public long getCodeClient() {
        return codeClient;
    }
    public String getPassword() {
        return password;
    }
    public String getUsername() {
        return username;
    }
    public String getEmail() {
        return email;
    }
    public String getRole() {
        return role;
    }

    // Setters
    public void setCodeClient(long codeClient) {
        this.codeClient = codeClient;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public void setRole(String role) {
        this.role = role;
    }
}
