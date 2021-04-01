package com.l2ashdz.appcliente.model;

/**
 *
 * @date 31/03/2021
 * @time 14:01:54
 * @author asael
 */
public class Respuesta {
    
    private String message;
    private String loggedUser;

    public Respuesta(String message) {
        this.message = message;
    }

    public Respuesta() {
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
