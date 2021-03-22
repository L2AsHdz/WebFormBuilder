package aux.form;

import datos.CRUD;
import datos.form.FormularioDAO;
import model.Formulario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 21/03/2021
 * @time 11:41:28
 * @author asael
 */
public class FormRequestExecutor {

    private final CRUD<Formulario> formDAO;

    public FormRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    public void executeCreateForm(Solicitud s, String loggedUser) {
        var formBuilder = new FormBuilder(s, loggedUser);
        var form = formBuilder.build();

        if (!formDAO.exists(form.getId())) {
            formDAO.create(form);
            //Generar respuesta
            System.out.println("Formulario " + form.getId() + " creado");
        } else {
            System.out.println("Error, formulario ya existe");
        }
    }

    public void executeDeleteForm(Solicitud s) {
        String idForm = s.getParametros().get(0).getValue()
                .replace("\"", "")
                .replaceAll("\\s", "");

        if (formDAO.delete(idForm)) {
            System.out.println("Formulario " + idForm + " eliminado");
        } else {
            System.out.println("Formulario no existe");
        }
    }
}
