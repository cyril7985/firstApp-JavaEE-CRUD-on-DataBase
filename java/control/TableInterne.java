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
@WebServlet(name = "TableInterne", urlPatterns = {"/TableInterne"})
public class TableInterne extends HttpServlet {

   
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
            String lsSql = "SELECT cp,nom_ville,id_pays FROM villes";
            
            PreparedStatement pst = lcn.prepareStatement(lsSql);
            ResultSet rst = pst.executeQuery();
            
            while (rst.next()){
                
                resultat.append(rst.getString (1));
                resultat.append ("-");
                resultat.append(rst.getString(2));  
                 resultat.append ("-");
                resultat.append(rst.getString(3));
                resultat.append ("<br>");

                //out.print(rst.getString(1)+"-");//+rst.getString(2)+"-"+rst.getString(5)+("<br>"));
                
                request.setAttribute("resultat", resultat);
                lsMessage = "Affichage réussi";
            }
            
            
        } catch (ClassNotFoundException | SQLException e) {
        }//try catch
        
         request.setAttribute("message", lsMessage);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/tableInterne.jsp");
        rd.forward(request, response);
        
        
        
    }//doGet

    
    
   

}//main
