/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import dao.PaysDao;
import dao.VilleDao;
import entities.Pays;
import entities.Ville;
import java.awt.Button;
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
@WebServlet(name = "VilleCrud", urlPatterns = {"/VilleCrud"})
public class VilleCrud extends HttpServlet {

    private String Button;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        /*
        Declaration des variables
         */
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String message = "";
        PreparedStatement pst;
        ResultSet rst;
        Connection lcn = null;
        String lSql = "";
        int nbModif;
        String villeSelect = request.getParameter("nomVille");
        String cpSelect = request.getParameter("cpVille");
        String paysSelect = request.getParameter("pays");
        String idPays = request.getParameter("pays");
        String lsAjouter = request.getParameter("ajouter");
        String lsSupprimer = request.getParameter("supprimer");
        String lsModifier = request.getParameter("modifier");
        String acc = request.getParameter("acceuil");
        acc=null;
       
        try {

            //connexion a la table
            Class.forName("org.gjt.mm.mysql.Driver");
            lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            //Remplissage du tableau
            List<Ville> ville = VilleDao.selectAll();
            request.setAttribute("listeVille", ville);

            //Remplissage de la liste deroulante pays
            List<Pays> pays = PaysDao.selectAll(lcn);
            request.setAttribute("pays", pays);

            //Remplissage du champs cp 
            if (request.getParameter("cp") != null) {// si l'utilisateur a cliquer sur la loupe
                String cp = request.getParameter("cp");
                Ville v = VilleDao.selectOne(cp);
                request.setAttribute("cpVille", v.getCp());
                request.setAttribute("nomVille", v.getNomVille());

            }

            /*
            Les boutons
             */
            //ajouter
            if (lsAjouter != null) {
                if ((!cpSelect.equals("")) && (!villeSelect.equals(""))) {
                    lSql = "INSERT INTO villes (cp,nom_ville,id_pays) VALUES (?,?,?)";
                    pst = lcn.prepareStatement(lSql);
                    pst.setString(1, cpSelect);
                    pst.setString(2, villeSelect);
                    pst.setString(3, idPays);

                    nbModif = pst.executeUpdate();

                    message = villeSelect + " a bien été ajoutéé";

                }

            }//Ajouter

            //supprimer
            if (lsSupprimer != null) {
                if ((!cpSelect.equals("")) && (!villeSelect.equals(""))) {

                    lSql = "DELETE FROM villes WHERE cp=?";
                    pst = lcn.prepareStatement(lSql);
                    pst.setString(1, cpSelect);
                    nbModif = pst.executeUpdate();

                    message = villeSelect + " a bien été supprimée";

                }

            }//supprimer

            //Modifier
            if (lsModifier != null) {

                lSql = "UPDATE villes SET nom_ville = ? WHERE cp = ?";
                pst = lcn.prepareStatement(lSql);
                pst.setString(1, villeSelect);
                //pst.setString(2, idPays);
                pst.setString(2, cpSelect);

                nbModif = pst.executeUpdate();

                message = "Modification enregistrée";

            }//Modifier

        } catch (ClassNotFoundException | SQLException e) {
        }

        request.setAttribute("message", message);
        

        //redirection de la réponse
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/villeCrud.jsp");
        rd.forward(request, response);
    }//DOgET

}//MAIN
