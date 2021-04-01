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
 * @time 04:17:44
 * @author asael
 */
public class ModifyComponentRequestExecutor extends Executor {

    private final CRUD<Formulario> formDAO;
    private ComponentBuilder componentBuilder;

    public ModifyComponentRequestExecutor() {
        formDAO = new FormularioDAO();
    }

    @Override
    public String execute(Solicitud s) {
        response = new StringBuilder();

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
                addResponse("Componente " + compForm.getId() + " modificado");
                
            } else {
                addResponse("No existe el componente " + component.getId() + " en el formulario " + form.getId());
            }
            
        } else {
            addResponse("El formulario " + component.getFormulario() + " no existe");
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
