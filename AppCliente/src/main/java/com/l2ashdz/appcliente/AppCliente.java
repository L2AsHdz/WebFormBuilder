package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.analizadores.lexico.Lexer;
import com.l2ashdz.appcliente.analizadores.sintactico.Parser;
import com.l2ashdz.appcliente.view.EditorTexto;
import java.io.StringReader;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static void main(String[] args) {
        EditorTexto et = new EditorTexto();
        et.setLocationRelativeTo(null);
        et.setVisible(true);
    }
}
