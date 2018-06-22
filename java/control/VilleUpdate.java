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
@WebServlet(name = "VilleUpdate", urlPatterns = {"/VilleUpdate"})
public class VilleUpdate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String message = "";
        //grace à l'attribut action du bouton (caché), on sait quelle bouton a été cliqué
        String lsAction = request.getParameter("action");

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
            Remplissage des champs "site" et "photo" via un SELECT
             */

            if (lsAction != null) {// si l'utilisateur a  cliqué sur un bouton
                String lSql = "";
                PreparedStatement pst = null;

                /*
                Affichage des paramètres de la ville dans les textfield
                 */
                if (lsAction.equals("selectionner")) {//S il a cliqué sur le bouton "selectionner" (qui a l'attribut action = selectionner

                    String cp = request.getParameter("listeVilles");//grace à "<option value="${element.cp}">",la liste déroulante permet
                                                                    // de recupérer le cp de la ville sélectionnée    
                    lSql = "SELECT * FROM villes WHERE cp = ?";
                    pst = lcn.prepareStatement(lSql);
                    pst.setString(1, cp);
                    ResultSet rst = pst.executeQuery();
                    rst.next();
                
                    request.setAttribute("cp", cp);
                    request.setAttribute("nom_ville", rst.getString(2));
                    request.setAttribute("site", rst.getString(3));
                    request.setAttribute("photo", rst.getString(4));
                    request.setAttribute("id_pays", rst.getString(5));
//                    for (Ville villes : listeVille) {
//                        //request.setAttribute("cp", villes.getCp());
//                        request.setAttribute("nom_ville", villes.getNomVille());
//                        request.setAttribute("site", villes.getSite());
//                        request.setAttribute("photo", villes.getPhoto());
//                        request.setAttribute("id_pays", villes.getIdPays());
//
//                    }
                }
                /*
                Traitement des données remplies par l'utilisateur
                nouveau site et nouvelle photo
                 */
                //Pour le site
                if (lsAction.equals("validerModification")) {//Si l'utilisateur a cliqué sur "Valider les modif"
                    
                    
                    String nomVille = request.getParameter("nom_ville");
                    String site = request.getParameter("site");
                    String photo = request.getParameter("photo");       //on recupère la valeur des champs nom_pays...
                    String idPays = request.getParameter("id_pays");
                    String cp = request.getParameter("cp");
                    
                    if (nomVille != ("")&& idPays!=("")){
                         lSql = "UPDATE villes SET nom_ville = ?, site = ?, photo = ?, id_pays = ? WHERE cp =?";//WHERE + clef primaire (ici CP)
                    pst = lcn.prepareStatement(lSql);
                    pst.setString(1, nomVille);
                    pst.setString(2, site);
                    pst.setString(3, photo);
                    pst.setString(4, idPays);
                    pst.setString(5, cp);
                    int nbModif = pst.executeUpdate();
                    message = nbModif + " modification(s) enregistrée(s).";
                        
                    }else{
                        
                        message = "Les champs Nom de ville doit être saisie.";
                    }
                    
                   

//                    if (!nouveauSite.equals("")) {
//                        lSql = "UPDATE  villes SET site = ? WHERE cp =?";
//                        pst = lcn.prepareStatement(lSql);
//                        pst.setString(1, nouveauSite);
//                        pst.setString(2, cp);
//                        int nbModif = pst.executeUpdate();
//                        message = "Modification(s) enregistrée(s).";
//
//                    }
//
//                    //pour la photo
//                    if (!nouvellePhoto.equals("")) {
//                        lSql = "UPDATE villes set photo = ? WHERE nom_ville = ?";
//                        pst = lcn.prepareStatement(lSql);
//                        pst.setString(1, nouvellePhoto);
//                        pst.setString(2, ville);
//                        int nbModif = pst.executeUpdate();
//                        message = "Modification(s) enregistrée(s).";
//
//                    }
//                    //pour le cp
//                    if (!nouveauCp.equals("")) {
//                        lSql = "UPDATE villes set cp = ? WHERE nom_ville = ?";
//                        pst = lcn.prepareStatement(lSql);
//                        pst.setString(1, nouveauCp);
//                        pst.setString(2, ville);
//                        int nbModif = pst.executeUpdate();
//                        message = "Modification(s) enregistrée(s).";
//
//                    }
//                    //pour le nom
//                    if (!nouveauNom.equals("")) {
//                        lSql = "UPDATE villes set nom_ville = ? WHERE nom_ville = ?";
//                        pst = lcn.prepareStatement(lSql);
//                        pst.setString(1, nouveauNom);
//                        pst.setString(2, ville);
//                        int nbModif = pst.executeUpdate();
//                        message = "Modification(s) enregistrée(s).";
//
//                    }
//                    //pour l'id
//                    if (!nouvelId.equals("")) {
//                        lSql = "UPDATE villes set id_pays = ? WHERE nom_ville = ?";
//                        pst = lcn.prepareStatement(lSql);
//                        pst.setString(1, nouvelId);
//                        pst.setString(2, ville);
//                        int nbModif = pst.executeUpdate();
//                        message = "Modification(s) enregistrée(s).";
//
//                    }
                }// if (lsAction.equals("validerModifications"))

            }//lsAction != null

        } catch (ClassNotFoundException | SQLException e) {
            message = e.getMessage();
        }

        request.setAttribute("message", message);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/villeUpdate.jsp");
        rd.forward(request, response);

    }//doGet

}//main
