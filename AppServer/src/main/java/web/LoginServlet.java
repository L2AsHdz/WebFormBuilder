package web;

import datos.CRUD;
import datos.usuario.UsuarioDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;

/**
 *
 * @date 27/03/2021
 * @time 18:31:12
 * @author asael
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    CRUD<Usuario> userDAO = new UsuarioDAO();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String user = request.getParameter("usuario");
        String pass = request.getParameter("password");

        if (userDAO.exists(user)) {
            Usuario usuario = userDAO.getObject(user);

            if (usuario.getPassword().equals(pass)) {
                HttpSession sesion = request.getSession();
                sesion.setMaxInactiveInterval(3600);
                sesion.setAttribute("user", user);

                response.sendRedirect("inicioUsuario.jsp");

            } else {
                request.setAttribute("errorLogin", "Las credenciales ingresadas no son validas");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        } else {
            request.setAttribute("errorLogin", "Las credenciales ingresadas no son validas");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }

    }

}
