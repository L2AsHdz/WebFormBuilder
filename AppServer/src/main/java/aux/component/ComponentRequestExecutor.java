package aux.component;

import datos.CRUD;
import datos.form.FormularioDAO;
import model.Formulario;
import model.solicitudes.Solicitud;

/**
 *
 * @date 26/03/2021
 * @time 00:40:00
 * @author asael
 */
public class ComponentRequestExecutor {

    private final CRUD<Formulario> formDAO;
    private ComponentBuilder componentBuilder;
    
    public ComponentRequestExecutor() {
        formDAO = new FormularioDAO();
    }
    
    public void executeAddComponent(Solicitud s) {
        componentBuilder = new ComponentBuilder(s);
        var component = componentBuilder.build();
        
        if (formDAO.exists(component.getFormulario())) {
            var form  = formDAO.getObject(component.getFormulario());
            
            form.getComponentes().add(component);
            System.out.println("Componente " + component.getId() + " agregado al form " + form.getId());
        } else {
            System.out.println("No existe el formulario indicado en el componente");
        }
    }
}
