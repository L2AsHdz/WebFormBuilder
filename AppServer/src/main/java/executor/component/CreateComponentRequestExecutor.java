package executor.component;

import aux.component.ComponentBuilder;
import datos.CRUD;
import datos.form.FormularioDAO;
import executor.Executor;
import model.Componente;
import model.Formulario;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.AGREGAR_COMPONENTE;

/**
 *
 * @date 31/03/2021
 * @time 04:04:35
 * @author asael
 */
public class CreateComponentRequestExecutor extends Executor {
    
    private final CRUD<Formulario> formDAO;
    private ComponentBuilder componentBuilder;

    public CreateComponentRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();
        
        componentBuilder = new ComponentBuilder(s);
        var component = componentBuilder.build();

        if (formDAO.exists(component.getFormulario())) {
            boolean exists = false;
            var form = formDAO.getObject(component.getFormulario());

            for (Componente c : form.getComponentes()) {
                if (c.getId().equals(component.getId())) {
                    exists = true;
                }
            }

            if (!exists) {
                form.getComponentes().add(component);
                formDAO.create(form);
                addResponse(AGREGAR_COMPONENTE, "Exito", "Componente " + component.getId() + " agregado al formulario " + form.getId());
            } else {
                addResponse(AGREGAR_COMPONENTE, "Error", "Ya existe el componente " + component.getId() + " en el formulario " + form.getId());
            }
        } else {
            addResponse(AGREGAR_COMPONENTE, "Error", "No existe el formulario " + component.getFormulario());
        }
        
        return response.toString();
    }

}
