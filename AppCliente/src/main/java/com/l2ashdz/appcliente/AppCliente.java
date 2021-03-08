package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.analizadores.lexico.Lexer;
import com.l2ashdz.appcliente.analizadores.sintactico.Parser;
import java.io.StringReader;

/**
 *
 * @author asael
 */
public class AppCliente {

    public static void main(String[] args) {
        
        StringReader str = new StringReader("""
                                            graficar circulo ( 25 + 12, 12, 15/3, rojo)
                                            graficar circulo ( 25 + 12, 12, 15/3, azul)
                                            animar objeto anterior (69/3,2*5,curva)
                                            graficar cuadrado ( 12*3, 15+1, (15-3) / 4, verde)
                                            animar objeto anterior (69/3,2*5,curva)
                                            graficar rectangulo ( 12 * 3 + 2, 15, 4 / 4, 25, negro)
                                            animar objeto anterior (69/3,2*5,curva)
                                            graficar linea ( 12 *3 + 2, 15, 4 / 4, 50 * 1, amarillo)
                                            graficar linea ( 12 *3 + 2, 15, 4 / 4, 50 * 1, cafe)
                                            animar objeto anterior (69/3,2*5,curva)
                                            graficar poligono (1,     2,3,((25+(35)-62+6)*1)+1,5,rojo)
                                            animar objeto anterior (69/3,2*5,linea)""");

        Lexer lex = new Lexer(str);
        Parser parser = new Parser(lex);
    }
}
