package executor;

import generator.response.ResponseStructureGenerator;
import model.response.Response;
import model.response.TipoRespuesta;
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
    
    protected void addResponse(TipoRespuesta tipoResp, String estate, String message) {
        response.append(new ResponseStructureGenerator(new Response(tipoResp, estate, message)).generate());
    }
}
