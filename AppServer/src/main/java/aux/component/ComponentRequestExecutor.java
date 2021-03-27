package aux.component;

import datos.CRUD;
import datos.form.FormularioDAO;
import model.Componente;
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
                System.out.println("Componente " + component.getId() + " agregado al form " + form.getId());
            } else {
                System.out.println("El componente ya existe en el form " + form.getId());
            }
        } else {
            System.out.println("No existe el formulario indicado en el componente");
        }
    }
}
