package web.form;

import datos.CRUD;
import datos.form.FormularioDAO;
import java.io.IOException;
import java.nio.file.Paths;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import model.Componente;
import model.Formulario;

/**
 *
 * @date 2/04/2021
 * @time 02:34:25
 * @author asael
 */
@WebServlet("/readData")
@MultipartConfig
public class ReadDataServlet extends HttpServlet {

    private final CRUD<Formulario> formDAO = new FormularioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*String idForm = request.getParameter("idForm");
        var form = formDAO.getObject(idForm);

        Part part;
        String value = null;
        String[] values = null;
        for (Componente c : form.getComponentes()) {
            switch (c.getClase()) {
                case "CHECKBOX" -> values = request.getParameterValues(c.getNombreCampo());
                case "FICHERO" -> {
                    try {
                        part = request.getPart(c.getNombreCampo());
                        value = Paths.get(part.getSubmittedFileName()).getFileName().toString();
                    } catch (IOException | ServletException e) {
                    }
                }
                default ->
                    value = request.getParameter(c.getNombreCampo());
            }
            if (values != null) {
                for (String v : values) {
                    System.out.print(v + "|");
                }
            }

            if (value != null) {
                System.out.println(value);
            }
        }*/

        response.sendRedirect("success.jsp");
    }

}
