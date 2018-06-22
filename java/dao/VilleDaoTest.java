/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Pays;
import entities.Ville;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class VilleDaoTest {

    public static void main(String[] args) {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection pcnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
//            String lSql = "SELECT * FROM villes ";
//            PreparedStatement pst = pcnx.prepareStatement(lSql);
//            ResultSet rst = pst.executeQuery();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        List<Ville> listVille = VilleDao.selectAll();

        for (Ville villes : listVille) {
            //System.out.println(villes.getNomVille());
        }
        
        Ville v = new VilleDao().selectOne("24200");
        System.out.println(v.getNomVille());

    }

}
