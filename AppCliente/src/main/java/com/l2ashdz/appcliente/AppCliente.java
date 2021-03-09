package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.analizadores.lexico.Lexer;
import com.l2ashdz.appcliente.analizadores.sintactico.Parser;
import com.l2ashdz.appcliente.model.errores.ErrorAnalisis;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static void main(String[] args) {
        
        StringReader str = new StringReader("""
                                            <!ini_solicitud:"ELIMINAR_USUARIO">
                                                  { "CREDENCIALES_USUARIO":[{
                                                        "USUARIO": "juanito619lopez"
                                                       }         
                                                     ]
                                                  }
                                            <fin_solicitud!>""");

        Lexer lex = new Lexer(str);
        Parser parser = new Parser(lex);
        
        try {
            parser.parse();
        } catch (Exception e) {
            e.printStackTrace(System.out);
        }
        
        List<ErrorAnalisis> errores = new ArrayList();
        errores.addAll(lex.getErrores());
        errores.addAll(parser.getErrores());
        errores.forEach(e -> System.out.println(e.getLexema() + " - " + e.getDescripcion() + " - " + e.getTipoError()));
    }
}