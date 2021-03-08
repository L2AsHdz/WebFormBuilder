package com.l2ashdz.appcliente.model.solicitudes;

/**
 *
 * @author asael
 */
public class Solicitud {
    
    private TipoSolicitud tipo;
    private Parametro[] parametros;

    public Solicitud() {
    }

    public Solicitud(TipoSolicitud tipo, Parametro[] parametros) {
        this.tipo = tipo;
        this.parametros = parametros;
    }

    public TipoSolicitud getTipo() {
        return tipo;
    }

    public void setTipo(TipoSolicitud tipo) {
        this.tipo = tipo;
    }

    public Parametro[] getParametros() {
        return parametros;
    }

    public void setParametros(Parametro[] parametros) {
        this.parametros = parametros;
    }
}
