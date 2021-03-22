package aux.form;

import java.time.LocalDate;
import model.Formulario;
import model.solicitudes.Parametro;
import model.solicitudes.Solicitud;

/**
 *
 * @date 22/03/2021
 * @time 00:39:20
 * @author asael
 */
public class FormBuilder {

    private final Solicitud solicitud;
    private final String loggedUser;
    private Formulario form;

    public FormBuilder(Solicitud solicitud, String loggedUser) {
        this.solicitud = solicitud;
        this.loggedUser = loggedUser;
    }

    public Formulario build() {
        String id = "";
        String titulo = "";
        String nombre = "";
        String tema = "";
        String usuarioCreacion = "";
        String fechaCreacion = "";

        for (Parametro p : solicitud.getParametros()) {
            if (p.getName().contains("ID")) {
                id = obtenerValor(p.getValue());
            } else if (p.getName().contains("TITULO")) {
                titulo = p.getValue().replace("\"", "");
            } else if (p.getName().contains("NOMBRE")) {
                nombre = obtenerValor(p.getValue());
            } else if (p.getName().contains("TEMA")) {
                tema = obtenerValor(p.getValue());
            } else if (p.getName().contains("USUARIO_CREACION")) {
                usuarioCreacion = obtenerValor(p.getValue());
            } else if (p.getName().contains("FECHA_CREACION")) {
                fechaCreacion = obtenerValor(p.getValue());
            }
        }
        form = new Formulario(id, titulo, nombre, tema, usuarioCreacion, fechaCreacion);
        if (form.getUsuarioCreacion().isEmpty()) {
            form.setUsuarioCreacion(loggedUser);
        }
        if (form.getFechaCreacion().isEmpty()) {
            form.setFechaCreacion(LocalDate.now().toString());
        }

        return form;
    }

    private String obtenerValor(String s) {
        return s.replaceAll("\\s", "").replace("\"", "");
    }
}
