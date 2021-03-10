package com.l2ashdz.appcliente;

import com.l2ashdz.appcliente.analizadores.lexico.Lexer;
import com.l2ashdz.appcliente.analizadores.sintactico.Parser;
import com.l2ashdz.appcliente.model.errores.ErrorAnalisis;
import com.l2ashdz.appcliente.model.solicitudes.Solicitud;
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
                                            <!ini_solicitudes>
                                                <!ini_solicitud:"ELIMINAR_USUARIO">
                                                      { "CREDENCIALES_USUARIO":[{
                                                            "USUARIO": "userEliminar"
                                                           }         
                                                         ]
                                                      }
                                                <fin_solicitud!>
                                                <!ini_solicitud:"CREAR_USUARIO">
                                                      { "CREDENCIALES_USUARIO":[{
                                                            "USUARIO": "neuvoUsuario",
                                                            "PASSWORD": "password"
                                                           }         
                                                         ]
                                                      }
                                                <fin_solicitud!>
                                                <!ini_solicitud:"LOGIN_USUARIO">
                                                    { "CREDENCIALES_USUARIO":[{
                                                           "USUARIO": "AsaelLogin",
                                                           "PASSWORD": "123321"
                                                          },
                                                        {
                                                        "USUARIO": "Login2doBloque",
                                                        "PASSWORD": "22222222"
                                                       }        
                                                        ]
                                                     }      
                                               <fin_solicitud!>
                                                <!ini_solicitud:"MODIFICAR_USUARIO">
                                                      { "CREDENCIALES_USUARIO":[{
                                                            "USUARIO_ANTIGUO": "junito",
                                                            "USUARIO_NUEVO": "juanitoNuevo",
                                                            "NUEVO_PASSWORD": "12345678910"
                                                           }         
                                                         ]
                                                      }
                                                <fin_solicitud!>
                                                <!ini_solicitud:"LOGIN_USUARIO">
                                                     { "CREDENCIALES_USUARIO":[{
                                                            "USUARIO": "loginUser",
                                                            "PASSWORD": "12345678"
                                                           }         
                                                         ]
                                                      }      
                                                <fin_solicitud!>
                                                <!ini_solicitud:"ELIMINAR_USUARIO">
                                                    { "CREDENCIALES_USUARIO":[{
                                                        "USUARIO": "userEliminar2"
                                                        },
                                                        { "USUARIO" : "userEliminar2doBloque"
                                                         }
                                                    ]
                                                     }
                                                <fin_solicitud!>
                                            <!fin_solicitudes>""");

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

        List<Solicitud> solicitudes = parser.getSolicitudes();
        
        
        if (errores.isEmpty()) {
            solicitudes.forEach(s -> {
                System.out.println("\nSolicitud tipo: " + s.getTipo());
                s.getParametros().forEach(param -> System.out.println("\t" + param.getName() + " : " + param.getValue()));
            });
        } else {
            errores.forEach(e -> System.out.println(e.getLexema() + " - " + e.getDescripcion() + " Linea: " + e.getLinea() + " Columna: " + e.getColumna()));
        }
    }
    
    
}
