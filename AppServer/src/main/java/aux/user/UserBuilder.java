package aux.user;

import java.util.ArrayList;
import java.util.List;
import model.Usuario;
import model.solicitudes.Parametro;
import model.solicitudes.Solicitud;
import model.solicitudes.TipoSolicitud;

/**
 *
 * @date 20/03/2021
 * @time 19:17:56
 * @author asael
 */
public class UserBuilder {

    private List<Solicitud> solicitudes;
    private List<Usuario> usuarios = new ArrayList();

    public UserBuilder(List<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public List<Usuario> buildUsers() {
        String nameUser = "";
        String password = "";
        String fecha = "";

        for (Solicitud s : solicitudes) {
            if (s.getTipo().equals(TipoSolicitud.CREATE_USER)) {
                for (Parametro p : s.getParametros()) {
                    if (p.getName().contains("USUARIO")) {
                        nameUser = p.getValue().replaceAll("\\s", "");
                    } else if (p.getName().contains("PASSWORD")) {
                        password = p.getValue().replaceAll("\\s", "");
                    } else if (p.getName().contains("FECHA_CREACION")) {
                        fecha = p.getValue().replaceAll("\\s", "");
                    }
                }
                usuarios.add(new Usuario(nameUser, password, fecha));
            }
        }

        return usuarios;
    }

}
