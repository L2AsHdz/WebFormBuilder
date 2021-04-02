package web.form;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @date 1/04/2021
 * @time 15:05:53
 * @author asael
 */
@WebServlet("/import")
public class ImportFormServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
        response.setContentType("text/plain");
        BufferedReader reader = request.getReader();
        String loggedUser = request.getHeader("loggedUser");
        String idForm = request.getHeader("idForm");
        
        try (PrintWriter out = response.getWriter()) {
            out.println("Se importo correctamente");
        } catch (Exception e) {
        }
    }
}
