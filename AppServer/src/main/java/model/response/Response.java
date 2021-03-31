package model.response;

/**
 *
 * @date 31/03/2021
 * @time 12:08:04
 * @author asael
 */
public class Response {
    
    private TipoRespuesta tipoRespuesta;
    private String estado;
    private String message;
    private String loggedUser;

    public Response(TipoRespuesta tipoRespuesta, String estado, String message) {
        this.tipoRespuesta = tipoRespuesta;
        this.estado = estado;
        this.message = message;
    }

    public Response(TipoRespuesta tipoRespuesta, String estado, String message, String loggedUser) {
        this.tipoRespuesta = tipoRespuesta;
        this.estado = estado;
        this.message = message;
        this.loggedUser = loggedUser;
    }

    public Response() {
    }

    public TipoRespuesta getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(TipoRespuesta tipoRespuesta) {
        this.tipoRespuesta = tipoRespuesta;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(String loggedUser) {
        this.loggedUser = loggedUser;
    }
    
}
