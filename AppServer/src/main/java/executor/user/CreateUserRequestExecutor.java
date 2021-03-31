package executor.user;

import aux.user.UserBuilder;
import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import generator.response.ResponseStructureGenerator;
import model.Usuario;
import model.response.Response;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.CREAR_USUARIO;

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
            response.append(new ResponseStructureGenerator(
                    new Response(CREAR_USUARIO, "succes", "Usuario " + usuario.getNombre() + " creado")).generate());
        } else {
            response.append(new ResponseStructureGenerator(new Response(CREAR_USUARIO, "Error", "El usuario " + usuario.getNombre() + " ya existe en el sistema")).generate());
        }
        
        return response.toString();
    }

}
