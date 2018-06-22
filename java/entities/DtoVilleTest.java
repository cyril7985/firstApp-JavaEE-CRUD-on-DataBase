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
public class DtoVilleTest {
    
    public static void main(String[] args) {
        Ville v = new Ville ("70000","Nom","site.fr","photo","033");
        System.out.println(v.getNomVille());
        System.out.println(v.getCp());
        
    }
    
            
    
}
