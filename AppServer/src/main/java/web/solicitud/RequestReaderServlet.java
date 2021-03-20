package web.solicitud;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.errores.ErrorAnalisis;
import model.solicitudes.Solicitud;

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

        response.setContentType("text/plain");
        BufferedReader reader = request.getReader();
        String loggedUser = request.getHeader("loggedUser");

        RequestAnalyzer analyzer = new RequestAnalyzer();
        analyzer.analyze(reader);

        List<ErrorAnalisis> errores = analyzer.getErrores();
        List<Solicitud> solicitudes = analyzer.getSolicitudes();

        if (!loggedUser.trim().isEmpty()) {
            try (PrintWriter out = response.getWriter()) {
                out.println("Usuario logeado: " + loggedUser);
            } catch (Exception e) {
            }
        } else {
            //Ignorar solicitudes e informar que no esta logeado
        }

    }

}
