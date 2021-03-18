package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.analizadores.lexico.ReportsLexer;
import com.l2ashdz.appcliente.analizadores.sintactico.ReportsParser;
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
        
        File file = new File("Entrada2.txt");
        FileReader fileR;
        ReportsLexer lex = null;
        ReportsParser parser = null;
        
        try {
            fileR = new FileReader(file);

            lex = new ReportsLexer(fileR);
            parser = new ReportsParser(lex);
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }

        List<ErrorAnalisis> errores = new ArrayList();
        
        errores.addAll(lex.getErrores());
        errores.addAll(parser.getErrores());
        
        
        if (errores.isEmpty()) {
            System.out.println("Todo nice");
        } else {
            errores.forEach(e -> System.out.println(e.getLexema() + "- " + e.getDescripcion() + " Linea: " + e.getLinea() + " Columna: " + e.getColumna()));
        }
    }
    
    
}
