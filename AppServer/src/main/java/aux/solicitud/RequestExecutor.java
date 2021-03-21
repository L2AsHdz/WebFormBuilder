package aux.solicitud;

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

                solicitudes.forEach(s -> {
                    switch (s.getTipo()) {
                        case CREATE_USER -> {
                            userRE.executeCreateUser(s);
                        }
                        case MODIFY_USER -> {
                        }
                        case DELETE_USER -> {
                        }
                    }
                });
            } else {
                errores.forEach(e -> addLinea(e.getLexema() + "- " + e.getDescripcion() + " Linea: " + e.getLinea() + " Columna: " + e.getColumna()));
            }
        } else {
            //Ignorar solicitudes e informar que no esta logeado
        }

        return answer;
    }

    private void addLinea(String s) {
        answer += s + "\n";
    }
}
