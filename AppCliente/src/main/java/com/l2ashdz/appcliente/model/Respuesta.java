package com.l2ashdz.appcliente.model;

/**
 *
 * @date 31/03/2021
 * @time 14:01:54
 * @author asael
 */
public class Respuesta {
    
    private String tipoRespuesta;
    private String estado;
    private String message;

    public Respuesta(String tipoRespuesta, String estado, String message) {
        this.tipoRespuesta = tipoRespuesta;
        this.estado = estado;
        this.message = message;
    }

    public Respuesta() {
    }

    public String getTipoRespuesta() {
        return tipoRespuesta;
    }

    public void setTipoRespuesta(String tipoRespuesta) {
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
}
