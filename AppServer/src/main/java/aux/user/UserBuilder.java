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
            if (name.contains("USUARIO") | name.contains("USUARIO_NUEVO")) {
                nameUser = p.getValue().replaceAll("\\s", "").replace("\"", "");
            } else if (name.contains("PASSWORD") | name.contains("NUEVO_PASSWORD")) {
                password = p.getValue().replaceAll("\\s", "").replace("\"", "");
            } else if (name.contains("FECHA_CREACION") | name.contains("MODIFICACION")) {
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
