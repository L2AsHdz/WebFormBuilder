package aux.solicitud;

import executor.component.ComponentRequestExecutor;
import executor.form.FormRequestExecutor;
import executor.user.LoginRequestExecutor;
import executor.user.UserRequestExecutor;
import generator.response.ResponseStructureGenerator;
import java.io.Reader;
import model.response.Response;

/**
 *
 * @date 20/03/2021
 * @time 13:27:57
 * @author asael
 */
public class RequestExecutor {

    private StringBuilder answer = new StringBuilder();

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
                        case CREATE_USER        -> addLinea(userRE.executeCreateUser(s));
                        case MODIFY_USER        -> addLinea(userRE.executeModifyUser(s));
                        case DELETE_USER        -> addLinea(userRE.executeDeleteUser(s));
                        case NEW_FORM           -> addLinea(formRE.executeCreateForm(s, loggedUser));
                        case EDIT_FORM          -> addLinea(formRE.executeModifyForm(s));
                        case DELETE_FORM        -> addLinea(formRE.executeDeleteForm(s));
                        case NEW_COMPONENT      -> addLinea(componentRE.executeAddComponent(s));
                        case DELETE_COMPONENT   -> addLinea(componentRE.executeDeleteComponent(s));
                        case EDIT_COMPONENT     -> addLinea(componentRE.executeModifyComponent(s));
                        case LOGIN              -> addLinea("\"Ya hay un usuario logueado, cierre sesion primero\"");
                    }
                });
                
                if (solicitudes.size() > 1) {
                    StringBuilder temp = answer;
                    answer = new StringBuilder("<!ini_respuestas>\n");
                    answer.append(temp.toString());
                    addLinea("<!fin_respuestas>");
                }
            } else {
                
                if (errores.size() > 1) {
                    addLinea("<!ini_respuestas>");
                    errores.forEach(e -> addResponse(e.getDescripcion()));
                    addLinea("<!fin_respuestas>");
                } else {
                    errores.forEach(e -> addResponse(e.getDescripcion()));
                }
            }
        } else {
            solicitudes.forEach(s -> {
                var loginRE = new LoginRequestExecutor();
                if ("LOGIN".equals(s.getTipo().name())) {
                    addLinea(loginRE.execute(s));
                }
            });
        }

        return answer.toString();
    }

    private void addLinea(String s) {
        answer.append(s).append("\n");
    }
    
    protected void addResponse(String message) {
        addLinea(new ResponseStructureGenerator(new Response(message)).generate());
    }
}
