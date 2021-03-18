package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.controller.TextEditorController;
import com.l2ashdz.appcliente.view.TextEditorView;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static void main(String[] args) {
        TextEditorView textEditorV = new TextEditorView();
        TextEditorController textEditorC = new TextEditorController(textEditorV);
        textEditorC.start();
        
        /*File file = new File("Entrada.txt");
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
        }*/
    }
}
