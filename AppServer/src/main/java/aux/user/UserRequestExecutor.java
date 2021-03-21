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
            usuarioDAO.create(usuario);
        } else {
            System.out.println("Error, usuario ya existe en el sistema");
        }
    }
    
    public void executeDeleteUser(Solicitud s) {
        String nombre = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");
        
        if (usuarioDAO.delete(nombre)) {
            System.out.println("Usuario Eliminado");
        } else {
            System.out.println("Usuario no existe");
        }
    }
}
