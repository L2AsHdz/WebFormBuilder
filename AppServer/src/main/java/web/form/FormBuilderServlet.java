package web.form;

import aux.html.HtmlPageGenerator;
import datos.CRUD;
import datos.form.FormularioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Formulario;

import static aux.FileController.saveFile;
import static aux.FileController.createDirectory;

/**
 *
 * @date 28/03/2021
 * @time 16:14:20
 * @author asael
 */
@WebServlet("/builder")
public class FormBuilderServlet extends HttpServlet {

    private final String PATH_FORMS = "/home/asael/NetBeansProjects/WebFormBuilder/AppServer/src/main/webapp/formsHtml/";
    private CRUD<Formulario> formDAO = new FormularioDAO();
    private HtmlPageGenerator htmlPG;

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
        htmlPG = new HtmlPageGenerator(form);

        createDirectory(PATH_FORMS + form.getUsuarioCreacion());
        saveFile(PATH_FORMS + form.getUsuarioCreacion() + "/" + form.getId() + ".html", htmlPG.generate());
        System.out.println("Html creado");
    }

}
