package executor;

import model.solicitudes.Solicitud;

/**
 *
 * @date 31/03/2021
 * @time 02:51:37
 * @author asael
 */
public abstract class Executor {

    protected StringBuilder response;
    
    public abstract String execute(Solicitud s);
}
