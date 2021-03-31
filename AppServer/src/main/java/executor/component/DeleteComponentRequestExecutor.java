package executor.component;

import aux.component.ComponentBuilder;
import datos.CRUD;
import datos.form.FormularioDAO;
import executor.Executor;
import model.Componente;
import model.Formulario;
import model.solicitudes.Solicitud;

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
                response.append("Eliminando componente en el indice ").append(index+1);
            } else {
                response.append("No existe el componente ").append(component.getId()).append(" en el form ").append(form.getId());
            }
        } else {
            response.append(component.getFormulario()).append("El formulario  no existe");
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
