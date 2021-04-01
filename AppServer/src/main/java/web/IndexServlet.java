package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Usuario;
import static aux.FileController.verifyFile;
import static aux.FileController.saveFile;
import static aux.FileController.createDirectory;

/**
 *
 * @date 27/03/2021
 * @time 16:05:47
 * @author asael
 */
@WebServlet("/index")
public class IndexServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession sesion = request.getSession();
        Usuario user = (Usuario) sesion.getAttribute("user");
        crearUsuarioInicio();
        if (user != null) {
            response.sendRedirect("inicioUsuario.jsp");
        } else {
            response.sendRedirect("login.jsp");
        }
    }

    private void crearUsuarioInicio() throws IOException {
        String NAME_USER_LINUX = System.getProperty("user.name");
        String ruta = "/home/" + NAME_USER_LINUX + "/WebFormBuilder/data/users/";
        String archivoDestino = ruta + "admin.db";
        String texto = """
                       db.user(
                           {
                               "USUARIO" : "admin",
                               "PASSWORD" : "admin",
                               "FECHA_CREACION" : "2023-05-06"
                           }
                       )""";

        if (!verifyFile(archivoDestino)) {
            createDirectory(ruta);
            saveFile(archivoDestino, texto);
        } else {
            System.out.println("archivo");
        }
    }
}
