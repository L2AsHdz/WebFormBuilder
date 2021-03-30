package validator.form;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;
import validator.Validator;

/**
 *
 * @date 30/03/2021
 * @time 01:14:53
 * @author asael
 */
public class CreateFormRequestValidator extends Validator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        boolean id = false;
        boolean titulo = false;
        boolean nombre = false;
        boolean tema = false;
        
        for (Parametro p : params) {
            switch (getName(p)) {
                case "ID" -> id = true;
                case "TITULO" -> titulo = true;
                case "NOMBRE" -> nombre = true;
                case "TEMA" -> tema = true;
            }
        }
        
        if (!id | !titulo | !nombre | !tema) {
            error.append("Faltan parametros obligatorios en la solicitud, linea: ")
                    .append(o.getLinea())
                    .append(", col: ")
                    .append(o.getColumna());
        }
        
        return error.toString();
    }

}
