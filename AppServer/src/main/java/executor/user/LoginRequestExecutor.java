package executor.user;

import aux.user.UserBuilder;
import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import model.Usuario;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.LOGIN_USUARIO;

/**
 *
 * @date 31/03/2021
 * @time 00:46:29
 * @author asael
 */
public class LoginRequestExecutor extends Executor {

    private final CRUD<Usuario> userDAO;
    private UserBuilder userBuilder;

    public LoginRequestExecutor() {
        userDAO = new UsuarioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();
        
        userBuilder = new UserBuilder(s);
        
        var user = userBuilder.build();
        
        if (userDAO.exists(user.getNombre())) {
            addResponse(LOGIN_USUARIO, "Exito", "Login completo para " + user.getNombre());
        } else {
            addResponse(LOGIN_USUARIO, "Error", "El usuario no existe, imposible logearse");
        }
        
        return response.toString();
    }
}
