package web.form;

import datos.CRUD;
import datos.form.FormularioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Formulario;

/**
 *
 * @date 28/03/2021
 * @time 16:14:20
 * @author asael
 */
@WebServlet("/builder")
public class FormBuilderServlet extends HttpServlet {

    private CRUD<Formulario> formDAO = new FormularioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idForm = request.getParameter("id");
        Formulario form = formDAO.getObject(idForm);

        form.getComponentes().forEach(c -> {
            switch (c.getClase()) {
                case "CHECKBOX", "RADIO", "COMBO" -> {
                    if (c.getOpciones().contains("|")) {
                        c.setOptions(Arrays.asList(c.getOpciones().split("\\|")));
                    } else {
                        List<String> options = new ArrayList();
                        options.add(c.getOpciones());
                        c.setOptions(options);
                    }
                }
            }
        });

        request.setAttribute("form", form);
        request.getRequestDispatcher("formulario.jsp").forward(request, response);
    }

}
