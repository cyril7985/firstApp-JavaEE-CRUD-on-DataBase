/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PaysDao;
import entities.Pays;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Administrateur
 */
@WebServlet(name = "Crud", urlPatterns = {"/Crud"})
public class Crud extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String message = "";
        String lSql = "";
        PreparedStatement pst;
        ResultSet rst;
        Connection lcn = null;
        String lsAjouter = request.getParameter("ajouter");
        String lsSupprimer = request.getParameter("supprimer");
        String lsModifier = request.getParameter("modifier");
        int nbModif;
        String idSelect = request.getParameter("idPays");
        String paysSelect = request.getParameter("nomPays");

        //Connexion à la table pays
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            //Remplissage du tableau via le PaysDao
            List<Pays> listePays = PaysDao.selectAll(lcn);
            request.setAttribute("listePays", listePays);
            /*
            Remplissage des champs id pays et nom du pays.
            Pour cela, on utilise la methode selectOne() de paysDao
             */

            if (request.getParameter("id") != null) {// <a href="/RevisionWeb/Crud?id=${element.idPays}">                                                    
                String lsID = request.getParameter("id"); //  Grace au lien placer avec la "loupe", on recupère l'id du pays sélectionné 
                Pays p = PaysDao.selectOne(lcn, lsID);// appel de la methode selectOne du dao
                request.setAttribute("idPays", p.getIdPays());
                request.setAttribute("nomPays", p.getNomPays());// remplissage des champs 

            }

            /*
                Gestion des boutons supprimer et delete
             */
            //Bouton supprimer
            if (lsSupprimer != null) {
                lSql = "DELETE FROM pays WHERE id_pays =?";
                pst = lcn.prepareStatement(lSql);
                pst.setString(1, idSelect);
                nbModif = pst.executeUpdate();

                message = "Nombre de modif = " + nbModif + ". " + paysSelect + " a bien été supprimé.";

            }

            //Bouton ajouter
            if (lsAjouter != null) {
                lSql = "INSERT INTO pays (id_pays,nom_pays) VALUES (?,?)";
                pst = lcn.prepareStatement(lSql);
                pst.setString(1, idSelect);
                pst.setString(2, paysSelect);
                nbModif = pst.executeUpdate();

                message = nbModif + " a été enregistrée. " + paysSelect + " a bien été rajouté à la BD";

            }

            //Bouton modifier
            if (lsModifier != null) {
                lSql = "UPDATE pays SET nom_pays =? WHERE id_pays = ? ";
                pst = lcn.prepareStatement(lSql);
                pst.setString(1, paysSelect);
                pst.setString(2, idSelect);
                nbModif = pst.executeUpdate();
                
                message = nbModif + " modification effectuée. "+ paysSelect+" a bien été enregistré.";

            }

        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/crud.jsp");
        rd.forward(request, response);

    }//doGet

}//main
