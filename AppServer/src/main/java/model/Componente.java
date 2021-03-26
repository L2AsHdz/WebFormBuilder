package model;

/**
 *
 * @date 24/03/2021
 * @time 06:53:37
 * @author asael
 */
public class Componente {

    private String id;
    private String nombreCampo;
    private String formulario;
    private String textoVisible;
    private String alineacion;
    private String requerido;
    private String clase;
    private String opciones;
    private String noFilas;
    private String noColumnas;
    private String url;

    public Componente() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombreCampo() {
        return nombreCampo;
    }

    public void setNombreCampo(String nombreCampo) {
        this.nombreCampo = nombreCampo;
    }

    public String getFormulario() {
        return formulario;
    }

    public void setFormulario(String formulario) {
        this.formulario = formulario;
    }

    public String getTextoVisible() {
        return textoVisible;
    }

    public void setTextoVisible(String textoVisible) {
        this.textoVisible = textoVisible;
    }

    public String getAlineacion() {
        return alineacion;
    }

    public void setAlineacion(String alineacion) {
        this.alineacion = alineacion;
    }

    public String getRequerido() {
        return requerido;
    }

    public void setRequerido(String requerido) {
        this.requerido = requerido;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getOpciones() {
        return opciones;
    }

    public void setOpciones(String opciones) {
        this.opciones = opciones;
    }

    public String getNoFilas() {
        return noFilas;
    }

    public void setNoFilas(String noFilas) {
        this.noFilas = noFilas;
    }

    public String getNoColumnas() {
        return noColumnas;
    }

    public void setNoColumnas(String noColumnas) {
        this.noColumnas = noColumnas;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
