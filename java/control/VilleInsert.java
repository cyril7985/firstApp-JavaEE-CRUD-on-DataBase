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
@WebServlet(name = "VilleInsert", urlPatterns = {"/VilleInsert"})
public class VilleInsert extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        /*
        Remplissage de la bd par l'utilisateur
         */
        String lsMessage = "";

        String cp = request.getParameter("cp");
        String ville = request.getParameter("ville");
        String idPays = request.getParameter("pays");
//
        try {
            /*
            CONNEXION
             */
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
            /*
            Pour l'affichage de la liste déroulante
             */
            List<Pays> listePays = PaysDao.selectAll(lcn);
            request.setAttribute("listePays", listePays);

            /*
            SI INSERT 
             */
            if (!cp.equals("")) { //Si l'utilisateur a bien saisie un CP
                if (idPays != null) //Si l'utilisateur a bien sélectionner un pays
                {
                    String lSql = "INSERT INTO villes (cp,nom_ville,id_pays) VALUES (?,?,?)";

                    PreparedStatement pst = lcn.prepareStatement(lSql);

                    pst.setString(1, cp);
                    pst.setString(2, ville);
                    pst.setString(3, idPays);

                    int liAffect = pst.executeUpdate();
                    pst.close();
                    lsMessage = ville + " a bien été rajoutée.";

                } else {
                    lsMessage = "Veuillez sélectionner un pays !!!";
                }
            }else{
                lsMessage = "Veuillez saisir un cp svp.";
            }


            /*
DECONNEXION
             */
            lcn.close();

        } catch (ClassNotFoundException | SQLException e) {

            lsMessage = e.getMessage();
        }

        request.setAttribute("message", lsMessage);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/villeInserte.jsp");
        rd.forward(request, response);
    }//doGet

}//main
