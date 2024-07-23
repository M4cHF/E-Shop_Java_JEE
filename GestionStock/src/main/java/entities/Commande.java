package entities;

import java.util.Date;
import java.util.List;

public class Commande {
    private long codeCommande;
    private Date dateCommande;

    //private List<Produit> listProduitsCommande;

    public Commande(long codeCommande, Date dateCommande) {
        this.dateCommande = dateCommande;
        this.codeCommande = codeCommande;
    }

    // Getters
    public long getCodeCommande() {
        return codeCommande;
    }
    public Date getDateCommande() {
        return dateCommande;
    }

    // Setters
    public void setCodeCommande(long codeCommande) {
        this.codeCommande = codeCommande;
    }
    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }


}
