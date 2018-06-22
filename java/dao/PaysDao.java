/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Pays;
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
public class PaysDao {

    /**
     *
     * @param pcnx
     * @return
     * @throws ClassNotFoundException
     */
    public static List<Pays> selectAll(Connection pcnx) throws ClassNotFoundException {
        //Futur resultat de la fonction dao sous forme d 'array list
        List<Pays> listePays = new ArrayList();

        /*
        Connexion et lecture de la bd
         */
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            pcnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            String lSql = "SELECT * FROM pays ";
            PreparedStatement pst = pcnx.prepareStatement(lSql);
            ResultSet rst = pst.executeQuery();

            while (rst.next()) {
                Pays pays = new Pays(rst.getString(1), rst.getString(2));
                //On remplit l'array list
                listePays.add(pays);
            }
            rst.close();
//            lcn.close();

        } catch (SQLException e) {
            Pays pays = new Pays("-1",e.getMessage());
            listePays.add(pays);
        }

        //VALEUR RETOUR
        return listePays;

    }//List<Pays>

    /**
     * 
     * @param pcnx
     * @param idPays
     * @return 
     */
    public static Pays selectOne(Connection pcnx, String idPays) {
        //Futur resultat de la fonction dao sous forme d'objet
        Pays pays = null;

        /*
        Connexion et lecture de la bd
         */
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            pcnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            String lSql = "SELECT * FROM pays WHERE id_pays = ?";
            PreparedStatement pst = pcnx.prepareStatement(lSql);
            pst.setString(1, idPays);
            ResultSet rst = pst.executeQuery();

            if (rst.next()) {
                pays = new Pays(rst.getString(1), rst.getString(2));
            }else{
                pays = new Pays("0", "Introuvable");
            }
            rst.close();
//            lcn.close();

        } catch (ClassNotFoundException | SQLException e) {
            pays = new Pays("-1", e.getMessage());
        }

        //VALEUR RETOUR
        return pays;

    }// Pays

}//main
