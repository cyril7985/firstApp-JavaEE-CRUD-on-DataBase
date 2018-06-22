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
@WebServlet(name = "Delete", urlPatterns = {"/Delete"})
public class Delete extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        String lsMessage ="";
        String id = request.getParameter("id");
        String nomPays = request.getParameter("nomPays");

        try {
            
            Class.forName("org.gjt.mm.mysql.Driver"); // --- Pilote natif MySQL
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
           
            String lSql = "DELETE FROM pays WHERE id_pays ="+ id ;

            PreparedStatement lpst = lcn.prepareStatement(lSql);
            int liAffect = lpst.executeUpdate();

            //lpst.setString(1, id);
                        
           if(id == null){
               
               lsMessage = "";
               
           }else{
               
               lsMessage ="Suppression réussie";
           }
             
            lpst.close();
            lcn.close();

        } catch (ClassNotFoundException | SQLException e) {

           lsMessage = e.getMessage();
        }
        
        request.setAttribute("message", lsMessage);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/delete.jsp");
        rd.forward(request, response);

    }
}
