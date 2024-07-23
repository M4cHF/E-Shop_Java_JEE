package dao;

import com.mysql.jdbc.Connection;
import entities.Commande;
import utility.SingletonConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DAOCommande implements DAO_Commande {
    com.mysql.jdbc.Connection conx = (Connection) SingletonConnection.seConnecter();

    @Override
    public List<Commande> getTousCommandes() {
        List<Commande> commandes = new ArrayList<>();
        String query = "SELECT * FROM commande";
        try{
            PreparedStatement pst = conx.prepareStatement(query);
            ResultSet result = pst.executeQuery();
            while (result.next()) {
                Commande commande = new Commande(
                        result.getLong("codeCom"),
                        result.getDate("dateCom")
                );
                commandes.add(commande);
            }
        }catch(SQLException e){
            System.err.println(e.getMessage());
        }
        return commandes;
    }
}
