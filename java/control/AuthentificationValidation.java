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
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author cyril
 */
@WebServlet(name = "AuthentificationValidation", urlPatterns = {"/AuthentificationValidation"})
public class AuthentificationValidation extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
//        Connection lcn = (Connection) session.getAttribute("cnx");

        String message = "";
        Connection lcn;
        PreparedStatement pst;
        ResultSet rst;
        String lSql = "";

        try {
            //connexion a la table
            Class.forName("org.gjt.mm.mysql.Driver");
            lcn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/cours", "root", "");
            session.setAttribute("cnx", lcn);
            // message = "Connexion ok";
            lSql = "SELECT * FROM utilisateurs WHERE pseudo=? AND mdp=?";
            pst = lcn.prepareStatement(lSql);
            pst.setString(1, request.getParameter("pseudo"));
            pst.setString(2, request.getParameter("mdp"));

            rst = pst.executeQuery();

            if (rst.next()) {
                message = "Vous êtes connecté(e)" + request.getParameter("pseudo");
                session.setAttribute("cnx", 1);
                
            } else {
                message = "Authentification ratée " + request.getParameter("pseudo");
                 session.setAttribute("cnx", null);
               lcn.close();

                //Jedis jedis = (Jedis) session.getAttribute("cnx");
//                lcn.setAutoCommit(false);
//                lcn.rollback();
//                session.setAttribute("connecte", "0");
//                session.setAttribute("pseudo", "");
            }

//            rst.close();
//            pst.close();
        } catch (Exception e) {
            message = e.getMessage();
            session.setAttribute("connecte", "0");
        }

        request.setAttribute("message", message);
        ServletContext sc = getServletContext();
        RequestDispatcher rd = sc.getRequestDispatcher("/jsp/authentification.jsp");
        rd.forward(request, response);
    }

}
