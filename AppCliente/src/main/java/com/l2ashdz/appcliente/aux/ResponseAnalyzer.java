package com.l2ashdz.appcliente.aux;

import com.l2ashdz.appcliente.analizador.lexico.ResponseLexer;
import com.l2ashdz.appcliente.analizador.sintactico.ResponseParser;
import com.l2ashdz.appcliente.model.Respuesta;
import java.io.Reader;
import java.io.StringReader;
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
    private StringBuilder messages;

    public ResponseAnalyzer() {
    }

    public void analyze(String s) {
        StringReader reader = new StringReader(s);
        try {
            lexer = new ResponseLexer(reader);
            parser = new ResponseParser(lexer);
            parser.parse();
            respuestas = parser.getRespuestas();
        } catch (Exception e) {
            System.out.println("Entrada vacia");
        }
    }

    public String getMessages() {
        messages = new StringBuilder();

        Respuesta r;
        if (respuestas != null) {
            for (int i = 0; i < respuestas.size(); i++) {
                r = respuestas.get(i);
                if (r.getLoggedUser() != null) {
                    loggedUser = r.getLoggedUser();
                }
                addLinea("Respuesta a solicitud " + (i + 1) + ": " + r.getMessage());
            }
        }

        return messages.toString();
    }

    public String getLoggedUser() {
        return (loggedUser != null) ? loggedUser.replace("\"", "") : "";
    }

    private void addLinea(String s) {
        messages.append(s.replace("\"", "")).append("\n");
    }
}
