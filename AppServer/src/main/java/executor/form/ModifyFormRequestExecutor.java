package executor.form;

import aux.form.FormBuilder;
import datos.CRUD;
import datos.form.FormularioDAO;
import executor.Executor;
import model.Formulario;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.MODIFICAR_FORMUALARIO;


/**
 *
 * @date 31/03/2021
 * @time 03:33:03
 * @author asael
 */
public class ModifyFormRequestExecutor extends Executor {
    
    private final CRUD<Formulario> formDAO;
    private FormBuilder formBuilder;

    public ModifyFormRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();
        
        formBuilder = new FormBuilder(s);

        var modifyForm = formBuilder.buildModify();

        if (formDAO.exists(modifyForm.getId())) {
            var currentForm = formDAO.getObject(modifyForm.getId());

            if (modifyForm.getTitulo() != null) currentForm.setTitulo(modifyForm.getTitulo());
            if (modifyForm.getNombre() != null) currentForm.setNombre(modifyForm.getNombre());
            if (modifyForm.getTema() != null) currentForm.setTema(modifyForm.getTema());
            
            formDAO.create(currentForm);
            addResponse(MODIFICAR_FORMUALARIO, "success", "El formulario " + currentForm.getId() + " fue modificado");
            //generar respuesta
        } else {
            addResponse(MODIFICAR_FORMUALARIO, "error", "No se puede modificar el formulario " + modifyForm.getId() + " porque no existe");
        }
        
        return response.toString();
    }

}
