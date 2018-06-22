/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Pays;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Administrateur
 */
public class PaysDaoTest {

    private static Connection pcnx;

    public static void main(String[] args) throws ClassNotFoundException {

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection pcnx = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
//            String lSql = "SELECT * FROM pays ";
//            PreparedStatement pst = pcnx.prepareStatement(lSql);
//            ResultSet rst = pst.executeQuery();

        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }

        List<Pays> listePays = PaysDao.selectAll(pcnx);
        for (Pays pays : listePays) {
            System.out.println(pays.getNomPays());
        }
        
        Pays p = PaysDao.selectOne(pcnx, "033");
        System.out.println(p.getNomPays());
    }

}
