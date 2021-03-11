package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.analizadores.lexico.Lexer;
import com.l2ashdz.appcliente.analizadores.sintactico.Parser;
import com.l2ashdz.appcliente.model.errores.ErrorAnalisis;
import com.l2ashdz.appcliente.model.solicitudes.Solicitud;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static void main(String[] args) {
        
        File file = new File("Entrada.txt");
        FileReader fileR;
        Lexer lex = null;
        Parser parser = null;
        
        try {
            fileR = new FileReader(file);

            lex = new Lexer(fileR);
            parser = new Parser(lex);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        List<ErrorAnalisis> errores = new ArrayList();
        
        errores.addAll(lex.getErrores());
        errores.addAll(parser.getErrores());

        List<Solicitud> solicitudes = parser.getSolicitudes();
        
        
        if (errores.isEmpty()) {
            solicitudes.forEach(s -> {
                System.out.println("\nSolicitud tipo: " + s.getTipo());
                s.getParametros().forEach(param -> System.out.println("\t" + param.getName() + " : " + param.getValue()));
            });
        } else {
            errores.forEach(e -> System.out.println(e.getLexema() + "- " + e.getDescripcion() + " Linea: " + e.getLinea() + " Columna: " + e.getColumna()));
        }
    }
    
    
}
