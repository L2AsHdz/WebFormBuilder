package aux.component;

import model.Componente;
import model.solicitudes.Parametro;
import model.solicitudes.Solicitud;

/**
 *
 * @date 26/03/2021
 * @time 00:43:26
 * @author asael
 */
public class ComponentBuilder {

    private final Solicitud solicitud;
    private Componente component;

    public ComponentBuilder(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    
    public Componente build() {
        component = new Componente();
        
        solicitud.getParametros().forEach(p -> {
            if (p.getName().replaceAll("\\s", "").replace("\"", "").equals("ID")) {
                component.setId(getValue(p));
            } else if (p.getName().contains("NOMBRE_CAMPO")) {
                component.setNombreCampo(getValue(p));
            } else if (p.getName().contains("FORMULARIO")) {
                component.setFormulario(getValue(p));
            } else if (p.getName().contains("TEXTO_VISIBLE")) {
                component.setTextoVisible(p.getValue().replace("\"", ""));
            } else if (p.getName().contains("CLASE")) {
                component.setClase(getValue(p));
            } else if (p.getName().contains("ALINEACION")) {
                component.setAlineacion(getValue(p));
            } else if (p.getName().contains("REQUERIDO")) {
                component.setRequerido(getValue(p));
            } else if (p.getName().contains("OPCIONES")) {
                component.setOpciones(getValue(p));
            } else if (p.getName().contains("FILAS")) {
                component.setNoFilas(getValue(p));
            } else if (p.getName().contains("COLUMNAS")) {
                component.setNoColumnas(getValue(p));
            } else if (p.getName().contains("URL")) {
                component.setUrl(getValue(p));
            } else if (p.getName().contains("INDICE")) {
                component.setIndice(Integer.parseInt(getValue(p)));
            }
        });
        if (component.getAlineacion() == null) {
            component.setAlineacion("IZQUIERDA");
        }
        if (component.getRequerido() == null) {
            component.setRequerido("NO");
        }
        
        return component;
    }
    
    public Componente buildDelete() {
        component = new Componente();
        
        solicitud.getParametros().forEach(p -> {
            if (p.getName().contains("ID")) {
                component.setId(getValue(p));
            } else if (p.getName().contains("FORMULARIO")) {
                component.setFormulario(getValue(p));
            }
        });
        
        return component;
    }
    
    private String getValue(Parametro p) {
        return p.getValue().replaceAll("\\s", "").replace("\"", "");
    }
}
