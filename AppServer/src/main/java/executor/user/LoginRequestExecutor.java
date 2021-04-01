package executor.user;

import aux.user.UserBuilder;
import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import generator.response.ResponseStructureGenerator;
import model.Usuario;
import model.response.Response;
import model.solicitudes.Solicitud;

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
            var userSys = userDAO.getObject(user.getNombre());
            
            if (userSys.getPassword().equals(user.getPassword())) {
                response.append(new ResponseStructureGenerator(new Response("El usuario logueado ahora es " + user.getNombre(), user.getNombre())).generate());
            } else {
                addResponse("Las contraseñas no coinciden");
            }
        } else {
            addResponse("El usuario no existe, imposible logearse");
        }
        
        return response.toString();
    }
}
