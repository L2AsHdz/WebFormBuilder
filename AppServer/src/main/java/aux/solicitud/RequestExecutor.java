package aux.solicitud;

import aux.component.ComponentRequestExecutor;
import aux.form.FormRequestExecutor;
import aux.user.LoginRequestExecutor;
import aux.user.UserRequestExecutor;
import java.io.Reader;

/**
 *
 * @date 20/03/2021
 * @time 13:27:57
 * @author asael
 */
public class RequestExecutor {

    private String answer = "";

    public RequestExecutor() {
    }

    public String run(Reader reader, String loggedUser) {

        var analyzer = new RequestAnalyzer();
        analyzer.analyze(reader);

        var errores = analyzer.getErrores();
        var solicitudes = analyzer.getSolicitudes();

        if (!loggedUser.trim().isEmpty()) {
            if (errores.isEmpty()) {

                var userRE = new UserRequestExecutor();
                var formRE = new FormRequestExecutor();
                var componentRE = new ComponentRequestExecutor();

                solicitudes.forEach(s -> {
                    switch (s.getTipo()) {
                        case CREATE_USER        -> userRE.executeCreateUser(s);
                        case MODIFY_USER        -> userRE.executeModifyUser(s);
                        case DELETE_USER        -> userRE.executeDeleteUser(s);
                        case NEW_FORM           -> formRE.executeCreateForm(s, loggedUser);
                        case EDIT_FORM          -> formRE.executeModifyForm(s);
                        case DELETE_FORM        -> formRE.executeDeleteForm(s);
                        case NEW_COMPONENT      -> componentRE.executeAddComponent(s);
                        case DELETE_COMPONENT   -> componentRE.executeDeleteComponent(s);
                        case EDIT_COMPONENT     -> componentRE.executeModifyComponent(s);
                        case LOGIN              -> System.out.println("Ya hay un usuario logueado, cierre sesion primero");
                    }
                });
            } else {
                errores.forEach(e -> addLinea(e.getDescripcion()));
            }
        } else {
            solicitudes.forEach(s -> {
                var loginRE = new LoginRequestExecutor();
                if ("LOGIN".equals(s.getTipo().name())) {
                    loginRE.executeLogin(s);
                }
            });
        }

        return answer;
    }

    private void addLinea(String s) {
        answer += s + "\n";
    }
}
