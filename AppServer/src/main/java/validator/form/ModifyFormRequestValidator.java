package validator.form;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;
import validator.Validator;

/**
 *
 * @date 30/03/2021
 * @time 01:25:14
 * @author asael
 */
public class ModifyFormRequestValidator extends Validator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        boolean titulo = false;
        boolean nombre = false;
        boolean tema = false;
        
        for (Parametro p : params) {
            switch (getName(p)) {
                case "TITULO" -> titulo = true;
                case "NOMBRE" -> nombre = true;
                case "TEMA" -> tema = true;
            }
        }
        
        if (!titulo & !nombre & !tema) {
            error.append("Debe ingresarse al menos un parametro a modificar, linea: ")
                    .append(o.getLinea())
                    .append(", col: ")
                    .append(o.getColumna());
        }
        
        return error.toString();
    }
    
}
