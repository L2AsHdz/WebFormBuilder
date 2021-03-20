package web.solicitud;

import analizadores.lexico.Lexer;
import analizadores.sintactico.Parser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

        BufferedReader reader = request.getReader();
        String user = request.getHeader("user");

        RequestAnalyzer analyzer = new RequestAnalyzer();
        analyzer.analyze(reader);

        List<ErrorAnalisis> errores = analyzer.getErrores();
        List<Solicitud> solicitudes = analyzer.getSolicitudes();

        response.setContentType("text/plain");
        try (PrintWriter out = response.getWriter()) {

            if (errores.isEmpty()) {
                solicitudes.forEach(s -> {
                    out.println("\nSolicitud tipo: " + s.getTipo());
                    s.getParametros().forEach(param -> out.println("\t" + param.getName() + " : " + param.getValue()));
                });
            } else {
                errores.forEach(e -> out.println(e.getLexema() + "- " + e.getDescripcion() + " Linea: " + e.getLinea() + " Columna: " + e.getColumna()));
            }
            out.println(user);
        }

    }

}
