package com.l2ashdz.appcliente.aux;

import com.l2ashdz.appcliente.analizador.lexico.ResponseLexer;
import com.l2ashdz.appcliente.analizador.sintactico.ResponseParser;
import com.l2ashdz.appcliente.model.Respuesta;
import java.io.Reader;
import java.util.List;

/**
 *
 * @date 31/03/2021
 * @time 16:58:47
 * @author asael
 */
public class ResponseAnalyzer {
    
    private ResponseLexer lexer;
    private ResponseParser parser;
    private List<Respuesta> respuestas;
    private String loggedUser;

    public ResponseAnalyzer() {
    }

    public void analyze(Reader reader) {
        try {
            lexer = new ResponseLexer(reader);
            parser = new ResponseParser(lexer);
            parser.parse();
            respuestas = parser.getRespuestas();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
    }
    
    public String getMessages() {
        StringBuilder messages = new StringBuilder();
        
        respuestas.forEach(r -> {
            if ("LOGIN_USUARIO".equals(r.getTipoRespuesta())) {
                loggedUser = "obtener usuario de respuestas";
            } else {
                messages.append("");
            }
        });
        
        return messages.toString();
    }

    public String getLoggedUser() {
        return loggedUser;
    }
    
    
}
