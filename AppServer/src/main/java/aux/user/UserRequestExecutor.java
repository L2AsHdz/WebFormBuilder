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
    private UserBuilder userBuilder;

    public UserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
    }

    public void executeCreateUser(Solicitud s) {
        userBuilder = new UserBuilder(s);

        var usuario = userBuilder.build();

        if (!usuarioDAO.exists(usuario.getNombre())) {
            usuarioDAO.create(usuario);
            //Generar respuesta
            System.out.println("Usuario " + usuario.getNombre() + " creado");
        } else {
            System.out.println("Error, usuario ya existe en el sistema");
        }
    }

    public void executeDeleteUser(Solicitud s) {
        String nombre = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");

        if (usuarioDAO.delete(nombre)) {
            System.out.println("Usuario " + nombre + " eliminado");
        } else {
            System.out.println("Usuario no existe");
        }
    }

    public void executeModifyUser(Solicitud s) {
        userBuilder = new UserBuilder(s);

        var oldUser = userBuilder.buildOld();

        if (usuarioDAO.exists(oldUser.getNombre())) {
            var newUser = userBuilder.buildNew();
            
            if (usuarioDAO.delete(oldUser.getNombre())) {
                System.out.println("Usuario " + oldUser.getNombre() + " eliminado");
            }
            usuarioDAO.create(newUser);
            //generar respuesta
            System.out.println("Se modifico el usuario " + oldUser.getNombre());
        } else {
            System.out.println("Error, usuario no existe");
        }

    }
}
