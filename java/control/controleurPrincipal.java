/*
 * ControleurPrincipal.java
 */
package control;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pascal
 */
@WebServlet(name = "controleurPrincipal", urlPatterns = {"/controleurPrincipal"})
public class controleurPrincipal extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        
        
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String lsMessage ="Bienvenue sur le site !";
        request.setAttribute("message", lsMessage);
         getServletContext().getRequestDispatcher("/jsp/authentification.jsp").forward(request, response);
    } /// doGet

} /// class
