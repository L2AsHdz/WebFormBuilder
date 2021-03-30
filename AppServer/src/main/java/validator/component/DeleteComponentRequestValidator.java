package validator.component;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;
import validator.Validator;

/**
 *
 * @date 30/03/2021
 * @time 10:49:16
 * @author asael
 */
public class DeleteComponentRequestValidator extends Validator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        boolean id = false;
        boolean form = false;
        
        for (Parametro p : params) {
            switch (getName(p)) {
                case "ID" -> id = true;
                case "FORMULARIO" -> form= true;
            }
        }
        
        if (!id | !form) {
            error.append("El ID y FORMULARIO son parametros obligatorios, linea: ")
                    .append(o.getLinea())
                    .append(", col: ")
                    .append(o.getColumna());
        }
        
        return error.toString();
    }

}
