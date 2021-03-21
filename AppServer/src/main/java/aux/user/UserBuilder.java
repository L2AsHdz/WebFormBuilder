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

    public Usuario buildUser() {
        String nameUser = "";
        String password = "";
        String fecha = "";

        for (Parametro p : solicitud.getParametros()) {
            if (p.getName().contains("USUARIO")) {
                nameUser = p.getValue().replaceAll("\\s", "").replace("\"", "");
            } else if (p.getName().contains("PASSWORD")) {
                password = p.getValue().replaceAll("\\s", "").replace("\"", "");
            } else if (p.getName().contains("FECHA_CREACION")) {
                fecha = p.getValue().replaceAll("\\s", "").replace("\"", "");
            }
        }
        usuario = new Usuario(nameUser, password, fecha);
        if (usuario.getFechaCreacion().isEmpty()) {
            usuario.setFechaCreacion(LocalDate.now().toString());
        }

        return usuario;
    }

}
