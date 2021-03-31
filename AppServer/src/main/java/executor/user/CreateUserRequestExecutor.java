package executor.user;

import aux.user.UserBuilder;
import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import model.Usuario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 31/03/2021
 * @time 02:53:31
 * @author asael
 */
public class CreateUserRequestExecutor extends Executor {
    
    private final CRUD<Usuario> usuarioDAO;
    private UserBuilder userBuilder;

    public CreateUserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();
        
        userBuilder = new UserBuilder(s);

        var usuario = userBuilder.build();

        if (!usuarioDAO.exists(usuario.getNombre())) {
            usuarioDAO.create(usuario);
            //Generar respuesta
            response.append("Usuario ")
                    .append(usuario.getNombre())
                    .append(" creado");
        } else {
            response.append("Error, usuario ")
                    .append(usuario.getNombre())
                    .append(" ya existe en el sistema");
        }
        
        return response.toString();
    }

}
