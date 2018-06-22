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
public class Pays {
    
    private String idPays;
    private String nomPays;
    
    
    /*
    Plein
    */

    public Pays(String idPays, String nomPays) {
        this.idPays = idPays;
        this.nomPays = nomPays;
    }

    /*
    Vide
    */
    public Pays() {
    }
    
    /*
    Getter et setter
    */

    public String getIdPays() {
        return idPays;
    }

    public void setIdPays(String idPays) {
        this.idPays = idPays;
    }

    public String getNomPays() {
        return nomPays;
    }

    public void setNomPays(String nomPays) {
        this.nomPays = nomPays;
    }
    
    
    
    
}
