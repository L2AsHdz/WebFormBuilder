package web;

import datos.CRUD;
import datos.form.FormularioDAO;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Formulario;
import model.Usuario;

/**
 *
 * @date 28/03/2021
 * @time 12:49:41
 * @author asael
 */
@WebServlet("/inicio")
public class InicioServlet extends HttpServlet {
    
    private CRUD<Formulario> formDAO = new FormularioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Formulario> forms = formDAO.getList();
        List<Formulario> formsUser = new ArrayList();
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        forms.forEach(f -> {
            if (f.getUsuarioCreacion().equals(user.getNombre())) {
                formsUser.add(f);
            }
        });
        request.setAttribute("formularios", formsUser);
        request.getRequestDispatcher("inicioUsuario.jsp").forward(request, response);
    }

    
}
