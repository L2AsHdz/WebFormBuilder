package web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @date 18/03/2021
 * @time 18:12:25
 * @author asael
 */
@WebServlet("/requestReader")
public class RequestReaderServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws IOException {
        BufferedReader reader = request.getReader();
        String s;
        while ((s = reader.readLine()) != null) {
            System.out.println(s);
        }
        
        response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {
            out.print("A dormir perro!!!");
            out.print("Holi");
        }
        
        response.sendRedirect("login.jsp");
    }
    
    
}
