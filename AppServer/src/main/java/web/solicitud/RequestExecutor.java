package web.solicitud;

import java.io.Reader;
import java.util.List;
import model.errores.ErrorAnalisis;
import model.solicitudes.Solicitud;

/**
 *
 * @date 20/03/2021
 * @time 13:27:57
 * @author asael
 */
public class RequestExecutor {

    public RequestExecutor() {
    }

    public String run(Reader reader, String loggedUser) {
        String answer = "";

        RequestAnalyzer analyzer = new RequestAnalyzer();
        analyzer.analyze(reader);

        List<ErrorAnalisis> errores = analyzer.getErrores();
        List<Solicitud> solicitudes = analyzer.getSolicitudes();
        
        if (!loggedUser.trim().isEmpty()) {
            answer += "Usuario logeado: " + loggedUser;
        } else {
            //Ignorar solicitudes e informar que no esta logeado
        }

        return answer;
    }
}
