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

    public void executeDeleteComponent(Solicitud s) {
        componentBuilder = new ComponentBuilder(s);
        var component = componentBuilder.buildDelete();

        if (formDAO.exists(component.getFormulario())) {
            var form = formDAO.getObject(component.getFormulario());
            int index = indexOfComponent(form, component.getId());
            
            if (index != -1) {
                form.getComponentes().remove(index);
                formDAO.create(form);
                System.out.println("Eliminando componente en el indice " + index);
            } else {
                System.out.println("No existe el componente " + component.getId() + " en el form " + form.getId());
            }
        } else {
            System.out.println("El formulario " + component.getFormulario() + " no existe");
        }
    }
    
    public void executeModifyComponent(Solicitud s) {
        componentBuilder = new ComponentBuilder(s);
        var component = componentBuilder.build();
        
        if (formDAO.exists(component.getFormulario())) {
            var form = formDAO.getObject(component.getFormulario());
            var componentes = form.getComponentes();
            int index = indexOfComponent(form, component.getId());
            
            if (index != -1) {
                var compForm = componentes.get(index);

                if (component.getNombreCampo() != null) compForm.setNombreCampo(component.getNombreCampo());
                if (component.getTextoVisible() != null) compForm.setTextoVisible(component.getTextoVisible());
                if (component.getAlineacion() != null) compForm.setAlineacion(component.getAlineacion());
                if (component.getRequerido() != null) compForm.setRequerido(component.getRequerido());
                if (component.getOpciones() != null) compForm.setOpciones(component.getOpciones());
                if (component.getNoFilas() != null) compForm.setNoFilas(component.getNoFilas());
                if (component.getNoColumnas() != null) compForm.setNoColumnas(component.getNoColumnas());
                if (component.getUrl() != null) compForm.setUrl(component.getUrl());
                
                if (component.getIndice() > 0) {
                    int newIndex = component.getIndice();
                    var compAux = componentes.remove(index);
                    
                    if (newIndex >= componentes.size()) {
                        componentes.add(compAux);
                    } else {
                        componentes.add(newIndex-1, compAux);
                    }
                }
                
                formDAO.create(form);
                System.out.println("Componente " + compForm.getId() + " modificado");
                
            } else {
                System.out.println("No existe el componente " + component.getId() + " en el form " + form.getId());
            }
            
        } else {
            System.out.println("El formulario " + component.getFormulario() + " no existe");
        }
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
