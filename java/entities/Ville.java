/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Administrateur
 */
public class Ville {
    
    private String cp;
    private String nomVille;
    private String site;
    private String photo;
    private String idPays;
    
    
/*
    Plein
    */
    public Ville(String cp, String nomVille, String site, String photo, String idPays) {
        this.cp = cp;
        this.nomVille = nomVille;
        this.site = site;
        this.photo = photo;
        this.idPays = idPays;
    }
    
    /*
    A moité
    */

    public Ville(String cp, String nomVille) {
        this.cp = cp;
        this.nomVille = nomVille;
    }
    
    /*
    Vide
    */

    public Ville() {
    }
    
    /*
    Getter et setter
    */

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public String getSite() {
        return site;
    }

    public void setSite(String site) {
        this.site = site;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getIdPays() {
        return idPays;
    }

    public void setIdPays(String idPays) {
        this.idPays = idPays;
    }
    
    
}
