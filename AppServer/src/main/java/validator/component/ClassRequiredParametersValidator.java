package validator.component;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;

/**
 *
 * @date 30/03/2021
 * @time 19:25:58
 * @author asael
 */
public class ClassRequiredParametersValidator extends ClassParameterValidator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        String clase = "";
        boolean nombreC = false;
        boolean filas = false;
        boolean cols = false;
        boolean options = false;
        boolean url = false;
        
        for (Parametro p : params) {
            switch (getClass(p)) {
                
                case "CAMPO_TEXTO", "FICHERO" -> {
                    clase = getClass(p);
                    for (Parametro pr : params) {
                        switch (getName(pr)) {
                            case "NOMBRE_CAMPO" -> nombreC = true;
                        }
                    }
                }
                
                case "CHECKBOX", "RADIO", "COMBO" -> {
                    clase = getClass(p);
                    for (Parametro pr : params) {
                        switch (getName(pr)) {
                            case "NOMBRE_CAMPO" -> nombreC = true;
                            case "OPCIONES" -> options = true; 
                        }
                    }
                }
                
                case "AREA_TEXTO" -> {
                    clase = getClass(p);
                    for (Parametro pr : params) {
                        switch (getName(pr)) {
                            case "NOMBRE_CAMPO" -> nombreC = true;
                            case "FILAS" -> filas = true;
                            case "COLUMNAS" -> cols= true;
                        }
                    }
                }
                
                case "IMAGEN" -> {
                    clase = getClass(p);
                    for (Parametro pr : params) {
                        switch (getName(pr)) {
                            case "URL" -> url = true;
                        }
                    }
                }
                
            }
        }
        
        switch (clase) {
            case "CAMPO_TEXTO", "FICHERO" -> {
                if (!nombreC) {
                    setMSG("El parametro NOMBRE_CAMPO es obligatorio", o);
                }
            }
            
            case "CHECKBOX", "RADIO", "COMBO" -> {
                if (!nombreC | !options) {
                    setMSG("Los parametros NOMBRE_CAMPO y OPCIONES son obligatorios", o);
                }
            }
            
            case "AREA_TEXTO" -> {
                if (!nombreC | !filas | !cols) {
                    setMSG("Faltan parametros obligatorios para la clase AREA_TEXTO", o);
                }
            }
            
            case "IMAGEN" -> {
                if (!url) {
                    setMSG("El parametro URL es obligatorio", o);
                }
            }
        }
        
        return error.toString();
    }
    
    private void setMSG(String s, Token o) {
        error.append(s)
                .append(", linea: ")
                .append(o.getLinea())
                .append(", col: ")
                .append(o.getColumna());
    }

}
