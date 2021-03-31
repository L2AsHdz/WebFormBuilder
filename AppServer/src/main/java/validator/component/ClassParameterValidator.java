package validator.component;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;
import validator.Validator;

/**
 *
 * @date 30/03/2021
 * @time 16:50:48
 * @author asael
 */
public class ClassParameterValidator extends Validator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        String msgError = "Hay parametros que no son aceptados por la clase indicada, linea: " + o.getLinea() + ", col: " + o.getColumna();

        params.forEach(p -> {
            switch (getClass(p)) {
                
                case "CAMPO_TEXTO", "FICHERO" -> {
                    params.forEach(p2 -> {
                        switch (getName(p2)) {
                            case "OPCIONES", "FILAS", "COLUMNAS", "URL" -> error.append(msgError);
                        }
                    });
                }
                
                case "CHECKBOX", "RADIO", "COMBO" -> {
                    params.forEach(p2 -> {
                        switch (getName(p2)) {
                            case "FILAS", "COLUMNAS", "URL" -> error.append(msgError);
                        }
                    });
                }
                
                case "AREA_TEXTO" -> {
                    params.forEach(p2 -> {
                        switch (getName(p2)) {
                            case "OPCIONES", "URL" -> {
                                error.append("Hay parametros que no coinciden con la clase AREA_TEXTO")
                                        .append(", linea: ")
                                        .append(o.getLinea())
                                        .append(", col: ")
                                        .append(o.getColumna());
                            }
                        }
                    });
                }
                
                case "IMAGEN" -> {
                    params.forEach(p2 -> {
                        switch (getName(p2)) {
                            case "OPCIONES", "FILAS", "COLUMNAS", "NOMBRE_CAMPO" -> {
                                error.append("Hay parametros que no coinciden con la clase IMAGEN")
                                        .append(", linea: ")
                                        .append(o.getLinea())
                                        .append(", col: ")
                                        .append(o.getColumna());
                            }
                        }
                    });
                }
                
                case "BOTON" -> {
                    params.forEach(p2 -> {
                        switch (getName(p2)) {
                            case "OPCIONES", "URL", "FILAS", "COLUMNAS", "NOMBRE_CAMPO", "REQUERIDO" -> {
                                error.append("Hay parametros que no coinciden con la clase BOTON")
                                        .append(", linea: ")
                                        .append(o.getLinea())
                                        .append(", col: ")
                                        .append(o.getColumna());
                            }
                        }
                    });
                }
            }
        });

        return error.toString();
    }

    private String getClass(Parametro p) {
        return p.getValue().replace("\"", "").replaceAll("\\s", "");
    }
}
