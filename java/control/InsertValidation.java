/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
@WebServlet(name = "InsertValidation", urlPatterns = {"/InsertValidation"})
public class InsertValidation extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String lsMessage = "";
        String id = request.getParameter("id");
        String nomPays = request.getParameter("nomPays");

        try {
            Class.forName("org.gjt.mm.mysql.Driver"); // --- Pilote natif MySQL
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            String lSql = "INSERT INTO pays (id_pays,nom_pays) VALUES(?,?)";

            PreparedStatement lpst = lcn.prepareStatement(lSql);
            lpst.setString(1, id);
            lpst.setString(2, nomPays);
            int liAffect = lpst.executeUpdate();

            lpst.close();
            lcn.close();
            
            lsMessage="Opération réussie";

            //out.print("OK");
        } catch (Exception e) {
            out.println(e.getMessage());
            lsMessage = e.getMessage();
            
        }
        
        request.setAttribute("message", lsMessage);
        
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/insert.jsp");
        rd.forward(request, response);

    }//doGet

}//mmain
