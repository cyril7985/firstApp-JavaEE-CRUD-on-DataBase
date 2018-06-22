/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Ville;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class VilleDao {

    public static List<Ville> selectAll() {

        //Futur resultat de la fonction dao sous forme d 'array list
        List<Ville> listVille = new ArrayList();

        /*
        Connexion et lecture de la bd
         */
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            String lSql = "SELECT * FROM villes ";
            PreparedStatement pst = lcn.prepareStatement(lSql);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {

                Ville ville = new Ville(rst.getString(1), rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
                listVille.add(ville);

            }
            rst.close();
            lcn.close();

        } catch (ClassNotFoundException | SQLException e) {
        }

        return listVille;
    }//selectAll

    public static Ville selectOne(String cp) {

        Ville ville = null;
        
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
            String sQl = "SELECT * FROM villes WHERE cp =?";
            
            PreparedStatement pst = lcn.prepareStatement(sQl);
            pst.setString(1, cp);
            ResultSet rst = pst.executeQuery();
            
            if (rst.next()){
                
                ville = new Ville (rst.getString(1), rst.getNString(2), rst.getNString(3), rst.getString(4), rst.getString(5));
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
            ville = new Ville("null", e.getMessage());
        }
        
        
        

        return ville;

    }
}//main
