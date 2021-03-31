package model.errores;

/**
 *
 * @date 31/03/2021
 * @time 02:07:44
 * @author asael
 */
public class Error {

    private String descripcion;

    public Error() {
    }

    public Error(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
