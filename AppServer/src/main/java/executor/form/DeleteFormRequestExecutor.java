package executor.form;

import datos.CRUD;
import datos.form.FormularioDAO;
import executor.Executor;
import model.Formulario;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.ELIMINAR_FORMULARIO;

/**
 *
 * @date 31/03/2021
 * @time 03:36:49
 * @author asael
 */
public class DeleteFormRequestExecutor extends Executor {

    private final CRUD<Formulario> formDAO;

    public DeleteFormRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();

        String idForm = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");

        if (formDAO.delete(idForm)) {
            addResponse(ELIMINAR_FORMULARIO, "Exito", "Formulario " + idForm + " eliminado");
        } else {
            addResponse(ELIMINAR_FORMULARIO, "Error", "No se puede eliminar, el formulario " + idForm + " no existe");
        }

        return response.toString();
    }

}
