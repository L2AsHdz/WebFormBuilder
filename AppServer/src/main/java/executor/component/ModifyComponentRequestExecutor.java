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
        var comp = componentBuilder.build();
        
        if (formDAO.exists(comp.getFormulario())) {
            var form = formDAO.getObject(comp.getFormulario());
            var componentes = form.getComponentes();
            int index = indexOfComponent(form, comp.getId());
            
            if (index != -1) {
                boolean canCreated = true;
                boolean hasFieldName = comp.getNombreCampo()!= null;
                boolean hasVisibleText = comp.getTextoVisible()!= null;
                boolean hasAlignment = comp.getAlineacion()!= null;
                boolean hasRequired = comp.getRequerido()!= null;
                boolean hasOptions = comp.getOpciones() != null;
                boolean hasRows = comp.getNoFilas()!= null;
                boolean hasColumns = comp.getNoColumnas()!= null;
                boolean hasURL = comp.getUrl()!= null;
                var compForm = componentes.get(index);

                if (comp.getClase() != null) {
                    if (hasFieldName) compForm.setNombreCampo(comp.getNombreCampo());
                    if (hasVisibleText) compForm.setTextoVisible(comp.getTextoVisible());
                    if (hasAlignment) compForm.setAlineacion(comp.getAlineacion());
                    if (hasRequired) compForm.setRequerido(comp.getRequerido());
                    if (hasOptions) compForm.setOpciones(comp.getOpciones());
                    if (hasRows) compForm.setNoFilas(comp.getNoFilas());
                    if (hasColumns) compForm.setNoColumnas(comp.getNoColumnas());
                    if (hasURL) compForm.setUrl(comp.getUrl());
                    compForm.setClase(comp.getClase());
                    System.out.println("Nuevo componente");
                } else {
                    
                    switch (compForm.getClase()) {
                        case "CAMPO_TEXTO", "FICHERO" -> {
                            if (hasOptions | hasRows | hasColumns | hasURL) {
                                canCreated = false;
                                addResponse("No se puede modificar el componente " + compForm.getId() + " se ingresaron parametros que no coinciden con la clase " + compForm.getClase());
                            }
                        }
                        
                        case "CHECKBOX", "RADIO", "COMBO" -> {
                            if (hasRows | hasColumns | hasURL) {
                                canCreated = false;
                                addResponse("No se puede modificar el componente " + compForm.getId() + " se ingresaron parametros que no coinciden con la clase " + compForm.getClase());
                            } else {
                                if (hasOptions) compForm.setOpciones(comp.getOpciones());
                            }
                        }
                        
                        case "AREA_TEXTO" -> {
                            if (hasURL | hasOptions) {
                                canCreated = false;
                                addResponse("No se puede modificar el componente " + compForm.getId() + " se ingresaron parametros que no coinciden con la clase " + compForm.getClase());
                            } else {
                                if (hasRows) compForm.setNoFilas(comp.getNoFilas());
                                if (hasColumns) compForm.setNoColumnas(comp.getNoColumnas());
                            }
                        }
                        
                        case "IMAGEN" -> {
                            if (hasOptions | hasRows | hasColumns | hasFieldName | hasRequired) {
                                canCreated = false;
                                addResponse("No se puede modificar el componente " + compForm.getId() + " se ingresaron parametros que no coinciden con la clase " + compForm.getClase());
                            } else {
                                if (hasURL) compForm.setUrl(comp.getUrl());
                            }
                        }
                        
                        case "BOTON" -> {
                            if (hasOptions | hasRows | hasColumns | hasFieldName | hasRequired | hasURL) {
                                canCreated = false;
                                addResponse("No se puede modificar el componente " + compForm.getId() + " se ingresaron parametros que no coinciden con la clase " + compForm.getClase());
                            }
                        }
                    }
                    
                    switch (compForm.getClase()) {
                        case "CAMPO_TEXTO", "FICHERO", "CHECKBOX", "RADIO", "COMBO", "AREA_TEXTO" -> {
                            if (hasFieldName) compForm.setNombreCampo(comp.getNombreCampo());
                            if (hasVisibleText) compForm.setTextoVisible(comp.getTextoVisible());
                            if (hasAlignment) compForm.setAlineacion(comp.getAlineacion());
                            if (hasRequired) compForm.setRequerido(comp.getRequerido());
                            
                        }
                        case "IMAGEN", "BOTON" -> {
                            if (hasVisibleText) compForm.setTextoVisible(comp.getTextoVisible());
                            if (hasAlignment) compForm.setAlineacion(comp.getAlineacion());
                        }
                    }
                }
                
                
                if (comp.getIndice() > 0) {
                    int newIndex = comp.getIndice();
                    var compAux = componentes.remove(index);
                    System.out.println(compAux.toString());
                    
                    if (newIndex >= componentes.size()) {
                        componentes.add(compAux);
                    } else {
                        componentes.add(newIndex-1, compAux);
                    }
                }
                
                if (canCreated) {
                    formDAO.create(form);
                    addResponse("Componente " + compForm.getId() + " modificado");
                }
                
            } else {
                addResponse("No existe el componente " + comp.getId() + " en el formulario " + form.getId());
            }
            
        } else {
            addResponse("El formulario " + comp.getFormulario() + " no existe");
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
