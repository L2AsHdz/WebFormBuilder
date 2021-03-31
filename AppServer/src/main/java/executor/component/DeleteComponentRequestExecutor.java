package executor.component;

import aux.component.ComponentBuilder;
import datos.CRUD;
import datos.form.FormularioDAO;
import executor.Executor;
import model.Componente;
import model.Formulario;
import model.solicitudes.Solicitud;
import static model.response.TipoRespuesta.ELIMINAR_COMPONENTE;

/**
 *
 * @date 31/03/2021
 * @time 04:13:11
 * @author asael
 */
public class DeleteComponentRequestExecutor extends Executor{
    
    private final CRUD<Formulario> formDAO;
    private ComponentBuilder componentBuilder;

    public DeleteComponentRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();
        
        componentBuilder = new ComponentBuilder(s);
        var component = componentBuilder.buildDelete();

        if (formDAO.exists(component.getFormulario())) {
            var form = formDAO.getObject(component.getFormulario());
            int index = indexOfComponent(form, component.getId());
            
            if (index != -1) {
                form.getComponentes().remove(index);
                formDAO.create(form);
                addResponse(ELIMINAR_COMPONENTE, "Exito", "Se elimino el componente " + component.getId() + " del formulario " + form.getId());
            } else {
                addResponse(ELIMINAR_COMPONENTE, "Error", "No existe el componente " + component.getId() + " en el formulario " + form.getId());
            }
        } else {
            addResponse(ELIMINAR_COMPONENTE, "Error", "El formulario " + component.getFormulario() + " no existe");
        }

        return response.toString();
    }
    
    private int indexOfComponent(Formulario form, String idComponent) {
        Componente c;
        for (int i = 0; i < form.getComponentes().size(); i++) {
            c = form.getComponentes().get(i);
            if (c.getId().equals(idComponent)) {
                return i;
            }
        }
        return -1;
    }

}
