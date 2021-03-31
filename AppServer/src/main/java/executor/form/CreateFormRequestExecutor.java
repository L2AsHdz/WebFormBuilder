package executor.form;

import aux.form.FormBuilder;
import datos.CRUD;
import datos.form.FormularioDAO;
import executor.Executor;
import model.Formulario;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.NUEVO_FORMULARIO;

/**
 *
 * @date 31/03/2021
 * @time 03:28:11
 * @author asael
 */
public class CreateFormRequestExecutor extends Executor {

    private final CRUD<Formulario> formDAO;
    private FormBuilder formBuilder;

    public CreateFormRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    public String execute(Solicitud s, String loggedUser) {
        response = new StringBuilder();

        formBuilder = new FormBuilder(s, loggedUser);
        var form = formBuilder.build();

        if (!formDAO.exists(form.getId())) {
            if (form.getUsuarioCreacion().equals(loggedUser)) {
                formDAO.create(form);
                addResponse(NUEVO_FORMULARIO, "success", "Formulario " + form.getId() + " creado exitosamente");
            } else {
                addResponse(NUEVO_FORMULARIO, "error", "El usuario ingresado no es el que esta logueado actualmente");
            }
        } else {
            addResponse(NUEVO_FORMULARIO, "error", "No se puede crear, el formulario " + form.getId() + " ya existe");
        }

        return response.toString();
    }

    @Override
    public String execute(Solicitud s) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
