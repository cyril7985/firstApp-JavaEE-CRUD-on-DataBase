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
@WebServlet(name = "Update", urlPatterns = {"/Update"})
public class Update extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String lsMessage = "";
        String id = request.getParameter("id");
        String nomPays = request.getParameter("nomPays");

        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            Connection lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");

            String lSql = "UPDATE  pays SET nom_pays =" +"'" +nomPays+"'" +"WHERE id_pays =" + "'"+id+"'";
             //String lSql = "UPDATE  pays set nom_pays ='mamappppp'  WHERE id_pays =111 ";
           // String lSql = "UPDATE  pays SET nom_pays = ?  WHERE id_pays = ?" ;

            PreparedStatement lpst = lcn.prepareStatement(lSql);
            int liAffect = lpst.executeUpdate();
            
//            lpst.setString(1, id);
//            lpst.setString(2, nomPays);
            lpst.close();
            lcn.close();
            
            if(id == null && nomPays == null){
               
               lsMessage = "";
               
           }else{
               
               lsMessage ="Modification réussie";
           }
            
            

        } catch (ClassNotFoundException | SQLException e) {

           lsMessage = e.getMessage();
        }//TRY CATCH
        
        request.setAttribute("message", lsMessage);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/update.jsp");
        rd.forward(request, response);
        

    }//DOGET

}//MAIN
