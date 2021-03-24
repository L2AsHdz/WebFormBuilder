package aux.user;

import java.time.LocalDate;
import model.Usuario;
import model.solicitudes.Parametro;
import model.solicitudes.Solicitud;

/**
 *
 * @date 20/03/2021
 * @time 19:17:56
 * @author asael
 */
public class UserBuilder {

    private final Solicitud solicitud;
    private Usuario usuario;

    public UserBuilder(Solicitud s) {
        this.solicitud = s;
    }

    public Usuario build() {
        String nameUser = "";
        String password = "";
        String fecha = "";

        for (Parametro p : solicitud.getParametros()) {
            String name = p.getName();
            if (name.contains("\"USUARIO\"")) {
                nameUser = p.getValue().replaceAll("\\s", "").replace("\"", "");
            } else if (name.contains("PASSWORD")) {
                password = p.getValue().replaceAll("\\s", "").replace("\"", "");
            } else if (name.contains("FECHA_CREACION")) {
                fecha = p.getValue().replaceAll("\\s", "").replace("\"", "");
            }
        }
        usuario = new Usuario(nameUser, password, fecha);
        if (usuario.getFechaCreacion().isEmpty()) {
            usuario.setFechaCreacion(LocalDate.now().toString());
        }

        return usuario;
    }
    
    public Usuario buildOld() {
        String nameUser = "";
        
        for (Parametro p : solicitud.getParametros()) {
            if (p.getName().contains("USUARIO_ANTIGUO")) {
                nameUser = p.getValue().replace("\"", "").replaceAll("\\s", "");
            }
        }
        usuario = new Usuario();
        usuario.setNombre(nameUser);
        
        return usuario;
    }
    
    public Usuario buildNew() {
        usuario = new Usuario();
        solicitud.getParametros().forEach(p -> {
            if (p.getName().contains("USUARIO_NUEVO")) {
                usuario.setNombre(getValue(p.getValue()));
            } else if (p.getName().contains("NUEVO_PASSWORD")) {
                usuario.setPassword(getValue(p.getValue()));
            } else if (p.getName().contains("MODIFICACION")) {
                usuario.setFechaCreacion(getValue(p.getValue()));
            }
        });
        if (usuario.getFechaCreacion() == null) {
            usuario.setFechaCreacion(LocalDate.now().toString());
        }
        
        return usuario;
    }
    
    private String getValue(String s) {
        return s.replaceAll("\\s", "").replace("\"", "");
    }

}
