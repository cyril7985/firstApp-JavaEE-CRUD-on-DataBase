/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
@WebServlet(name = "Select", urlPatterns = {"/Select"})
public class Select extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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

        StringBuilder resultat = new StringBuilder();
        String lsMessage = "";

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
            String lSql = "SELECT * FROM pays ";
            PreparedStatement pst = lcn.prepareStatement(lSql);
            ResultSet lrs = pst.executeQuery();

        while (lrs.next()) {

               resultat.append(lrs.getString(1));
                resultat.append("-");
               resultat.append(lrs.getString(2));  
               resultat.append("<br>");
                //out.print(lrs.getString(1) + "-" + lrs.getString(2));
                
                lsMessage = "Opération réussie";
                
                request.setAttribute("table",resultat);
                
                        

            }
            lrs.close();
            pst.close();
            lcn.close();

        } catch (ClassNotFoundException | SQLException e) {
            lsMessage = e.getMessage();
        }//try-catch

        request.setAttribute("message", lsMessage);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/select.jsp");
        rd.forward(request, response);

    }//doGet

}//main
