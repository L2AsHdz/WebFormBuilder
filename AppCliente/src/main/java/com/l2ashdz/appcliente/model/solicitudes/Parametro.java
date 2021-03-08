package com.l2ashdz.appcliente.model.solicitudes;

/**
 *
 * @author asael
 */
public class Parametro {
    
    private String paramName;
    private String paramValue;

    public Parametro() {
    }

    public Parametro(String paramName, String paramValue) {
        this.paramName = paramName;
        this.paramValue = paramValue;
    }

    public String getParamName() {
        return paramName;
    }

    public void setParamName(String paramName) {
        this.paramName = paramName;
    }

    public String getParamValue() {
        return paramValue;
    }

    public void setParamValue(String paramValue) {
        this.paramValue = paramValue;
    }
}
