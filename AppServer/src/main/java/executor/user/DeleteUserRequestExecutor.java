package executor.user;

import datos.CRUD;
import datos.form.FormularioDAO;
import datos.usuario.UsuarioDAO;
import executor.Executor;
import java.util.List;
import model.Formulario;
import model.Usuario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 31/03/2021
 * @time 03:07:11
 * @author asael
 */
public class DeleteUserRequestExecutor extends Executor {

    private final CRUD<Usuario> usuarioDAO;
    private final CRUD<Formulario> formDAO;

    public DeleteUserRequestExecutor() {
        usuarioDAO = new UsuarioDAO();
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();

        String nombre = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");

        if (usuarioDAO.delete(nombre)) {
            List<Formulario> forms = formDAO.getList();
            forms.forEach(f -> {
                if (f.getUsuarioCreacion().equals(nombre)) {
                    formDAO.delete(f.getId());
                }
            });
            addResponse("Usuario " + nombre + " se elimino correctamente");
        } else {
            addResponse("Imposible eliminar, el usuario " + nombre + " no existe");
        }

        return response.toString();
    }

}
