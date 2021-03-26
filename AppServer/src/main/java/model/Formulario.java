package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @date 21/03/2021
 * @time 11:43:06
 * @author asael
 */
public class Formulario {

    private String id;
    private String titulo;
    private String nombre;
    private String tema;
    private String usuarioCreacion;
    private String fechaCreacion;
    private List<Componente> componentes;

    public Formulario(String id, String titulo, String nombre, String tema, String usuarioCreacion, String fechaCreacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombre = nombre;
        this.tema = tema;
        this.usuarioCreacion = usuarioCreacion;
        this.fechaCreacion = fechaCreacion;
        this.componentes = new ArrayList();
    }

    public Formulario() {
        this.componentes = new ArrayList();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public List<Componente> getComponentes() {
        return componentes;
    }

    public void setComponentes(List<Componente> componentes) {
        this.componentes = componentes;
    }
}
