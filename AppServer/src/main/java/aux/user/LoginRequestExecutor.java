package aux.user;

import datos.CRUD;
import datos.usuario.UsuarioDAO;
import model.Usuario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 31/03/2021
 * @time 00:46:29
 * @author asael
 */
public class LoginRequestExecutor {

    private final CRUD<Usuario> userDAO;
    private UserBuilder userBuilder;

    public LoginRequestExecutor() {
        userDAO = new UsuarioDAO();
    }
    
    public void executeLogin(Solicitud s) {
        userBuilder = new UserBuilder(s);
        
        var user = userBuilder.build();
        
        if (userDAO.exists(user.getNombre())) {
            //generar respuesta para la app cliente
            System.out.println("Login completo para " + user.getNombre());
        } else {
            System.out.println("El usuario no existe, imposible logearse");
        }
    }
}
