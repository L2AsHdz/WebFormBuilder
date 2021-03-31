package executor.user;

import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import generator.response.ResponseStructureGenerator;
import model.Usuario;
import model.response.Response;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.ELIMINAR_USUARIO;

/**
 *
 * @date 31/03/2021
 * @time 03:07:11
 * @author asael
 */
public class DeleteUserRequestExecutor extends Executor {

    private final CRUD<Usuario> usuarioDAO;

    public DeleteUserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();

        String nombre = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");

        if (usuarioDAO.delete(nombre)) {
            response.append(new ResponseStructureGenerator(
                    new Response(ELIMINAR_USUARIO, "success", "Usuario " + nombre + " se elimino correctamente")).generate());
        } else {
            response.append(new ResponseStructureGenerator(
                    new Response(ELIMINAR_USUARIO, "error", "Imposible eliminar, el usuario " + nombre + " no existe")).generate());
        }

        return response.toString();
    }

}
