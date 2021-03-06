package generator.form;

import generator.Generator;
import model.Formulario;

/**
 *
 * @date 22/03/2021
 * @time 01:08:45
 * @author asael
 */
public class FormStorageStructureGenerator extends Generator {
    
    private Formulario form;

    public FormStorageStructureGenerator(Formulario form) {
        this.form = form;
    }

    @Override
    public String generate() {
        text = new StringBuilder();
        addLine("db.form(", 0);
        addLine("{", 1);
        addLine("\"ID\" : \"" + form.getId() + "\",", 2);
        addLine("\"TITULO\" : \"" + form.getTitulo() + "\",", 2);
        addLine("\"NOMBRE\" : \"" + form.getNombre() + "\",", 2);
        addLine("\"TEMA\" : \"" + form.getTema() + "\",", 2);
        addLine("\"USUARIO_CREACION\" : \"" + form.getUsuarioCreacion() + "\",", 2);
        addLine("\"FECHA_CREACION\" : \"" + form.getFechaCreacion() + "\",", 2);
        agregarComponentes(form);
        addLine("}", 1);
        addLine(")", 0);

        return text.toString();
    }

    private void agregarComponentes(Formulario form) {
        addLine("\"COMPONENTES\" : (", 2);
        form.getComponentes().forEach(c -> {
            addLine("{", 3);
            addLine("\"ID\" : \""+c.getId()+"\",", 4);
            if (c.getNombreCampo() != null) addLine("\"NOMBRE_CAMPO\" : \""+c.getNombreCampo()+"\",", 4);
            addLine("\"TEXTO_VISIBLE\" : \""+c.getTextoVisible()+"\",", 4);
            if (c.getAlineacion() != null) addLine("\"ALINEACION\" : \""+c.getAlineacion()+"\",", 4);
            if (c.getRequerido() != null) addLine("\"REQUERIDO\" : \""+c.getRequerido()+"\",", 4);
            addLine("\"CLASE\" : \""+c.getClase()+"\",", 4);
            if (c.getOpciones() != null) addLine("\"OPCIONES\" : \""+c.getOpciones()+"\",", 4);
            if (c.getNoFilas() != null) addLine("\"FILAS\" : \""+c.getNoFilas()+"\",", 4);
            if (c.getNoColumnas() != null) addLine("\"COLUMNAS\" : \""+c.getNoColumnas()+"\",", 4);
            if (c.getUrl() != null) addLine("\"URL\" : \""+c.getUrl()+"\",", 4);
            text.deleteCharAt(text.lastIndexOf(","));
            addLine("},", 3);
        });
        if (!form.getComponentes().isEmpty()) text.deleteCharAt(text.lastIndexOf(","));
        addLine(")", 2);
    }
}
