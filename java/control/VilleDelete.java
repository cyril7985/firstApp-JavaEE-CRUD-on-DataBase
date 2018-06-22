/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.VilleDao;
import entities.Ville;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
@WebServlet(name = "VilleDelete", urlPatterns = {"/VilleDelete"})
public class VilleDelete extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String ville = request.getParameter("listeVille");
        String message = "";

        try {

            /*
            Connexion à la bd
             */
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
            /*
            Remplissage de la liste déroulante via le dao de la table ville
             */

            List<Ville> listeVille = VilleDao.selectAll();
            request.setAttribute("listeVille", listeVille);

            /*
              Delete dans la table "ville"
             */
           //if (!ville.equals("")) {//Si l'utilisateur a bien selectionné une ville

                String lSql = "DELETE  FROM villes WHERE (nom_ville = ?)";
                PreparedStatement pst = lcn.prepareStatement(lSql);
                pst.setString(1, ville);
                int liAffect = pst.executeUpdate();

                message = ville + " a bien été suprimé";

//           //}else{
//               message = "Veuillez selectionner une ville svp.";
//          }

        } catch (ClassNotFoundException | SQLException e) {
           //message = e.getMessage();
        }
        
        request.setAttribute("message", message);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/villeDelete.jsp");
        rd.forward(request, response);
    }//doGet

}//main
