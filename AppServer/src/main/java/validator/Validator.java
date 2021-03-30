package validator;

import java.util.List;
import model.Token;
import model.solicitudes.Parametro;

/**
 *
 * @date 29/03/2021
 * @time 21:08:01
 * @author asael
 */
public abstract class Validator {

    public abstract String validate(Token openBrace, List<Parametro> params);
    
    protected String getName(Parametro p) {
        return p.getName().replace("\"", "").replaceAll("\\s", "");
    }
}
