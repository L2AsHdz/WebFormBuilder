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

        var usuario = userBuilder.buildUser();

        if (!usuarioDAO.exists(usuario.getNombre())) {
            System.out.println("creando archivo: " + usuario.getNombre());
            System.out.println("fecha: "+usuario.getFechaCreacion());
        } else {
            System.out.println("Ya eciste perro");
        }
    }
}
