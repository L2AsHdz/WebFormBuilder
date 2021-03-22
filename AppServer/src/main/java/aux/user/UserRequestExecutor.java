package aux.user;

import datos.CRUD;
import datos.usuario.UsuarioDAO;
import model.Usuario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 20/03/2021
 * @time 19:58:13
 * @author asael
 */
public class UserRequestExecutor {

    private final CRUD<Usuario> usuarioDAO;

    public UserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
    }

    public void executeCreateUser(Solicitud s) {
        var userBuilder = new UserBuilder(s);

        var usuario = userBuilder.build();

        if (!usuarioDAO.exists(usuario.getNombre())) {
            usuarioDAO.create(usuario);
            //Generar respuesta
            System.out.println("Usuario " + usuario.getNombre() + " creado");
        } else {
            System.out.println("Error, usuario ya existe en el sistema");
        }
    }
}
