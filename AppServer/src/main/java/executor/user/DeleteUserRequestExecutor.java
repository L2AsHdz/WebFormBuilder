package executor.user;

import datos.CRUD;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import model.Usuario;
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
            addResponse(ELIMINAR_USUARIO, "Exito", "Usuario " + nombre + " se elimino correctamente");
        } else {
            addResponse(ELIMINAR_USUARIO, "Error", "Imposible eliminar, el usuario " + nombre + " no existe");
        }

        return response.toString();
    }

}
