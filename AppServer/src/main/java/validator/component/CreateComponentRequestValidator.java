package validator.component;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;
import validator.Validator;

/**
 *
 * @date 30/03/2021
 * @time 10:43:29
 * @author asael
 */
public class CreateComponentRequestValidator extends Validator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        boolean id = false;
        boolean form = false;
        boolean clase = false;
        boolean textV = false;
        
        for (Parametro p : params) {
            switch (getName(p)) {
                case "ID" -> id = true;
                case "FORMULARIO" -> form= true;
                case "CLASE" -> clase = true;
                case "TEXTO_VISIBLE" -> textV = true;
            }
        }
        
        if (!id | !form | !clase | !textV) {
            error.append("Faltan parametros obligatorios en la solicitud, linea: ")
                    .append(o.getLinea())
                    .append(", col: ")
                    .append(o.getColumna());
        }
        
        return error.toString();
    }

}
