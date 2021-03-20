package web.solicitud;

import java.io.Reader;
import java.util.List;
import model.errores.ErrorAnalisis;
import model.solicitudes.Solicitud;
import model.solicitudes.TipoSolicitud;

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

        RequestAnalyzer analyzer = new RequestAnalyzer();
        analyzer.analyze(reader);

        List<ErrorAnalisis> errores = analyzer.getErrores();
        List<Solicitud> solicitudes = analyzer.getSolicitudes();

        if (!loggedUser.trim().isEmpty()) {
            if (errores.isEmpty()) {
                solicitudes.forEach(s -> {
                    if (s.getTipo().equals(TipoSolicitud.CREATE_USER)) {
                        addLinea("\nSolicitud tipo: " + s.getTipo());
                        s.getParametros().forEach(param -> addLinea("\t" + param.getName() + " : " + param.getValue()));
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
