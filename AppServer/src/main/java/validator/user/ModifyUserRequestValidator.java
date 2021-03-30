package validator.user;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;
import validator.Validator;

/**
 *
 * @date 30/03/2021
 * @time 00:57:01
 * @author asael
 */
public class ModifyUserRequestValidator extends Validator {

    @Override
    public String validate(Token o, List<Parametro> params) {
        error = new StringBuilder("");
        boolean oldUser = false;
        boolean newPass = false;
        boolean newUser = false;
        
        for (Parametro p : params) {
            switch (getName(p)) {
                case "USUARIO_ANTIGUO" -> oldUser = true;
                case "USUARIO_NUEVO" -> newUser = true;
                case "NUEVO_PASSWORD" -> newPass = true;
            }
        }
        
        if (!oldUser | !newPass | !newUser) {
            error.append("Faltan parametros obligatorios en la solicitud, linea: ")
                    .append(o.getLinea())
                    .append(", col: ")
                    .append(o.getColumna());
        }
        
        return error.toString();
    }

}
