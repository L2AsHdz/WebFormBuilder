package aux.solicitud;

import analizadores.lexico.RequestsLexer;
import analizadores.sintactico.RequestsParser;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import model.errores.Error;
import model.solicitudes.Solicitud;

/**
 *
 * @date 19/03/2021
 * @time 15:04:05
 * @author asael
 */
public class RequestAnalyzer {

    private RequestsLexer lex;
    private RequestsParser parser;
    private List<Error> errores = new ArrayList<>();
    private List<Solicitud> solicitudes = new ArrayList<>();

    public RequestAnalyzer() {
    }

    public void analyze(Reader reader) {
        try {
            lex = new RequestsLexer(reader);
            parser = new RequestsParser(lex);
            parser.parse();
            setListados();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }

    public List<Error> getErrores() {
        return errores;
    }

    public List<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    private void setListados() {
        errores.addAll(lex.getErrores());
        errores.addAll(parser.getErrores());
        
        solicitudes = parser.getSolicitudes();
    }
}
