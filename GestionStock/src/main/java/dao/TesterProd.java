package dao;

import entities.Client;
import entities.Produit;
import utility.SingletonConnection;

import java.util.ArrayList;

public class TesterProd {
    public static void main(String[] args) {

        SingletonConnection.setUser("root");
        SingletonConnection.setPassword("");
        SingletonConnection.seConnecter();

        Produit p = new Produit(3, "mobile", 1500);
        Produit p1 = new Produit(1, "smartPhone", 2000);
        Produit p2 = new Produit(2, "tablette", 1000);
        DAOProduit dao = new DAOProduit();

        //dao.ajouterProduit(p);
        //dao.modifierProduit(p1);
        //dao.ajouterProduit(p);
        //dao.ajouterProduit(p2);
        //dao.archiverProduit(3l);

        //Produit pp = dao.getProduit(2l);
        //System.out.println(pp.getLibelle());

//        dao.modifierProduit(new Produit(3l, "tv", 1500));
//        ArrayList<Produit> l = new ArrayList<>(dao.getTousProduits());
//        l.forEach(produit -> System.out.println(produit.getLibelle()));

        Client cl = new Client("ahmed", "hamemi", "ahmed@gmail.com");

        DAOClient daoClient = new DAOClient();
        daoClient.ajouterClient(cl);
    }
}
