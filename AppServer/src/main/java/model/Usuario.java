package model;

/**
 *
 * @date 20/03/2021
 * @time 18:54:03
 * @author asael
 */
public class Usuario {
    
    private String nombre;
    private String password;
    private String fechaCreacion;

    public Usuario() {
    }

    public Usuario(String nombre, String password, String fechaCreacion) {
        this.nombre = nombre;
        this.password = password;
        this.fechaCreacion = fechaCreacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }
}
